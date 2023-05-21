package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Parameters(description = "path to first file.")
    private String filepath1;
    @Parameters(description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"},
            description = "output format: stylish, plain, json, no-format [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish")
    private String format;
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
