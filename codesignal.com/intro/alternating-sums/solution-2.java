int[] solution(int[] A) {
    var N = A.length;

    var R = new int[2];
    
    for(var i = 0; i < N; i++) { R[i % 2] += A[i]; }
    
    return R;
}