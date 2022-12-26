class Solution {
    int solution(int a, int b) {
        var ret = 0;
        var twoSqrt = Math.sqrt(2);
        var r = (int) Math.max(a / twoSqrt, b / twoSqrt);
        
        for(var x = -r; x <= r; x++) {
            for(var y = -r; y <= r; y++) {
                if(y < x - b / twoSqrt) { continue; }
                if(y > x + b / twoSqrt) { continue; }
                
                if(y < -x - a / twoSqrt) { continue; }
                if(y > -x + a / twoSqrt) { continue; }
                
                ret++;
            }
        }
        
        return ret;
    } 
}