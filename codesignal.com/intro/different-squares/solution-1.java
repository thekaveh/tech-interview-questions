int solution(int[][] M) {
    var R = M.length;
    var C = M[0].length;
    
    var HS = new HashSet<Square>();
    
    for(var r = 0; r < R - 1; r++) {
        for(var c = 0; c < C - 1; c++) {
            var tl = M[r][c];
            var tr = M[r][c + 1];
            var bl = M[r + 1][c];
            var br = M[r + 1][c + 1];
            
            var sq = new Square(tl, tr, bl, br);
            
            HS.add(sq);
        }
    }
    
    return HS.size();
}

static class Square {
    int tl, tr, bl, br;
    
    public Square(int tl, int tr, int bl, int br) {
        this.tl = tl;
        this.tr = tr;
        this.bl = bl;
        this.br = br;
    }
    
    public int hashCode() {
        var hash = 37;
        
        for(var component : new int[] { tl, tr, bl, br }) {
            hash *= 17;
            hash += Integer.valueOf(component).hashCode();
        }
        
        return hash;
    }
    
    public boolean equals(Object o) {
        if(o == this) { return true; }
        if(o == null) { return false; }
        if(! (o instanceof Square)) { return false; }
        
        var that = (Square)o;
        
        if(this.tl != that.tl) { return false; }
        if(this.tr != that.tr) { return false; }
        if(this.bl != that.bl) { return false; }
        if(this.br != that.br) { return false; }
        
        return true;
    }
}