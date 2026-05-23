package codesignal.intro.are_equally_strong;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Sum check plus at least one hand match.
class Solution1 {
    static boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return ((yourLeft + yourRight) == (friendsLeft + friendsRight))
            && ((yourLeft == friendsLeft) || (yourLeft == friendsRight));
    }
}
