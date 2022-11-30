int solution(int n) {
    var h = n / 60;
    var m = n % 60;
    
    var s = 0;
    
    while(h > 0) { s += h % 10; h /= 10; }
    while(m > 0) { s += m % 10; m /= 10; }
    
    return s;
}