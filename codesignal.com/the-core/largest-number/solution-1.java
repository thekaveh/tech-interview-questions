int solution(int n) {
    var R = 0;
    
    while(n > 0) {
        R = R * 10 + 9;
        
        n--;
    }
    
    return R;
}