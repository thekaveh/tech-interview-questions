package algoexpert.medium.zero_sum_subarray;
import java.util.*;

// Approach: Prefix sum set: repeated prefix sum implies zero-sum subarray.
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
