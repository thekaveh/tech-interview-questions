package codesignal.intro.message_from_binary_code;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static String solution(String code) {
        return new String(new BigInteger(code, 2).toByteArray());
    }
}
