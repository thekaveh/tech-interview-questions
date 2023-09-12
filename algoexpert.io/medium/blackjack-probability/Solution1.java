import java.util.*;

class Solution1 {
    public float blackjackProbability(int target, int startingHand) {
        var M = new HashMap<Integer, Float>();

        return solve(target, startingHand, M);
    }

    private static float solve(int target, int hand, Map<Integer, Float> M) {
        if (M.containsKey(hand)) { return M.get(hand); }

        if (target < hand)      { return 1; }
        if (target - 4 <= hand) { return 0; }

        var total = 0.0f;
        for (var card = 1; card <= 10; card++) { total += 0.1 * solve(target, hand + card, M); }

        M.put(hand, total);
        return total;
    }
}