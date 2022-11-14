import java.util.*;

class Program {
    public int[] nextGreaterElement(int[] A) {
        var N = A.length;
        var R = new int[N];

        for(var i = 0; i < N; i++) {
            var nge = -1;

            for(var j = i + 1; j < N + i; j++) {
                var k = j % N;

                if(A[i] < A[k]) { nge = A[k]; break; }
            }

            R[i] = nge;
        }

        return R;
    }
}
