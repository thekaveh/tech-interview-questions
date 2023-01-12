import java.util.*;

class Program {
    public boolean classPhotos(ArrayList<Integer> R, ArrayList<Integer> B) {
        var N = R.size();

        Collections.sort(R, (a, b) -> b - a);
        Collections.sort(B, (a, b) -> b - a);

        var BR = (R.get(0) > B.get(0))  ? R : B;
        var FR = (R.get(0) <= B.get(0)) ? R : B;

        for(var i = 0; i < N; i++) {
            if(FR.get(i) >= BR.get(i)) { return false; }
        }

        return true;
    }
}