package codesignal.intro.century_from_year;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Integer division with remainder bump.
class Solution1 {
    static int solution(int year) {
        return (year / 100) + ((year % 100) > 0 ? 1 : 0);
    }
}
