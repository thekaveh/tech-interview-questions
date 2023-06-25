import java.util.*;

class Solution1 {
    public String[] commonCharacters(String[] A) {
        var N = A.length;
        var R = new ArrayList<String>();
        var M = new HashMap<String, Integer>();

        for(var a : A) {
            var T = new HashSet<String>();
            for(var c : a.toCharArray()) { T.add(String.valueOf(c)); }

            for(var t : T) { M.put(t, M.getOrDefault(t, 0) + 1); }
        }

        for(var m : M.entrySet()) {
            if(m.getValue() == N) { R.add(m.getKey()); }
        }

        return R.toArray(new String[0]);
    }
}