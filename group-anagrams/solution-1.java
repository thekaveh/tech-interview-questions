import java.util.*;

class Program {
    // O(W * N * log(N)) time | O(W * N) space
    public static List<List<String>> groupAnagrams(List<String> words) {
        var M = new HashMap<String, List<String>>();

        for(var word : words) {
            var keyChars = word.toCharArray();
            Arrays.sort(keyChars);
            var key = new String(keyChars);

            if(!M.containsKey(key)) { M.put(key, new LinkedList<String>()); }
            
            M.get(key).add(word);
        }

        return new ArrayList<>(M.values());
    }
}