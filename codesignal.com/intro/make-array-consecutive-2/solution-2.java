int solution(int[] A) {
    var M = A.length;
    
    Arrays.sort(A);
    
    var N = A[M - 1] - A[0] + 1;
    
    return N - M;
}