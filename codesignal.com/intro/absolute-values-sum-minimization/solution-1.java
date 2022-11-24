int solution(int[] A) {
    var N = A.length;
    
    return (N % 2 == 0) ? A[N / 2 - 1] : A[N / 2];
}