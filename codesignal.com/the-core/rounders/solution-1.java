class SOlution {
    int solution(int n) {
        var str = Integer.toString(n);
        var N = str.length();
        
        return solve(str, N - 1, 0);
    }
    
    int solve(String str, int at, int carry) {
        var asInt = str.charAt(at) - '0' + carry;
        
        if(at == 0) {
            var N = str.length();
            
            return asInt * (int) Math.pow(10, N - 1);
        }
        
        return solve(str, at - 1, asInt < 5 ? 0 : 1);
    }
}