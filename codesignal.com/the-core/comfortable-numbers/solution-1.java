class Solution {
    int solution(int l, int r) {
        var count = 0;
        
        for(var i = l; i < r; i++) {
            for(var j = i + 1; j <= r; j++) {
                if(!comfortableWith(i, j) || !comfortableWith(j, i)) { continue; }
                
                count++;
            }
        }
        
        return count;
    }
    
    boolean comfortableWith(int a , int b) {
        if(a == b) { return false; }
        
        if(b < a - sumOfDigits(a) || a + sumOfDigits(a) < b) { return false; }
        
        return true;
    }
    
    int sumOfDigits(int num) {
        var ret = 0;
        
        while(num > 0) {
            ret += num % 10;
            
            num /= 10;
        }
        
        return ret;
    }  
}