import java.util.*;

class Solution2 {
	public boolean zeroSumSubarray(int[] A) {
		var cumulativeSums = new HashSet<Integer>();

		var runningSum = 0;
		cumulativeSums.add(runningSum);

		for (var a : A) {
			runningSum += a;

			if (cumulativeSums.contains(runningSum)) {
				return true;
			}

			cumulativeSums.add(runningSum);
		}

		return false;
	}
}