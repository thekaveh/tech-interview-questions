import tempfile
import unittest
from pathlib import Path

import migrate
from migrate import (
    kebab_to_snake, problem_to_snake, new_path_for, package_for,
    title_from_problem, readme_for, REPO, JAVA_ROOT,
)


class TestPathTransforms(unittest.TestCase):
    def test_kebab_to_snake(self):
        self.assertEqual(kebab_to_snake('two-number-sum'), 'two_number_sum')
        self.assertEqual(kebab_to_snake('intro'), 'intro')
        self.assertEqual(kebab_to_snake('a-b-c-d'), 'a_b_c_d')

    def test_problem_to_snake_handles_camelcase_outlier(self):
        self.assertEqual(problem_to_snake('isDigit'), 'is_digit')
        self.assertEqual(problem_to_snake('two-number-sum'), 'two_number_sum')

    def test_new_path_algoexpert(self):
        src = REPO / 'algoexpert.io' / 'easy' / 'two-number-sum' / 'Solution1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'algoexpert' / 'easy' / 'two_number_sum' / 'Solution1.java',
        )

    def test_new_path_algoexpert_very_hard_tier(self):
        src = REPO / 'algoexpert.io' / 'very-hard' / 'foo-bar' / 'Solution2.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'algoexpert' / 'veryhard' / 'foo_bar' / 'Solution2.java',
        )

    def test_new_path_codesignal_filename_renamed(self):
        src = REPO / 'codesignal.com' / 'intro' / 'adjacent-elements-product' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'intro' / 'adjacent_elements_product' / 'Solution1.java',
        )

    def test_new_path_codesignal_the_core(self):
        src = REPO / 'codesignal.com' / 'the-core' / 'apple-boxes' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'thecore' / 'apple_boxes' / 'Solution1.java',
        )

    def test_new_path_codesignal_camelcase_outlier(self):
        src = REPO / 'codesignal.com' / 'intro' / 'isDigit' / 'solution-1.java'
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'codesignal' / 'intro' / 'is_digit' / 'Solution1.java',
        )

    def test_new_path_educative_collapses_patterns_prefix(self):
        src = (REPO / 'educative.io' / 'patterns-for-coding-questions'
               / 'sliding-window' / 'fruits-into-baskets' / 'Solution1.java')
        dest = new_path_for(src)
        self.assertEqual(
            dest,
            JAVA_ROOT / 'educative' / 'patterns' / 'sliding_window' / 'fruits_into_baskets' / 'Solution1.java',
        )

    def test_package_for(self):
        dest = JAVA_ROOT / 'algoexpert' / 'easy' / 'two_number_sum' / 'Solution1.java'
        self.assertEqual(package_for(dest), 'algoexpert.easy.two_number_sum')


class TestReadmeGenerator(unittest.TestCase):
    def test_title_from_problem(self):
        self.assertEqual(title_from_problem('two_number_sum'), 'Two Number Sum')
        self.assertEqual(title_from_problem('is_digit'), 'Is Digit')

    def test_readme_for_algoexpert_easy(self):
        with tempfile.TemporaryDirectory() as tmp:
            problem_dir = Path(tmp) / 'java' / 'src' / 'main' / 'java' / 'algoexpert' / 'easy' / 'two_number_sum'
            problem_dir.mkdir(parents=True)
            (problem_dir / 'Solution1.java').write_text('')
            (problem_dir / 'Solution2.java').write_text('')
            original = migrate.JAVA_ROOT
            migrate.JAVA_ROOT = Path(tmp) / 'java' / 'src' / 'main' / 'java'
            try:
                out = readme_for(problem_dir)
            finally:
                migrate.JAVA_ROOT = original
        self.assertIn('# Two Number Sum', out)
        self.assertIn('difficulty-warm--up-green', out)
        self.assertIn('**Source:** AlgoExpert', out)
        self.assertIn('| Solution1 | TODO | TODO | TODO |', out)
        self.assertIn('| Solution2 | TODO | TODO | TODO |', out)

    def test_readme_solution_files_sorted_numerically(self):
        with tempfile.TemporaryDirectory() as tmp:
            problem_dir = Path(tmp) / 'java' / 'src' / 'main' / 'java' / 'algoexpert' / 'medium' / 'big_problem'
            problem_dir.mkdir(parents=True)
            for n in (1, 2, 10, 11):
                (problem_dir / f'Solution{n}.java').write_text('')
            original = migrate.JAVA_ROOT
            migrate.JAVA_ROOT = Path(tmp) / 'java' / 'src' / 'main' / 'java'
            try:
                out = readme_for(problem_dir)
            finally:
                migrate.JAVA_ROOT = original
        sol1 = out.index('| Solution1 |')
        sol2 = out.index('| Solution2 |')
        sol10 = out.index('| Solution10 |')
        sol11 = out.index('| Solution11 |')
        self.assertLess(sol1, sol2)
        self.assertLess(sol2, sol10)
        self.assertLess(sol10, sol11)


from migrate import (
    transform_algoexpert, transform_codesignal, transform_educative,
    solution_number,
)


ALGOEXPERT_INPUT = """import java.util.*;

class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        return new int[0];
    }
}
"""

ALGOEXPERT_EXPECTED = """package algoexpert.easy.two_number_sum;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] twoNumberSum(int[] A, int S) {
        return new int[0];
    }
}
"""


CODESIGNAL_BARE_INPUT = """int solution(int[] A) {
    var N = A.length;
    return N;
}
"""

CODESIGNAL_BARE_EXPECTED = """package codesignal.intro.adj.product;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        return N;
    }
}
"""


CODESIGNAL_CLASS_INPUT = """class Solution {
    int solution(int param1, int param2) {
        return param1 + param2;
    }
}
"""

CODESIGNAL_CLASS_EXPECTED = """package codesignal.thecore.add_two;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int param1, int param2) {
        return param1 + param2;
    }
}
"""


CODESIGNAL_TYPO_INPUT = """import javax.lang.model.util.ElementScanner6;

class SOlution {
    int solution(int n, int l, int r) {
        return 0;
    }
}
"""

CODESIGNAL_TYPO_EXPECTED = """package codesignal.thecore.count_sum;
import javax.lang.model.util.ElementScanner6;
import java.util.*;

// Approach: TODO.
class Solution1 {
    static int solution(int n, int l, int r) {
        return 0;
    }
}
"""


EDUCATIVE_INPUT = """class MaxSumSubArrayOfSizeK {
\tpublic static int findMaxSumSubArray(int k, int[] A) {
\t\tint N = A.length;
\t\treturn N;
\t}
}
"""

EDUCATIVE_EXPECTED = """package educative.patterns.sliding_window.max_sum_subarray_of_size_k;
import java.util.*;

// Approach: TODO.
class Solution1 {
\tpublic static int findMaxSumSubArray(int k, int[] A) {
\t\tint N = A.length;
\t\treturn N;
\t}
}
"""


EDUCATIVE_WITH_IMPORT_INPUT = """import java.util.*;

class StringPermutation {
\tpublic static boolean findPermutation(String s, String p) {
\t\treturn false;
\t}
}
"""

EDUCATIVE_WITH_IMPORT_EXPECTED = """package educative.patterns.sliding_window.find_permutation_in_a_string;
import java.util.*;

// Approach: TODO.
class Solution1 {
\tpublic static boolean findPermutation(String s, String p) {
\t\treturn false;
\t}
}
"""


class TestSolutionNumber(unittest.TestCase):
    def test_solution_number(self):
        self.assertEqual(solution_number('Solution1.java'), 1)
        self.assertEqual(solution_number('Solution2.java'), 2)
        self.assertEqual(solution_number('Solution12.java'), 12)


class TestTransformAlgoexpert(unittest.TestCase):
    def test_prepends_package_and_approach_line(self):
        out = transform_algoexpert(ALGOEXPERT_INPUT, 'algoexpert.easy.two_number_sum')
        self.assertEqual(out, ALGOEXPERT_EXPECTED)


class TestTransformCodesignal(unittest.TestCase):
    def test_wraps_bare_function_and_makes_static(self):
        out = transform_codesignal(CODESIGNAL_BARE_INPUT,
                                   'codesignal.intro.adj.product', 1)
        self.assertEqual(out, CODESIGNAL_BARE_EXPECTED)

    def test_renames_existing_class_and_makes_method_static(self):
        out = transform_codesignal(CODESIGNAL_CLASS_INPUT,
                                   'codesignal.thecore.add_two', 1)
        self.assertEqual(out, CODESIGNAL_CLASS_EXPECTED)

    def test_preserves_existing_imports_and_handles_class_typo(self):
        out = transform_codesignal(CODESIGNAL_TYPO_INPUT,
                                   'codesignal.thecore.count_sum', 1)
        self.assertEqual(out, CODESIGNAL_TYPO_EXPECTED)


class TestTransformEducative(unittest.TestCase):
    def test_renames_class_and_adds_import(self):
        out = transform_educative(
            EDUCATIVE_INPUT,
            'educative.patterns.sliding_window.max_sum_subarray_of_size_k',
            1,
        )
        self.assertEqual(out, EDUCATIVE_EXPECTED)

    def test_preserves_existing_import(self):
        out = transform_educative(
            EDUCATIVE_WITH_IMPORT_INPUT,
            'educative.patterns.sliding_window.find_permutation_in_a_string',
            1,
        )
        self.assertEqual(out, EDUCATIVE_WITH_IMPORT_EXPECTED)


if __name__ == '__main__':
    unittest.main()
