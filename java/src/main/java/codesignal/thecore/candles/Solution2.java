package codesignal.thecore.candles;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int candlesNumber, int makeNew) {
        return candlesNumber + (candlesNumber - 1) / (makeNew - 1);
    }
}
