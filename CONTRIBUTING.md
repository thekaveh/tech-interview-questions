# Contributing

This is a personal portfolio of solved interview problems. External contributions
are not actively solicited. These public conventions help forks and future
additions stay consistent.

## 1. Layout and solution shape

Java problems live under `java/src/main/java/`:

- `algoexpert/{easy,medium,hard,veryhard}/<problem_snake>/`
- `codesignal/{intro,thecore}/<problem_snake>/`
- `educative/patterns/<pattern_snake>/<problem_snake>/`

Each problem has a `README.md` and one or more `Solution{N}.java` files. The integer
identifies attempt order. Match the package to the directory and the package-private
class name to the filename. Put `// Approach: <description>` immediately above the
class. Use a title, difficulty badge, source attribution, paraphrased statement and
solutions table in the README. See the existing
[Two Number Sum](java/src/main/java/algoexpert/easy/two_number_sum/README.md) example.

## 2. Code style and difficulty

Keep the surrounding solution's style when editing:

- Use four spaces for indentation and preserve existing branch alignment.
- Java examples use `java.util.*` imports, with stream/math imports where needed.
- Use `var` where the inferred type remains clear. Follow existing short identifiers
  for familiar quantities and descriptive names for other roles.
- Stateless solutions use static methods. Solutions that retain traversal state can
  use instance fields and methods. Keep helper visibility consistent with callers.
- Use the `warm-up`, `easy`, `medium`, `hard` or `very-hard` badge. Start from the
  provider's classification and adjust when the actual difficulty differs.

The [Python guide](python/README.md) defines module and test conventions for that tree.

## 3. Add a solution to an existing problem

1. Add `Solution{N+1}.java` next to the existing attempts, with the matching package
   and class name.
2. Describe the approach in the comment above the class.
3. Add a README table row with the solution name, approach, time and space complexity.

## 4. Add a new problem

1. Choose the provider, tier/pattern and a snake_case problem name. Create the
   directory under the layout above.
2. Add `Solution1.java` using the shape in section 1.
3. Add a README with `## 1. Problem` and `## 2. Solutions`, following an existing example.
4. From the checkout root, use Python 3.10+ to regenerate the catalog:

   ```bash
   python3 scripts/generate_problem_index.py
   ```

5. With Git, JDK 17+ and Maven installed, run the repository checks from the same root:

   ```bash
   bash scripts/verify_final.sh
   ```

The generator reports the problem count. Review and commit `PROBLEMS.md` with the
addition. The verification script compiles and smoke-tests Java, then checks README
structure, missing approach/complexity placeholders and the source-tree layout.
A successful script ends with `ALL CHECKS PASSED`.

## 5. Add a language tree

Add a sibling directory at the repository root with its own build configuration.
Mirror the provider/tier/problem layout. The existing `python/` tree contains a
single port and test scaffolding; it does not provide all Java solutions.

## 6. Website maintenance and validation

Readers should use the [published catalog](https://thekaveh.github.io/tech-interview-questions/PROBLEMS.html).
The current website renders the README, catalog and per-problem READMEs with Jekyll
and the Cayman theme. `_config.yml` excludes application/tooling files.
Contributor and license links deliberately lead to their public repository sources.

For a fork that needs publishing, Settings → Pages → Source: **GitHub Actions**
selects the checked-in `.github/workflows/pages.yml` deployment workflow. Publishing
requires available Actions capacity. A local build verifies content and routes but
does not update the published site.

Regenerate the catalog after problem changes and inspect the locally built site's
actual catalog, contributor, license and problem hrefs. The Java workflow also contains repository checks. Run the applicable
checks locally when hosted execution is unavailable.
