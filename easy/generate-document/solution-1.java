import java.util.*;

class Program {
    public boolean generateDocument(String characters, String document) {
        var pattern = new HashMap<Character, Integer>();

        for(var c : characters.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }

        for(var c: document.toCharArray()) {
            if(!pattern.containsKey(c) || pattern.get(c) == 0) { return false; }
            
            pattern.put(c, pattern.get(c) - 1);
        }

        return true;
    }
}