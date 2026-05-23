package codesignal.thecore.reach_next_level;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Single comparison: experience + reward >= threshold.
class Solution1 {
    static boolean solution(int experience, int threshold, int reward) {
        return experience + reward >= threshold;
    }
}
