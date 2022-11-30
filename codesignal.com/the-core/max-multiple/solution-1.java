int solution(int divisor, int bound) {
    for(var n = bound; n > 0; n--) {
        if(n % divisor == 0) { return n; }
    }
    
    return -1;
}