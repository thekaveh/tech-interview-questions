package codesignal.intro.add_border;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Direct construction with StringBuilder border.
class Solution1 {
    static String[] solution(String[] picture) {
        var M = picture.length;
        var N = picture[0].length();
        
        var R = new String[M + 2];
        
        var T = new StringBuilder();
        for(var i = 0; i < N + 2; i++) { T.append("*"); }
        
        R[0] = R[M + 1] = T.toString();
        
        for(var i = 1; i < M + 1; i++) {
            R[i] = "*" + picture[i - 1] + "*";
        }
        
        return R;
    }
}
