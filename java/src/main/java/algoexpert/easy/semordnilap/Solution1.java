package algoexpert.easy.semordnilap;
import java.util.*;
import java.util.stream.Collectors;

// Approach: HashMap groups words with their reverses.
class Solution1 {
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        var M = new HashMap<String, ArrayList<String>>();
        var R = new ArrayList<ArrayList<String>>();

        for(var word : words) {
            var rev = new StringBuilder(word).reverse().toString();

            if(!M.containsKey(word) && !M.containsKey(rev)) {
                M.put(word, new ArrayList<>());
            }

            if  (M.containsKey(word))   { M.get(word).add(word); }
            else                        { M.get(rev).add(word); }
        }

        for(var r : M.values()) {
            if(r.size() == 2) { R.add(r); }
        }

        return R;
    }
}
