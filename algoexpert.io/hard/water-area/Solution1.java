import java.util.*;

class Solution1 {
	public static int waterArea(int[] H) {
		var N = H.length;

		var L = new int[N];
		for (int at = 0, max = 0; at < N; at++) {
			L[at] = max;
			max = Math.max(max, H[at]);
		}

		var R = new int[N];
		for (int at = N - 1, max = 0; 0 <= at; at--) {
			R[at] = max;
			max = Math.max(max, H[at]);
		}

		var W = new int[N];
		for (int at = 0, min = 0; at < N; at++) {
			min = Math.min(L[at], R[at]);
			W[at] = H[at] <= min ? min - H[at] : 0;
		}

		var S = 0;
		for (var at = 0; at < N; at++) {
			S += W[at];
		}

		return S;
	}
}
