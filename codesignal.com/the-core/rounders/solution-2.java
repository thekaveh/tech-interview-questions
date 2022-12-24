class SOlution {
    int solution(int n) {
        var trail = 1;
        
        while(n > 10) {
            trail *= 10;
            n = (n / 10) + (n % 10 < 5 ? 0 : 1);
        }
        
        return n * trail;
    }
}