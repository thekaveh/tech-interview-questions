class Solution {
    int solution(int a, int b, int n) {
        var ret = 0;
        
        while(n > 0) {
            ret += a * b;
            
            a++;
            b++;
            
            n--;
        }
        
        return ret;
    }
}