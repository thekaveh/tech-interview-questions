class Solution {
    int[] solution(int n) {
        var max_w = 0;
        var max_w_count = 0;
        
        for(var num = 1; num <= n; num++) {
            var num_w = weakness(num);
            
            if      (num_w > max_w)     { max_w = num_w; max_w_count = 1; }
            else if (num_w == max_w)    { max_w_count++; }
        }
        
        return new int[] { max_w, max_w_count };
    }
    
    int weakness(int x) {
        var w = 0;
        var dx = d(x);
        
        for(var i = 1; i < x; i++) {
            if(dx < d(i)) { w++; }
        }
        
        return w;
    }
    
    int d(int x) {
        var M = new HashSet<Integer>();
        
        M.add(1);
        M.add(x);
        
        for(var div = 2; div <= Math.sqrt(x); div++) {
            if(x % div != 0) { continue; }
            
            M.add(div);
            M.add(x / div);
        }
        
        return M.size();
    }
}