package algoexpert.medium.task_assignment;
import java.util.*;

// Approach: Sort by duration, pair shortest with longest.
class Solution1 {
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        var N = tasks.size();
        var R = new ArrayList<ArrayList<Integer>>();
        var T = new ArrayList<Map.Entry<Integer, Integer>>();

        for(var i = 0; i < N; i++) {
            T.add(new AbstractMap.SimpleEntry<>(tasks.get(i), i));
        }

        Collections.sort(T, (a, b) -> a.getKey() - b.getKey());

        for(var i = 0; i < k; i++) {
            var r = new ArrayList<Integer>();
            r.add(T.get(i).getValue());
            r.add(T.get(2 * k - 1 - i).getValue());

            R.add(r);
        }

        return R;
    }
}
