import java.util.*;

class Program {
    public boolean generateDocument(String characters, String document) {
        var FREQ = new HashMap<Character, Integer>();

        for(var c : characters.toCharArray()) {
            FREQ.put(c, FREQ.getOrDefault(c, 0) + 1);
        }

        for(var c: document.toCharArray()) {
            if(!FREQ.containsKey(c)) { return false; }
            
            FREQ.put(c, FREQ.get(c) - 1);

            if(FREQ.get(c) == 0) { FREQ.remove(c); }
        }

        return true;
    }
}