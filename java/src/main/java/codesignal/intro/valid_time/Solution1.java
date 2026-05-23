package codesignal.intro.valid_time;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(String time) {
        var N = time.length();
        
        if(time == null || N != 5)  { return false; }
        if(!time.contains(":"))     { return false; }
        
        var components = time.split(":");
        
        var C = components.length;
        
        if(C != 2) { return false; }
        
        for(var i = 0; i < C; i++) {
            var component = components[i];
            
            if(component.length() != 2) { return false; }
            
            var asInt = 0;
            
            try                             { asInt = Integer.parseInt(component); }
            catch(NumberFormatException ex) { return false; }
            
            if      (i == 0 && (asInt < 0 || asInt > 23)) { return false; }
            else if (i == 1 && (asInt < 0 || asInt > 59)) { return false; }
        }
        
        return true;
    }
}
