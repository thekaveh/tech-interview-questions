import java.util.*;

class Solution1 {
    public boolean classPhotos(ArrayList<Integer> R, ArrayList<Integer> B) {
        var N = R.size();

        Collections.sort(R, (a, b) -> b - a);
        Collections.sort(B, (a, b) -> b - a);

        var rFlag = R.get(0) > B.get(0);

        for(var i = 0; i < N; i++) {
            if(rFlag)   { if(B.get(i) >= R.get(i)) { return false; } }
            else        { if(R.get(i) >= B.get(i)) { return false; } }
        }

        return true;
    }
}