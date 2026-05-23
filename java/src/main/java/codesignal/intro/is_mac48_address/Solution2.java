package codesignal.intro.is_mac48_address;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static boolean solution(String inputString) {
        return inputString.matches("^([0-9A-F][0-9A-F]-){5}[0-9A-F][0-9A-F]$");
    }
}
