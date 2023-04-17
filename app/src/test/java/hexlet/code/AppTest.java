package hexlet.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class AppTest {
    @Parameters(index = "0", description = "path to first file.")
    private File filepath1;
    @Parameters(index = "1", description = "path to second file.")
    private File filepath2;
    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    String format;
    @Test void appTest() throws Exception {
        String actual = Differ.generate(filepath1, filepath2);
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
