import java.util.*;

class Program {
    public int validStartingCity(int[] D, int[] F, int mpg) {
        var N = D.length;

        for(var i = 0; i < N; i++) {
            var d = 0;

            for(var j = i; j < i + N && d >= 0; j++) {
                var idx = j % N;

                d += F[idx] * mpg - D[idx];
            }

            if(d >=0) { return i; }
        }

        return -1;
    }
}   