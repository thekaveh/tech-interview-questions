package algoexpert.medium.colliding_asteroids;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public int[] collidingAsteroids(int[] asteroids) {
		var S = new Stack<Integer>();

		for (var asteroid : asteroids) {
			if (S.isEmpty() || S.peek() < 0 || asteroid > 0) {
				S.push(asteroid);
				continue;
			}

			while (!S.isEmpty()) {
				if (S.peek() < 0) {
					S.push(asteroid);
					break;
				}

				var asteroidSize = Math.abs(asteroid);

				if (S.peek() > asteroidSize) {
					break;
				}

				if (S.peek() == asteroidSize) {
					S.pop();
					break;
				}

				S.pop();

				if (S.isEmpty()) {
					S.push(asteroid);
					break;
				}
			}
		}

		return S.stream().mapToInt(i -> i).toArray();
	}
}
