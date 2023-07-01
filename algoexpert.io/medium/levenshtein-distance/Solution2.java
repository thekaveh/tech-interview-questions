import java.util.*;

class Solution2 {
    public static int levenshteinDistance(String strA, String strB) {
        var A = strA.length();
        var B = strB.length();
        
        var M = new int[A + 1][B + 1];
        
        for(var atA = 0; atA <= A; atA++) { M[atA][0] = atA; }
        for(var atB = 0; atB <= B; atB++) { M[0][atB] = atB; }
        
        for(var atA = 1; atA <= A; atA++) {
            for(var atB = 1; atB <= B; atB++) {
                if(strA.charAt(atA - 1) == strB.charAt(atB - 1)) {
                    M[atA][atB] = M[atA - 1][atB - 1];
                }
                else {
                    var altA = M[atA][atB - 1] + 1;
                    var altB = M[atA - 1][atB] + 1;
                    var altC = M[atA - 1][atB - 1] + 1;
                    
                    M[atA][atB] = Math.min(altA, Math.min(altB, altC));
                }
            }
        }
        
        return M[A][B];
    }
}