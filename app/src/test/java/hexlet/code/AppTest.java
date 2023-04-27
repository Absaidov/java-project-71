package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {
    Path filepath1 = Paths.get("src/test/resources/filepath1.json");
    Path filepath2 = Paths.get("src/test/resources/filepath2.json");

    @Test void appTest() throws Exception {
        String actual = Differ.generate(filepath1.toFile(), filepath2.toFile());
        String expected = """
                    {
                    - follow:false,
                      host:hexlet.io,
                    - proxy:123.234.53.22,
                    - timeout:50,
                    + timeout:20,
                    + verbose:true
                    }""";
        assertEquals(expected, actual);
    }
}
