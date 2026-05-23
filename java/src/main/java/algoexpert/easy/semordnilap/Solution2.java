package algoexpert.easy.semordnilap;
import java.util.*;

// Approach: HashSet, remove on match.
class Solution2 {
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        var R = new ArrayList<ArrayList<String>>();
        var M = new HashSet<String>(Arrays.asList(words));

        for(var word : words) {
            if(M.contains(word)) {
                M.remove(word);
                
                var rev = new StringBuilder(word).reverse().toString();

                if(M.contains(rev)) {
                    M.remove(rev);

                    var r = new ArrayList<String>();
                    r.add(word);
                    r.add(rev);
                    
                    R.add(r);
                }
            }
        }

        return R;
    }
}
