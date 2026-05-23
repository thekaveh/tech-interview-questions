package codesignal.thecore.will_you;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(boolean young, boolean beautiful, boolean loved) {
        return (young && beautiful && !loved) || (loved && (!young || !beautiful));
    }
}
