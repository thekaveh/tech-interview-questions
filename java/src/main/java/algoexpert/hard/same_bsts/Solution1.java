package algoexpert.hard.same_bsts;
import java.util.*;

// Approach: Recursive structural comparison with valid-range scanning.
class Solution1 {
    public static boolean sameBsts(List<Integer> A, List<Integer> B) {
        return solve(A, B, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solve(List<Integer> A, List<Integer> B, int vAIdx, int vBIdx, int min, int max) {
        if (vAIdx == -1 && vBIdx == -1) {
            return true;
        } else if (vAIdx == -1 || vBIdx == -1) {
            return false;
        }

        if (!A.get(vAIdx).equals(B.get(vBIdx))) {
            return false;
        }

        var v = A.get(vAIdx);

        var ltAIdx = ltIdx(A, vAIdx, min);
        var ltBIdx = ltIdx(B, vBIdx, min);

        if (!solve(A, B, ltAIdx, ltBIdx, min, v)) {
            return false;
        }

        var gteAIdx = gteIdx(A, vAIdx, max);
        var gteBIdx = gteIdx(B, vBIdx, max);

        if (!solve(A, B, gteAIdx, gteBIdx, v, max)) {
            return false;
        }

        return true;
    }

    private static int ltIdx(List<Integer> A, int vIdx, int min) {
        var N = A.size();
        var v = A.get(vIdx);

        for (var idx = vIdx + 1; idx < N; idx++) {
            var a = A.get(idx);

            if (min <= a && a < v) {
                return idx;
            }
        }

        return -1;
    }

    private static int gteIdx(List<Integer> A, int vIdx, int max) {
        var N = A.size();
        var v = A.get(vIdx);

        for (var idx = vIdx + 1; idx < N; idx++) {
            var a = A.get(idx);

            if (v <= a && a < max) {
                return idx;
            }
        }

        return -1;
    }
}
