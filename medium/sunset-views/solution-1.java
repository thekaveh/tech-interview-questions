import java.util.*;

class Program {

    public ArrayList<Integer> sunsetViews(int[] B, String direction) {
        var N = B.length;
        var max = -1;
        var R = new ArrayList<Integer>();

        if(direction.equals("EAST")) {
            for(var i = N - 1; i >= 0; i--) {
                if(max != -1 && B[i] <= B[max]) { continue; }

                max = i;
                R.add(0, max);
            }
        }
        else {
            for(var i = 0; i < N; i++) {
                if(max != -1 && B[i] <= B[max]) { continue; }

                max = i;
                R.add(max);
            }
        }

        return R;
    }
}