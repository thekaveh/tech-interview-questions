package codesignal.thecore.lineup;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Simulate direction state, count forward steps taken while facing north.
class Solution1 {
    static int solution(String commands) {
        var ret = 0;
        var state = true;

        for(var command : commands.toCharArray()) {
            if(command == 'L' || command == 'R') { state = !state; }

            if(state) { ret++; }
        }

        return ret;
    }
}
