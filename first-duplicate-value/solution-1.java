import java.util.*;

class Program {
    public int firstDuplicateValue(int[] A) {
        var M = new HashSet<Integer>();

        for(var a : A) {
            if(M.contains(a)) { return a; }

            M.add(a);
        }

        return -1;
    }
}