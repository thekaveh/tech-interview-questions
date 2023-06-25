import java.util.*;

class Program {
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        
        var change = 0;
        
        for(var coin : coins) {
            if(change + 1 < coin)   { return change + 1; }
            else				    { change += coin; }
        }
        
        return change + 1;
    }
}