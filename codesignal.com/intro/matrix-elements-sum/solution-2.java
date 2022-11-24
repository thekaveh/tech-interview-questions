int solution(int[][] M) {
    var R = M.length;
    var C = M[0].length;
    
    var T = 0;
    
    for(var c = 0; c < C; c++) {
        for(var r = 0; r < R; r++) {
            if(M[r][c] > 0) { T += M[r][c]; }
            else            { break; }
        }
    }
    
    return T;
}