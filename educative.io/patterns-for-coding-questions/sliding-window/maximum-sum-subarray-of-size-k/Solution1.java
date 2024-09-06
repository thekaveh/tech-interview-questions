class MaxSumSubArrayOfSizeK {
	public static int findMaxSumSubArray(int k, int[] A) {
		int N = A.length;

		int lo = 0;
		int R = 0;
		int S = 0;

		for (int hi = 0; hi < N; hi++) {
			S += A[hi];

			if (hi - lo + 1 >= k) {
				R = Math.max(R, S);

				S -= A[lo++];
			}
		}

		return R;
	}

	public static void main(String[] args) {
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
		System.out.println("Maximum sum of a subarray of size K: "
				+ MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	}
}