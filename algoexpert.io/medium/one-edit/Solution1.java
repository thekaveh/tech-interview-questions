import java.util.*;

class Solution1 {
    public boolean oneEdit(String txtA, String txtB) {
        int idxA = 0, M = txtA.length();
        int idxB = 0, N = txtB.length();

        if (1 < Math.abs(M - N)) { return false; }

        var edited = false;

        while (idxA < M && idxB < N) {
            if (txtA.charAt(idxA) == txtB.charAt(idxB)) { idxA++; idxB++; continue; }

            if (edited) { return false; } edited = true;

            if      (M < N) { idxB++; }
            else if (N < M) { idxA++; }
            else            { idxA++; idxB++; }
        }

        return true;
    }
}