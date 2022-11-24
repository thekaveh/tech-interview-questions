boolean solution(String txt) {
    var N = txt.length();
    
    for(int lo = 0, hi = N - 1; lo <= hi; lo++, hi--) {
        if(txt.charAt(lo) != txt.charAt(hi)) { return false; }
    }
    
    return true;
}