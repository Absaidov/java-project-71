package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static Map<Object, Object> genDiff(Map<String, Object> data1, Map<String, Object> data2){
        Set<String> keys1 = new TreeSet<>(data1.keySet());
        Set<String> keys2 = new TreeSet<>(data2.keySet());

        Set<String> keysAll = new TreeSet<>();

        keysAll.addAll(keys1);
        keysAll.addAll(keys2);

        Map<Object,Object> result = new LinkedHashMap<>();
        for (String key : keysAll){
//            result.put(key, data1.get(key).toString());

//            System.out.println(data2.get(key));
//            System.out.println(data1.get(key) + ":" + data1.keySet());
            if (!keys2.contains(key)){
                result.put(key, data2.get(key).toString());

//                System.out.println(key);
//                result.put(key, data1.get(key).toString());
            } else if (!keys1.contains(key)) {
//                System.out.println(data2.get(key));

//                System.out.println(key);

//                break;
                } else if (data2.get(key) != data1.get(key)) {
//                System.out.println(data2.get(key));
//                System.out.println(key);

//                    System.out.println(data1.get(key).toString());
//                break;
            } else if (data2.get(key) == data1.get(key)) {
//                System.out.println(data2.get(key));

//                System.out.println(key);

//                System.out.println(data1.get(key));

//                break;
            }
        }
        return result;
    }
}
