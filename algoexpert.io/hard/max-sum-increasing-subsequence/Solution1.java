import java.util.*;

class Program {
	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] A) {
		var n = A.length;

		var ats = new int[n];
		Arrays.fill(ats, Integer.MIN_VALUE);

		var sums = A.clone();

		var atMax = 0;
		for (var hi = 0; hi < n; hi++) {
			var hiNum = A[hi];

			for (var lo = 0; lo < hi; lo++) {
				var loNum = A[lo];

				if (loNum < hiNum && sums[hi] <= sums[lo] + hiNum) {
					sums[hi] = sums[lo] + hiNum;
					ats[hi] = lo;
				}

				if (sums[atMax] <= sums[hi]) {
					atMax = hi;
				}
			}
		}

		var result = new ArrayList<List<Integer>>();

		result.add(Arrays.asList(sums[atMax]));
		result.add(new ArrayList<Integer>());

		while (atMax != Integer.MIN_VALUE) {
			result.get(1).add(0, A[atMax]);

			atMax = ats[atMax];
		}

		return result;
	}
}
