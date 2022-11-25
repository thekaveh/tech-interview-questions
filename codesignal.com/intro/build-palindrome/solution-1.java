String solution(String txt) {
    var N = txt.length();
    var R = new StringBuilder();
    
    var lo = 0; while(!isPalindrome(lo, N - 1, txt)) { R.insert(0, txt.charAt(lo++)); }
    
    R.insert(0, txt);
    
    return R.toString();
}

boolean isPalindrome(int lo, int hi, String txt) {
    while(lo <= hi) {
        if(txt.charAt(lo++) != txt.charAt(hi--)) { return false; }
    }
    
    return true;
}