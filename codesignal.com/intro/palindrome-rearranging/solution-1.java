boolean solution(String txt) {
    var FREQ = new HashMap<Character, Integer>();
    
    for(var c : txt.toCharArray()) { FREQ.put(c, FREQ.getOrDefault(c, 0) + 1); }
    
    var odds = 0;
    for(var val : FREQ.values()) {
        if(val % 2 == 1) { odds += 1; }
        
        if(odds > 1) { return false; }
    }
    
    return true;
}