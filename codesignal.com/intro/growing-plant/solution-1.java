int solution(int upSpeed, int downSpeed, int desiredHeight) {
    var days = 0;
    var height = 0;
    
    while(true) {
        days++;
        
        height += upSpeed;
        
        if(height >= desiredHeight) { break; }
        
        height -= downSpeed;
    }
    
    return days;
}