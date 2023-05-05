package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
//import static jdk.internal.jshell.tool.Startup.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.Assertions


import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {
    Path filepath1 = Paths.get("src/test/resources/filepath1.json");
    Path filepath2 = Paths.get("src/test/resources/filepath2.json");
    Path getFilepath3 = Paths.get("src/test/resources/resulArray.txt");
    Path filepath4 = Paths.get("src/test/resources/file1json.json");
    Path filepath5 = Paths.get("src/test/resources/file2json.json");

//    @Test void appTest() throws Exception {
//        String actual = generate(filepath1.toFile(), filepath2.toFile());
//        String expected = """
//                    {
//                    - follow:false,
//                      host:hexlet.io,
//                    - proxy:123.234.53.22,
//                    - timeout:50,
//                    + timeout:20,
//                    + verbose:true
//                    }""";
//        assertEquals(expected, actual);
//    }
    @Test void appTestArray() throws Exception {
        String format = "stylish";
        String actual = generate(filepath4.toFile(), filepath5.toFile(), format);
        String expected = String.valueOf(getFilepath3);
        assertEquals(expected, actual);
    }

//    @Test void appTest2() throws Exception {
//        assertThat
//    }
}
