package hexlet.code;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

//import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

//import java.io.File;
@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class AppTest {
    @Parameters(index = "0", description = "path to first file.")
    Path filepath1 = Paths.get("src/test/resources/filepath1.json");
    @Parameters(index = "1", description = "path to second file.")
    Path filepath2 = Paths.get("src/test/resources/filepath2.json");


    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]")
    String format;

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
