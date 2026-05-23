import unittest
from pathlib import Path
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

    def test_readme_for_algoexpert_easy(self, tmp_root=None):
        import tempfile, os
        with tempfile.TemporaryDirectory() as tmp:
            problem_dir = Path(tmp) / 'java' / 'src' / 'main' / 'java' / 'algoexpert' / 'easy' / 'two_number_sum'
            problem_dir.mkdir(parents=True)
            (problem_dir / 'Solution1.java').write_text('')
            (problem_dir / 'Solution2.java').write_text('')
            # patch JAVA_ROOT for the test
            import migrate
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


if __name__ == '__main__':
    unittest.main()
