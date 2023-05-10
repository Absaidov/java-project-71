package hexlet.code;

import org.junit.jupiter.api.Test;
//import org.w3c.dom.ls.LSOutput;

import static hexlet.code.Differ.generate;
//import static jdk.internal.jshell.tool.Startup.readFile;
import static hexlet.code.Difference.genDiff;
import static hexlet.code.Formatter.choiceFormat;
import static hexlet.code.Parser.mapFileParse1;
import static hexlet.code.Parser.mapFileParse2;
//import static org.apache.commons.lang3.StringUtils.substring;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.Assertions


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AppTest {
    Path filepath1 = Paths.get("src/test/resources/filepath1.json");
    Path filepath2 = Paths.get("src/test/resources/filepath2.json");
    Path filepath4 = Paths.get("src/test/resources/file1json.json");
    Path filepath5 = Paths.get("src/test/resources/file2json.json");
    Path getFilepath3 = Paths.get("src/test/resources/resulArray.txt");

    Path getFilepath6 = Paths.get("src/test/resources/resultJSON.txt");

    Path filepath7  = Paths.get("src/test/resources/filepath1.yml");
    Path filepath8  = Paths.get("src/test/resources/filepath2.yml");
    Path filepath9  = Paths.get("src/test/resources/file1yml.yml");
    Path filepath10  = Paths.get("src/test/resources/file2yml.yml");
    Path filepath11  = Paths.get("src/test/resources/resultPlainFormat.txt");


    @Test void appTestJSON() throws Exception {
        String format = "stylish";
        String actual = generate(filepath1.toFile(), filepath2.toFile(), format);
        String expected = Files.readString(getFilepath6);
        assertEquals(expected, actual);
    }
    @Test void appTestArrayJSON() throws Exception {
        String format = "stylish";
        String actual = generate(filepath4.toFile(), filepath5.toFile(), format);
        String expected = Files.readString(getFilepath3);
        assertEquals(expected, actual);
    }
    @Test void appTestResultJSONYaml() throws Exception {
        String format = "stylish";
        String actual = generate(filepath7.toFile(), filepath8.toFile(), format);
        String expected = Files.readString(getFilepath6);
        assertEquals(expected, actual);
    }
    @Test void appTestArrayYaml() throws Exception {
        String format = "stylish";
        String actual = generate(filepath9.toFile(), filepath10.toFile(), format);
        String expected = Files.readString(getFilepath3);
        assertEquals(expected, actual);
    }
    @Test void appTestParserJson() throws Exception {
        Map<String, Object> parsinFile1Actual = mapFileParse1(filepath1.toFile());
        Map<String, Object> parsinFile2Actual = mapFileParse2(filepath2.toFile());
        Map<String, Object> parsinFile1Expeceted = new TreeMap<>(Map.of("follow", false,
                "host", "hexlet.io", "proxy", "123.234.53.22", "timeout", 50));
        Map<String, Object> parsinFile2Expected = new TreeMap<>(Map.of("host", "hexlet.io",
                "timeout", 20, "verbose", true));

        assertEquals(parsinFile1Expeceted, parsinFile1Actual);
        assertEquals(parsinFile2Expected, parsinFile2Actual);
    }
    @Test void appTestParserYAML() throws Exception {
        Map<String, Object> parsinFile1Actual = mapFileParse1(filepath7.toFile());
        Map<String, Object> parsinFile2Actual = mapFileParse2(filepath8.toFile());
        Map<String, Object> parsinFile1Expeceted = new TreeMap<>(Map.of("follow", false,
                "host", "hexlet.io", "proxy", "123.234.53.22", "timeout", 50));
        Map<String, Object> parsinFile2Expected = new TreeMap<>(Map.of("host", "hexlet.io",
                "timeout", 20, "verbose", true));

        assertEquals(parsinFile1Expeceted, parsinFile1Actual);
        assertEquals(parsinFile2Expected, parsinFile2Actual);
    }
    @Test void appTestJSONKeysValues() throws Exception {
        String keyValue1 = "- follow:false";
        String keyValue2 = "host:hexlet.io";
        String keyValue3 = "- proxy:123.234.53.22";
        String keyValue4 = "- timeout:50";
        String keyValue5 = "+ timeout:20";
        String keyValue6 = "+ verbose:true";

        String format = "stylish";
        String actual = generate(filepath1.toFile(), filepath2.toFile(), format);

        assertEquals(keyValue1, actual.substring(2, 16));
        assertEquals(keyValue2, actual.substring(19, 33));
        assertEquals(keyValue3, actual.substring(34, 55));
        assertEquals(keyValue4, actual.substring(56, 68));
        assertEquals(keyValue5, actual.substring(69, 81));
        assertEquals(keyValue6, actual.substring(82, 96));

    }
    @Test void appTestYAMLKeysValues() throws Exception {
        String keyValue1 = "- follow:false";
        String keyValue2 = "host:hexlet.io";
        String keyValue3 = "- proxy:123.234.53.22";
        String keyValue4 = "- timeout:50";
        String keyValue5 = "+ timeout:20";
        String keyValue6 = "+ verbose:true";

        String format = "stylish";
        String actual = generate(filepath7.toFile(), filepath8.toFile(), format);

        assertEquals(keyValue1, actual.substring(2, 16));
        assertEquals(keyValue2, actual.substring(19, 33));
        assertEquals(keyValue3, actual.substring(34, 55));
        assertEquals(keyValue4, actual.substring(56, 68));
        assertEquals(keyValue5, actual.substring(69, 81));
        assertEquals(keyValue6, actual.substring(82, 96));

    }
    @Test void appTestJSONArraysKeysValues() throws Exception {

        String keyValue1 = "  chars1:[a, b, c]";
        String keyValue2 = "- chars2:[d, e, f]";
        String keyValue3 = "+ chars2:false";
        String keyValue4 = "- checked:false";
        String keyValue5 = "+ checked:true";
        String keyValue6 = "- default:null";
        String keyValue7 = "+ default:[value1, value2]";
        String keyValue8 = "- id:45";
        String keyValue9 = "+ id:null";
        String keyValue10 = "- key1:value1";
        String keyValue11 = "+ key2:value2";
        String keyValue12 = "  numbers1:[1, 2, 3, 4]";
        String keyValue13 = "- numbers2:[2, 3, 4, 5]";
        String keyValue14 = "+ numbers2:[22, 33, 44, 55]";
        String keyValue15 = "- numbers3:[3, 4, 5]";
        String keyValue16 = "+ numbers4:[4, 5, 6]";
        String keyValue17 = "+ obj1:{nestedKey=value, isNested=true}";
        String keyValue18 = "- setting1:Some value";
        String keyValue19 = "+ setting1:Another value";
        String keyValue20 = "- setting2:200";
        String keyValue21 = "+ setting2:300";
        String keyValue22 = "- setting3:true";
        String keyValue23 = "+ setting3:none";

        String format = "stylish";
        String actual = generate(filepath4.toFile(), filepath5.toFile(), format);

        assertEquals(keyValue1, actual.substring(2, 20));
        assertEquals(keyValue2, actual.substring(21, 39));
        assertEquals(keyValue3, actual.substring(40, 54));
        assertEquals(keyValue4, actual.substring(55, 70));
        assertEquals(keyValue5, actual.substring(71, 85));
        assertEquals(keyValue6, actual.substring(86, 100));
        assertEquals(keyValue7, actual.substring(101, 127));
        assertEquals(keyValue8, actual.substring(128, 135));
        assertEquals(keyValue9, actual.substring(136, 145));
        assertEquals(keyValue10, actual.substring(146, 159));
        assertEquals(keyValue11, actual.substring(160, 173));
        assertEquals(keyValue12, actual.substring(174, 197));
        assertEquals(keyValue13, actual.substring(198, 221));
        assertEquals(keyValue14, actual.substring(222, 249));
        assertEquals(keyValue15, actual.substring(250, 270));
        assertEquals(keyValue16, actual.substring(271, 291));
        assertEquals(keyValue17, actual.substring(292, 331));
        assertEquals(keyValue18, actual.substring(332, 353));
        assertEquals(keyValue19, actual.substring(354, 378));
        assertEquals(keyValue20, actual.substring(379, 393));
        assertEquals(keyValue21, actual.substring(394, 408));
        assertEquals(keyValue22, actual.substring(409, 424));
        assertEquals(keyValue23, actual.substring(425, 440));

    }
    @Test void appTestYAMLArraysKeysValues() throws Exception {

        String keyValue1 = "  chars1:[a, b, c]";
        String keyValue2 = "- chars2:[d, e, f]";
        String keyValue3 = "+ chars2:false";
        String keyValue4 = "- checked:false";
        String keyValue5 = "+ checked:true";
        String keyValue6 = "- default:null";
        String keyValue7 = "+ default:[value1, value2]";
        String keyValue8 = "- id:45";
        String keyValue9 = "+ id:null";
        String keyValue10 = "- key1:value1";
        String keyValue11 = "+ key2:value2";
        String keyValue12 = "  numbers1:[1, 2, 3, 4]";
        String keyValue13 = "- numbers2:[2, 3, 4, 5]";
        String keyValue14 = "+ numbers2:[22, 33, 44, 55]";
        String keyValue15 = "- numbers3:[3, 4, 5]";
        String keyValue16 = "+ numbers4:[4, 5, 6]";
        String keyValue17 = "+ obj1:{nestedKey=value, isNested=true}";
        String keyValue18 = "- setting1:Some value";
        String keyValue19 = "+ setting1:Another value";
        String keyValue20 = "- setting2:200";
        String keyValue21 = "+ setting2:300";
        String keyValue22 = "- setting3:true";
        String keyValue23 = "+ setting3:none";

        String format = "stylish";
        String actual = generate(filepath9.toFile(), filepath10.toFile(), format);

        assertEquals(keyValue1, actual.substring(2, 20));
        assertEquals(keyValue2, actual.substring(21, 39));
        assertEquals(keyValue3, actual.substring(40, 54));
        assertEquals(keyValue4, actual.substring(55, 70));
        assertEquals(keyValue5, actual.substring(71, 85));
        assertEquals(keyValue6, actual.substring(86, 100));
        assertEquals(keyValue7, actual.substring(101, 127));
        assertEquals(keyValue8, actual.substring(128, 135));
        assertEquals(keyValue9, actual.substring(136, 145));
        assertEquals(keyValue10, actual.substring(146, 159));
        assertEquals(keyValue11, actual.substring(160, 173));
        assertEquals(keyValue12, actual.substring(174, 197));
        assertEquals(keyValue13, actual.substring(198, 221));
        assertEquals(keyValue14, actual.substring(222, 249));
        assertEquals(keyValue15, actual.substring(250, 270));
        assertEquals(keyValue16, actual.substring(271, 291));
        assertEquals(keyValue17, actual.substring(292, 331));
        assertEquals(keyValue18, actual.substring(332, 353));
        assertEquals(keyValue19, actual.substring(354, 378));
        assertEquals(keyValue20, actual.substring(379, 393));
        assertEquals(keyValue21, actual.substring(394, 408));
        assertEquals(keyValue22, actual.substring(409, 424));
        assertEquals(keyValue23, actual.substring(425, 440));

    }
    @Test void appTestPlainFormat() throws Exception {
        String format = "plain";
        String actual = generate(filepath4.toFile(), filepath5.toFile(), format);
        String expected = Files.readString(filepath11);
        assertEquals(expected, actual);
    }
    @Test void appTestFormatterPlainJSONArray() throws Exception {
        String format = "plain";
        Map<Object, String> mapFile3;
        Map<String, Object> parsinFile1 = mapFileParse1(filepath4.toFile());
        Map<String, Object> parsinFile2 = mapFileParse2(filepath5.toFile());
        mapFile3 = genDiff(parsinFile1, parsinFile2);
        String actual = choiceFormat(mapFile3, format);
        String expected = Files.readString(filepath11);
        assertEquals(expected, actual);
    }
    @Test void appTestFormatterPlainYAMLArray() throws Exception {
        String format = "plain";
        Map<Object, String> mapFile3;
        Map<String, Object> parsinFile1 = mapFileParse1(filepath9.toFile());
        Map<String, Object> parsinFile2 = mapFileParse2(filepath10.toFile());
        mapFile3 = genDiff(parsinFile1, parsinFile2);
        String actual = choiceFormat(mapFile3, format);
        String expected = Files.readString(filepath11);
        assertEquals(expected, actual);
    }
    @Test void appTestFormatterStylishJSONArray() throws Exception {
        String format = "stylish";
        Map<Object, String> mapFile3;
        Map<String, Object> parsinFile1 = mapFileParse1(filepath4.toFile());
        Map<String, Object> parsinFile2 = mapFileParse2(filepath5.toFile());
        mapFile3 = genDiff(parsinFile1, parsinFile2);
        String actual = choiceFormat(mapFile3, format);
        String expected = Files.readString(getFilepath3);
        assertEquals(expected, actual);
    }
    @Test void appTestFormatterStylishYAMLArray() throws Exception {
        String format = "stylish";
        Map<Object, String> mapFile3;
        Map<String, Object> parsinFile1 = mapFileParse1(filepath9.toFile());
        Map<String, Object> parsinFile2 = mapFileParse2(filepath10.toFile());
        mapFile3 = genDiff(parsinFile1, parsinFile2);
        String actual = choiceFormat(mapFile3, format);
        String expected = Files.readString(getFilepath3);
        assertEquals(expected, actual);
    }
    @Test void appTestFormatterSomethingGoesWrong() throws Exception {
        String format = "SOMETHING";
        Map<Object, String> mapFile3;
        Map<String, Object> parsinFile1 = mapFileParse1(filepath4.toFile());
        Map<String, Object> parsinFile2 = mapFileParse2(filepath5.toFile());
        mapFile3 = genDiff(parsinFile1, parsinFile2);
        String actual = choiceFormat(mapFile3, format);
//        String expected = Files.readString(getFilepath3);
        assertEquals("SOMETHING GOES WRONG", actual);
    }
//    @Test void appTestParserJsonArray() throws Exception {
//        Map<String, Object> parsinFile1Actual = mapFileParse1(filepath4.toFile());
//        Map<String, Object> parsinFile2Actual = mapFileParse2(filepath5.toFile());
////        String nullEx = String.valueOf(null);
////        {chars1=[a, b, c], chars2=[d, e, f], checked=false, default=null, id=45,
// key1=value1, numbers1=[1, 2, 3, 4], numbers2=[2, 3, 4, 5], numbers3=[3, 4, 5],
// setting1=Some value, setting2=200, setting3=true}
////        {chars1=[a, b, c], chars2=false, checked=true, default=[value1, value2],
// id=null, key2=value2, numbers1=[1, 2, 3, 4],
// numbers2=[22, 33, 44, 55], numbers4=[4, 5, 6],
// obj1={nestedKey=value, isNested=true}, setting1=Another value, setting2=300, setting3=none}
////        Map<String, Object> parsinFile1Expected = new LinkedHashMap<>(
////                Map.of("chars1", "[a, b, c]",
// "chars2","[d, e, f]", "checked",false,"default",null,"id",45,"key1","value1"
////                ,"numbers1","[1, 2, 3, 4]",
// "numbers2","[2, 3, 4, 5]","numbers3","[3, 4, 5]","setting1","Some value"));
//////        parsinFile1Expected.put("chars1", "[a, b, c]");
//////        parsinFile1Expected.put("chars2", "[d, e, f]");
//////        parsinFile1Expected.put("checked", false);
//////        parsinFile1Expected.put("default", null);
////////        parsinFile1Expected.put("id", 45);
//////        parsinFile1Expected.put("id", 45);
//////        parsinFile1Expected.put("key1", "value1");
//////        parsinFile1Expected.put("numbers1", "[1, 2, 3, 4]");
//////        parsinFile1Expected.put("numbers2", "[2, 3, 4, 5]");
//////        parsinFile1Expected.put("numbers3", "[3, 4, 5]");
//////        parsinFile1Expected.put("setting1", "Some value");
//////        parsinFile1Expected.put("default", null);
////        parsinFile1Expected.put("setting2",200);
////        parsinFile1Expected.put("setting3",true);
////        Map<String, Object> map1 = new TreeMap<>(parsinFile1Expected);
//////        Map<String, Object> parsinFile2Expected = new TreeMap<>(Map.of("chars1","[a, b, c]", "chars2",false));
////
////        assertEquals(map1, parsinFile1Actual);
//
////        assertEquals(parsinFile2Expected, parsinFile2Actual);
//    }
////    @Test void appTestParserYAML() throws Exception {
////        Map<String, Object> parsinFile1Actual = mapFileParse1(filepath1.toFile());
////        Map<String, Object> parsinFile2Actual = mapFileParse2(filepath2.toFile());
////        Map<String, Object> parsinFile1Expected = mapFileParse1(filepath1.toFile());
////        Map<String, Object> parsinFile2Expeceted = mapFileParse1(filepath2.toFile());
////        assertEquals(parsinFile1Expected, parsinFile1Actual);
////        assertEquals(parsinFile2Expeceted, parsinFile2Actual);
////    }
//
////    @Test void appTest2() throws Exception {
////        assertThat
////    }
}
