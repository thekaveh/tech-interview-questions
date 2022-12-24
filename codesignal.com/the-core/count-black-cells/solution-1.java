class Solution {
    int solution(int n, int m) {
        return n + m + gcd(n, m) - 2;
    }
    
    int gcd(int a, int b) {
        if(b == 0) { return a; }
        
        return gcd(b, a % b);
    }
}