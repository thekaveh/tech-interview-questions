import java.util.*;

class Solution1 {
    public ArrayList<String> validIPAddresses(String composite) {
        var N = composite.length();
        var R = new ArrayList<String>();

        for(var i = 0; i < Math.min(N, 3); i++) {
            var T = new String[] {"", "", "", ""};

            T[0] = composite.substring(0, i + 1);

            if(!isValid(T[0])) { continue; }

            for(var j = i + 1; j < Math.min(N, i + 4); j++) {
                T[1] = composite.substring(i + 1, j + 1);

                if(!isValid(T[1])) { continue; }

                for(var k = j + 1; k < Math.min(N, j + 4); k++) {
                    T[2] = composite.substring(j + 1, k + 1);
                    T[3] = composite.substring(k + 1, N);

                    if(!isValid(T[2]) || !isValid(T[3])) { continue; }

                    R.add(String.join(".", T));
                }
            }
        }

        return R;
    }

    private static boolean isValid(String component) {
        var N = component.length();

        if(N == 0) { return false; }

        if(N > 1 && component.charAt(0) == '0') { return false; }

        var asInt = Integer.parseInt(component);

        if(asInt > 255) { return false; }

        return true;
    }
}