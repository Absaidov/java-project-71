package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static Map<Object, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys1 = new TreeSet<>(data1.keySet());
        Set<String> keys2 = new TreeSet<>(data2.keySet());
        Set<String> keysAll = new TreeSet<>();

        keysAll.addAll(keys1);
        keysAll.addAll(keys2);

        Map<Object, String> result = new LinkedHashMap<>();
        for (String key : keysAll) {
            if (!keys2.contains(key)) {
                result.put("- " + key, String.valueOf(data1.get(key)));
            } else if (!keys1.contains(key)) {
                result.put("+ " + key, String.valueOf(data2.get(key)));

            } else if (!String.valueOf(data2.get(key)).equals(String.valueOf(data1.get(key)))) {
                result.put("- " + key, String.valueOf(data1.get(key)));
                result.put("+ " + key, String.valueOf(data2.get(key)));
            } else if (String.valueOf(data2.get(key)).equals(String.valueOf(data1.get(key)))) {
                result.put("  " + key, String.valueOf(data1.get(key)));
            }
        }
        return result;
    }
}
