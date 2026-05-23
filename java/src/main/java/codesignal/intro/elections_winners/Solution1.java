package codesignal.intro.elections_winners;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Find current max, then count candidates beatable with k extra votes.
class Solution1 {
    static int solution(int[] votes, int k) {
        var max = 0;
        var n_max = 0;

        for(var vote : votes) {
            if      (vote > max)    { max = vote; n_max = 1; }
            else if (vote == max)   { n_max++; }
        }

        if(n_max == 1 && k == 0) { return 1; }
        else {
            var num = 0;

            for(var vote : votes) {
                if(vote + k > max) { num++; }
            }

            return num;
        }
    }
}
