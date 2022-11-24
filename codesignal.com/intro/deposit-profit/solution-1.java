int solution(int deposit, int rate, int threshold) {
    var years = 0;
    var current = (double)deposit;
    
    while(current < threshold) {
        current *=  1 + (rate / 100.0);
        years++;
    }
    
    return years;
}