package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private final String path1 = "file1json.json";
    private final String path2 = "file2json.json";
    private final String path3 = "file1yml.yml";
    private final String path4 = "file2yml.yml";

    private final Path pathStylish =
            Paths.get("src/test/resources/expected/testStylish").toAbsolutePath().normalize();
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/testPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/testJson").toAbsolutePath().normalize();

    public AppTest() throws IOException {
    }

    @Test
    public void test1() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path1, path2));
    }

    @Test
    public void testStylish1() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path1, path2, "stylish"));
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(path3, path4, "stylish"));
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path1, path2, "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path3, path4, "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path1, path2, "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path3, path4, "json"));
    }
}