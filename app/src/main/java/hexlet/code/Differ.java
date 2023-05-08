package hexlet.code;

//import com.sun.source.tree.BreakTree;

import java.io.File;

import java.util.Map;


import static hexlet.code.Difference.genDiff;
import static hexlet.code.Format.stylish;
import static hexlet.code.Parser.mapFileParse1;
import static hexlet.code.Parser.mapFileParse2;


public class Differ {

    public static String generate(File file1, File file2, String format) throws Exception {

        Map<String, Object> parsinFile1 = mapFileParse1(file1);
        Map<String, Object> parsinFile2 = mapFileParse2(file2);

        Map<Object, String> mapFile3;

        mapFile3 = genDiff(parsinFile1, parsinFile2);
        if (format.equals("stylish")) {
            return stylish(mapFile3);
        }
        return "where is STYLISH?";
    }
}

