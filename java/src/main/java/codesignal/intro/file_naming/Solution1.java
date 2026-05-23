package codesignal.intro.file_naming;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: LinkedHashMap tracking next suffix per name, retry loop.
class Solution1 {
    static String[] solution(String[] names) {
        var M = new LinkedHashMap<String, Integer>();

        for(var name : names) {
            var revised = name;

            while(M.containsKey(revised)) {
                revised = name + "(" + M.compute(name, (k, v) -> v + 1) + ")";
            }

            M.put(revised, 0);
        }

        return M.keySet().toArray(new String[0]);
    }
}
