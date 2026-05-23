package codesignal.intro.is_ipv4_address;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Split on dot, validate each octet's format and range.
class Solution1 {
    static boolean solution(String composite) {
        if(composite.indexOf('.') == -1) { return false; }
        
        var components = composite.split("\\.");
        
        if(components.length != 4) { return false; }
        
        for(var component : components) {
            var N = component.length();
            
            if(N == 0 || N > 3) { return false; }
            
            if(N > 1 && component.charAt(0) == '0') { return false; }
            
            for(var c : component.toCharArray()) { if(Character.isAlphabetic(c)) { return false; } }
            
            var asInt = Integer.parseInt(component);
            
            if(asInt < 0 || asInt > 255) { return false; }
        }
        
        return true;
    }
}
