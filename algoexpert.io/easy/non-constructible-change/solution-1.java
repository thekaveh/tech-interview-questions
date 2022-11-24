import java.util.*;

class Program {
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        var T = 0;
        
        for(var coin : coins) {
            if(coin > T + 1) { return T + 1; }

            T += coin;
        }

        return T + 1;
    }
}