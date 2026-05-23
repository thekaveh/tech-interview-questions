package codesignal.intro.are_equally_strong;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct two-way equality check.
class Solution2 {
    static boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return yourLeft == friendsLeft && yourRight == friendsRight
            || yourLeft == friendsRight && yourRight == friendsLeft;
    }
}
