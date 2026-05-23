package codesignal.intro.different_symbols_naive;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Stream distinct count.
class Solution2 {
    static int solution(String txt)
    {
        return (int) txt.chars().distinct().count();
    }
}
