int solution(int[][] M) {
    var R = M.length;
    var C = M[0].length;
    
    var T = 0;
    var H = new boolean[C];
    
    for(var r = 0; r < R; r++) {
        for(var c = 0; c < C; c++) {
            if(M[r][c] == 0 || H[c]) { H[c] = true; continue; }
            
            T += M[r][c];
        }
    }
    
    return T;
}