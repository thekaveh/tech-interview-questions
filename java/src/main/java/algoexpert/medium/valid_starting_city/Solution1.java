package algoexpert.medium.valid_starting_city;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int validStartingCity(int[] distances, int[] fuels, int mpg) {
		var N = distances.length;

		for (var src = 0; src < N; src++) {
			var currentRange = 0;

			for (var dst = src; dst < src + N && 0 <= currentRange; dst++) {
				var idx = dst % N;

				currentRange += fuels[idx] * mpg;
				currentRange -= distances[idx];
			}

			if (0 <= currentRange) {
				return src;
			}
		}

		return -1;
	}
}
