boolean solution(String txt) {
    var FREQ = new int[26];
    
    for(var c : txt.toCharArray()) { FREQ[c - 'a']++; }
    
    var odds = 0;
    for(var i = 0; i < 26; i++) {
        if(FREQ[i] % 2 == 1) {
            odds += 1;
            
            if(odds > 1) { return false; }
        }
    }
    
    return true;
}