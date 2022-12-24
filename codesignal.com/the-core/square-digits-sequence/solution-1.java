class Solution {
    int solution(int a0) {
        var a = a0;
        var M = new HashSet<Integer>();
        
        while(!M.contains(a)) {
            M.add(a);
            
            var t = 0;
            while(a > 0) {
                var rem = a % 10;
                t += rem * rem;
                
                a /= 10;
            }    
            a = t;
        }
        
        return M.size() + 1;
    }
}