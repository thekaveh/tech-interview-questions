import java.util.*;

class Program {
    public ArrayList<String> validIPAddresses(String composite) {
        var N = composite.length();
        var R = new ArrayList<String>();

        for(var i = 1; i < Math.min(N, 4); i++) {
            var T = new String[] {"", "", "", ""};

            T[0] = composite.substring(0, i);

            if(!isValid(T[0])) { continue; }

            for(var j = i; j < Math.min(N, i + 4); j++) {
                T[1] = composite.substring(i, j);

                if(!isValid(T[1])) { continue; }

                for(var k = j; k < Math.min(N, j + 4); k++) {
                    T[2] = composite.substring(j, k);
                    T[3] = composite.substring(k, N);

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

        var asInt = Integer.parseInt(component);

        if(asInt > 255) { return false; }

        return Integer.toString(asInt).length() == N;
    }
}