class Solution {
    int solution(int candlesNumber, int makeNew) {
        var ret = 0;
        var left = 0;
        
        while(candlesNumber > 0) {
            ret += candlesNumber;   
            left += candlesNumber;
            
            candlesNumber = left / makeNew;
            left = left % makeNew;
        }
        
        return ret;
    }
}