import java.util.*;

class Program {
	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] A) {
		var n = A.length;

		var IDX = new int[n];
		Arrays.fill(IDX, Integer.MIN_VALUE);

		var SUM = A.clone();

		var max = 0;
		for (var hi = 0; hi < n; hi++) {
			var hiNum = A[hi];

			for (var lo = 0; lo < hi; lo++) {
				var loNum = A[lo];

				if (loNum < hiNum && SUM[hi] < SUM[lo] + hiNum) {
					SUM[hi] = SUM[lo] + hiNum;
					IDX[hi] = lo;
				}

				if (SUM[max] < SUM[hi]) {
					max = hi;
				}
			}
		}

		var R = new ArrayList<List<Integer>>();
		R.add(List.of(SUM[max]));
		R.add(new ArrayList<Integer>());

		while (max != Integer.MIN_VALUE) {
			R.get(1).add(0, A[max]);
			max = IDX[max];
		}

		return R;
	}
}
