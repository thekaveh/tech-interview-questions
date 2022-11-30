int solution(int n) {
    var S = 0;
    
    while(n > 0) {
        S += n % 10;
        
        n /= 10;
    }
    
    return S;
}