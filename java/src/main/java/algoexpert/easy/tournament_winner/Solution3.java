package algoexpert.easy.tournament_winner;
import java.util.*;

// Approach: Score map (+1 per win), track max during scan.
class Solution3 {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        var N = competitions.size();
        var M = new HashMap<String, Integer>();

        for(var i = 0; i < N; i++) {
            var winner = (results.get(i) == 1)
                ? competitions.get(i).get(0)
                : competitions.get(i).get(1);

            M.put(winner, M.getOrDefault(winner, 0) + 1);
        }

        var ret = "";

        for(var entry : M.entrySet()) {
            if(ret == "" || entry.getValue() > M.get(ret)) { ret = entry.getKey(); }
        }

        return ret;
    }
}
