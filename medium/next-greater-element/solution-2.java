import java.util.*;

class Program {
    public int[] nextGreaterElement(int[] A) {
        var N = A.length;
        var R = new int[N];
        var S = new Stack<Integer>();

        Arrays.fill(R, -1);

        for(var i = 2 * N - 1; i >= 0; i--) {
            var idx = i % N;

            while(!S.isEmpty()) {
                if(S.peek() <= A[idx])  { S.pop(); }
                else                    { R[idx] = S.peek(); break; }
            }

            S.push(A[idx]);
        }

        return R;
    }
}