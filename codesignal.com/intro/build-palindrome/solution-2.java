String solution(String txt) {
    var N = txt.length();

    var hi = 0; while(hi < N && !isPalindrome(hi, N - 1, txt)) { hi++; }

    return txt + new StringBuilder(txt.substring(0, hi)).reverse().toString();
}

boolean isPalindrome(int lo, int hi, String txt) {
    while(lo <= hi) {
        if(txt.charAt(lo++) != txt.charAt(hi--)) { return false; }
    }
    
    return true;
}