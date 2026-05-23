package algoexpert.hard.dice_throws;
import java.util.*;

// Approach: Bottom-up DP with bounded inner loop.
class Solution2 {
	public int diceThrows(int D, int S, int T) {
		if (T < D || D * S < T) {
			return 0;
		}

		var M = new int[D + 1][T + 1];
		M[0][0] = 1;

		for (var d = 1; d <= D; d++) {
			for (var t = 1; t <= T; t++) {
				for (var s = 1; s <= Math.min(t, S); s++) {
					M[d][t] += M[d - 1][t - s];
				}
			}
		}

		return M[D][T];
	}
}
