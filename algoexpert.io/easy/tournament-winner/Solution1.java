import java.util.*;

class Solution1 {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        var N = competitions.size();
        var M = new HashMap<String, Integer>();

        for(var i = 0; i < N; i++) {
            var competitionWinner = (results.get(i) == 1)
                ? competitions.get(i).get(0)
                : competitions.get(i).get(1);

            M.put(
                competitionWinner
                , M.getOrDefault(competitionWinner, 0) + 3
            );
        }

        var tournamentWinnerTeam = "";
        var tournamentWinnerScore = 0;

        for(var entry : M.entrySet()) {
            if(entry.getValue() > tournamentWinnerScore) {
                tournamentWinnerTeam = entry.getKey();
                tournamentWinnerScore = entry.getValue();
            }
        }

        return tournamentWinnerTeam;
    }
}