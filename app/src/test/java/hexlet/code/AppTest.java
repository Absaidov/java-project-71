package hexlet.code;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("testJson");
        resultPlain = readFixture("testPlain");
        resultStylish = readFixture("testStylish");
    }
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public final void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(resultStylish);
        assertThat(Differ.generate(filePath1, filePath2, "stylish"))
                .isEqualTo(resultStylish);
        assertThat(Differ.generate(filePath1, filePath2, "plain"))
                .isEqualTo(resultPlain);
        assertThat(Differ.generate(filePath1, filePath2, "json"))
                .isEqualTo(resultJson);
    }
}
