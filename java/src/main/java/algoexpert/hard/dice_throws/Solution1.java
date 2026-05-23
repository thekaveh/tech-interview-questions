package algoexpert.hard.dice_throws;
import java.util.*;

// Approach: Bottom-up 2-D DP (dice × target).
class Solution1 {
	public int diceThrows(int D, int S, int T) {
		if (T < D || D * S < T) {
			return 0;
		}

		var M = new int[D + 1][T + 1];
		M[0][0] = 1;

		for (var d = 1; d <= D; d++) {
			for (var t = 1; t <= T; t++) {
				for (var s = 1; s <= S; s++) {
					M[d][t] += (t - s >= 0) ? M[d - 1][t - s] : 0;
				}
			}
		}

		return M[D][T];
	}
}
