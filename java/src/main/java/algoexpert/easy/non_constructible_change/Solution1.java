package algoexpert.easy.non_constructible_change;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public int nonConstructibleChange(int[] coins) {
        var coinN = coins.length;

        if(coinN == 0) { return 1; }

        var changeN = (1 << coinN);

        Arrays.sort(coins);

        var changes = new int[changeN];

        for(var changeIdx = 0; changeIdx < changeN; changeIdx++) {
            for(var coinIdx = 0; coinIdx < coinN; coinIdx++) {
                if((changeIdx & (1 << coinIdx)) == 0) { continue; }

                changes[changeIdx] += coins[coinIdx];
            }

            if(0 < changeIdx && changes[changeIdx - 1] + 1 < changes[changeIdx]) {
                return changes[changeIdx - 1] + 1;
            }
        }

        return changes[changeN - 1] + 1;
    }
}
