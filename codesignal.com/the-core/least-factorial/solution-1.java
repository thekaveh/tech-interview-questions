class Solution {
    int solution(int n) {
        var ret = 1;
        
        for(var i = 2; ret < n; i++) { ret *= i; }
        
        return ret;
    } 
}