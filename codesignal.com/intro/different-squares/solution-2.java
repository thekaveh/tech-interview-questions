int solution(int[][] M) {
    var R = M.length;
    var C = M[0].length;
    
    var HS = new HashSet<String>();
    
    for(var r = 0; r < R - 1; r++) {
        for(var c = 0; c < C - 1; c++) {
            var tl = M[r][c];
            var tr = M[r][c + 1];
            var bl = M[r + 1][c];
            var br = M[r + 1][c + 1];
            
            var sq = tl + " : " + tr + " : " + bl + " : " + br;
            
            HS.add(sq);
        }
    }
    
    return HS.size();
}