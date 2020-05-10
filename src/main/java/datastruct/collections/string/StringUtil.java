package datastruct.collections.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        map.put('a',1);
        for(Map.Entry<Character,Integer> m : map.entrySet()) {
            m.getKey();
        }

        List<Integer> list = new ArrayList<>();
        list.size();

    }

    public static void testStringUtilMethod() {



    }
}
