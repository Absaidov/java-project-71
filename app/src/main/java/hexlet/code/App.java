package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

public class App {
    @Option(names = "-v", description = "Usage: gendiff [-hV]\n" +
            "Compares two configuration files and shows a difference.\n" +
            "  -h, --help      Show this help message and exit.\n" +
            "  -V, --version   Print version information and exit.")
//    boolean create;
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
