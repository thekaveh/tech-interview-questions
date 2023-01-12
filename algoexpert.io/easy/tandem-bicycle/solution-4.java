import java.util.*;

class Program {
    public int tandemBicycle(int[] R, int[] B, boolean fastest) {
        var N = R.length;

        Arrays.sort(R);
        Arrays.sort(B);

        var S = 0;

        for(var i = 0; i < N; i++) {
            var j = fastest ? N - 1 - i : i;

            S += Math.max(R[i], B[j]);
        }

        return S;
    }
}