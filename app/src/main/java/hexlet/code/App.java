package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

//public class App {
//    @Option(names = "-h", description = "Usage: gendiff [-hV]\n" +
//            "Compares two configuration files and shows a difference.\n" +
//            "  -h, --help      Show this help message and exit.\n" +
//            "  -V, --version   Print version information and exit.")
//    boolean create;
@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true, description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
//        helloWorld();
//        return "Hello World!";
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
//    public static String helloWorld(){
//        return "Hello World!";
//    }
}

//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}
