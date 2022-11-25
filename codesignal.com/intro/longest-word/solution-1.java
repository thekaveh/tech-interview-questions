String solution(String txt) {
    var N = txt.length();
    var R = "";
    
    for(var lo = 0; lo < N; lo++) {
        while(lo < N && !Character.isAlphabetic(txt.charAt(lo))) { lo++; }
        
        var hi = lo;
        
        while(hi < N && Character.isAlphabetic(txt.charAt(hi))) { hi++; }
        
        if(hi - lo > R.length()) { R = txt.substring(lo, hi); }
        
        lo = hi;
    }
    
    return R;
}