package hexlet.code;

import java.io.File;
import picocli.CommandLine;
//import java.util.Arrays;
//import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
//import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import static com.fasterxml.jackson.core.io.doubleparser.AbstractNumberParser.charAt;
import static hexlet.code.Difference.genDiff;
import static hexlet.code.Parser.mapFileParse1;
import static hexlet.code.Parser.mapFileParse2;


public class Differ {
    public static ObjectMapper objectMapper = new ObjectMapper();

    //    public static ObjectMapper YAMLmapper = new YAMLMapper();
    public static String generate(File file1, File file2, String format) throws Exception {

        Map<String, Object> parsinFile1 = mapFileParse1(file1);
        Map<String, Object> parsinFile2 = mapFileParse2(file2);
        Map<Object, Object> mapFile3;
//        Map<String, Object> mapFile4 = new TreeMap<>();

        mapFile3 = genDiff(parsinFile1, parsinFile2);
        System.out.println(mapFile3);
//        if (format.equals("stylish")) {
//            System.out.format("{\n");
//            System.out.println(parsinFile1.keySet().equals(parsinFile2.keySet()));

//            for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
//                for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
//
//                    var mapFiles1Key = mapFile1s.getKey();
//                    var mapFiles2Key = mapFile2s.getKey();
//
//                    var mapFiles1Value = mapFile1s.getValue().toString();
//                    var mapFiles2Value = mapFile2s.getValue().toString();
//
//                    if (!mapFiles1Key.equals(mapFiles2Key) && !mapFiles1Value.equals(mapFiles2Value)) {
//                        mapFile4.put("- " + mapFiles1Key, mapFiles1Value);
//                        break;
//                    }
//                    if (mapFiles1Key.contains(mapFiles2Key) && mapFiles1Value.equals(mapFiles2Value)) {
//                        mapFile4.put("  " + mapFiles1Key, mapFiles1Value);
//                        break;
//                    }
//
//                    mapFile4.put("+ " + mapFiles2Key, mapFiles2Value);
//                    break;
//                }
//            }

//            for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
//                for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
//                    var mapFiles1Key = mapFile1s.getKey();
//                    var mapFiles2Key = mapFile2s.getKey();
//
//                    var mapFiles1Value = mapFile1s.getValue().toString();
//                    var mapFiles2Value = mapFile2s.getValue().toString();
//                    if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
//                        if (mapFiles2Key.equals("host")) {
//                            continue;
//                        }
//                        mapFile4.put("+ " + mapFiles2Key, mapFiles2Value);
//                        break;
//                    }
//                }
//            }
////                    if (!(mapFiles1Key.equals(mapFiles2Key)) && !(mapFiles1Value.equals(mapFiles2Value))) {
//
//                        break;
//                    }


//            for (Map.Entry<String, Object> mapFile3s : mapFile3.entrySet()) {
//                var mapFiles3Key = mapFile3s.getKey();
//                var mapFiles3Value = mapFile3s.getValue().toString();
//
//                System.out.format("%-3s%-3s%-3s\n", mapFiles3Key, ":", mapFiles3Value);
//
//            }
//            System.out.format("}\n");
//
//        } else {
//            for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
//                for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
//
//                    var mapFiles1Key = mapFile1s.getKey();
//                    var mapFiles2Key = mapFile2s.getKey();
//
//                    var mapFiles1Value = mapFile1s.getValue().toString();
//                    var mapFiles2Value = mapFile2s.getValue().toString();
//
//                    if (!mapFiles1Key.equals(mapFiles2Key) && !mapFiles1Value.equals(mapFiles2Value)) {
//                        mapFile3.put("- " + mapFiles1Key, mapFiles1Value);
//                        break;
//                    }
//                    if (mapFiles1Key.contains(mapFiles2Key) && mapFiles1Value.equals(mapFiles2Value)) {
//                        mapFile3.put("  " + mapFiles1Key, mapFiles1Value);
//                        break;
//                    }
//
//                    mapFile3.put("+ " + mapFiles2Key, mapFiles2Value);
//                    break;
//                }
//            }
//
//            for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
//                for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
//                    var mapFiles1Key = mapFile1s.getKey();
//                    var mapFiles2Key = mapFile2s.getKey();
//
//                    var mapFiles1Value = mapFile1s.getValue().toString();
//                    var mapFiles2Value = mapFile2s.getValue().toString();
//                    if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
//                        if (mapFiles2Key.equals("host")) {
//                            continue;
//                        }
//                        mapFile3.put("+ " + mapFiles2Key, mapFiles2Value);
//                        break;
//                    }
//                }
//            }
//        }


//            String map3ToJsonToString = objectMapper
//                    .writeValueAsString(mapFile3)
//                    .replace("\"", "")
//                    .replace("-", "\n-")
//                    .replace("+", "\n+")
//                    .replace("host", "\n  host");
//        return "{\n" + map3ToJsonToString.substring(1, map3ToJsonToString.length() - 1) + "\n}";
//        String jamal;
//        mapFile4.entrySet().forEach(mapFile4s -> {
//            var mapFiles4Key = mapFile4s.getKey();
//            var mapFiles4Value = mapFile4s.getValue().toString();
//            System.out.format("%-3s%-3s%-3s\n", mapFiles4Key, ":", mapFiles4Value);
//        });
//        }
        return null;

    }
}

