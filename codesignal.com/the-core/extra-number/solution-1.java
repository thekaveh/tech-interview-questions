int solution(int a, int b, int c) {
    if(a == b) { return c; }
    if(a == c) { return b; }
    if(b == c) { return a; }
    
    return -1;
}