boolean solution(int n) {
    while(n > 0) {
        var d = n % 10;
        
        if(d % 2 == 1) { return false; }
        
        n /= 10;
    }
    
    return true;
}