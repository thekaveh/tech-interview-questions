import java.util.*;

class Program {

    public int minimumWaitingTime(int[] Q) {
        int T = 0, R = 0;
        var N = Q.length;

        Arrays.sort(Q);

        for(var i = 1; i < N; i++) {
            T += Q[i - 1];
            R += T;
        }

        return R;
    }
}