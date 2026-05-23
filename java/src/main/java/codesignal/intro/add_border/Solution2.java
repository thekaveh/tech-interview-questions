package codesignal.intro.add_border;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Wrap rows then derive top/bottom via replaceAll.
class Solution2 {
    static String[] solution(String[] picture) {
        var M = picture.length;
        
        var R = new String[M + 2];
        
        for(var i = 1; i < M + 1; i++) {
            R[i] = "*" + picture[i - 1] + "*";
        }
        
        R[0] = R[M + 1] = R[1].replaceAll(".", "*");
        
        return R;
    }
}
