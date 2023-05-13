package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(index = "0", description = "path to first file.")
    public File filepath1;
    @Parameters(index = "1", description = "path to second file.")
    public File filepath2;
    @Option(names = { "-f", "--format" }, description = "output format [default: stylish]", defaultValue = "stylish")
    String format;
    @Override
    public void run() {
        try {
            System.out.println(generate(filepath1, filepath2, format));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
