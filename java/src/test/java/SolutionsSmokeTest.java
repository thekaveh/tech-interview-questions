import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Loads every Solution{N} class on the classpath via Class.forName. Catches
 * static-initializer errors, NoClassDefFoundError, and other class-load
 * failures that the compile step alone does not surface.
 *
 * Each Solution{N}.java produces one dynamic test case; the suite passes
 * if all classes load.
 */
class SolutionsSmokeTest {

    @TestFactory
    Stream<DynamicTest> loadEverySolutionClass() throws IOException {
        Path sourceRoot = Path.of("src/main/java").toAbsolutePath().normalize();
        List<String> classNames = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(sourceRoot)) {
            walk.filter(p -> p.getFileName().toString().matches("Solution\\d+\\.java"))
                .forEach(p -> classNames.add(toClassName(sourceRoot, p)));
        }
        return classNames.stream().sorted().map(cn -> DynamicTest.dynamicTest(cn, () -> {
            Class.forName(cn);
        }));
    }

    private static String toClassName(Path root, Path javaFile) {
        Path rel = root.relativize(javaFile);
        String pathPart = rel.toString().replace(File.separatorChar, '.');
        return pathPart.substring(0, pathPart.length() - ".java".length());
    }
}
