int[] solution(int[] A, int from, int to) {
    var N = A.length;
    
    for(var i = 0; i < N; i++) {
        if(A[i] != from) { continue; }
        
        A[i] = to;
    }
    
    return A;
}