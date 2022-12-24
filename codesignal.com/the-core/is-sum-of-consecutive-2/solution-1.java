class Solution {
    int solution(int n) {
        int ret = 0;
        
        for(int lo = 1 ; lo < n ; lo++) {
            int sum = 0;
            
            for(int hi = lo ; hi < n ; hi++) {
                sum += hi;
                
                if(sum == n) { ret++; }    
                if(sum >= n) { break; }
            }
        }
        
        return ret;
    }
}