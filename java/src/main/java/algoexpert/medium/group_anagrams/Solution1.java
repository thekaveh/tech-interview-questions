package algoexpert.medium.group_anagrams;
import java.util.*;

// Approach: TODO.
class Solution1 {
    // O(W * N * log(N)) time | O(W * N) space
    public static List<List<String>> groupAnagrams(List<String> words) {
        var M = new HashMap<String, List<String>>();
    
        for(var word : words) {
            var __ = word.toCharArray();
            Arrays.sort(__);
            var key = new String(__);

            if(!M.containsKey(key)) { M.put(key, new ArrayList<String>()); }

            M.get(key).add(word);
        }
    
        return new ArrayList<>(M.values());
    }
}
