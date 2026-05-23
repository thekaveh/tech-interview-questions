package codesignal.intro.is_mac48_address;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(String composite) {
        if(composite == null
            || composite.contains(" ")
            || composite.length() != 17
            || !composite.contains("-")) { return false; }
        
        var components = composite.split("-");
        
        if(components.length != 6) { return false; }
        
        for(var component : components) {
            if(component.length() != 2) { return false; }
            
            try {
                Integer.parseInt(component, 16);
            }
            catch(NumberFormatException ex){
                return false;
            }
        }
        
        return true;
    }
}
