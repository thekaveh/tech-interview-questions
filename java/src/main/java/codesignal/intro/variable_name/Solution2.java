package codesignal.intro.variable_name;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static boolean solution(String name) {
        return name.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }
}
