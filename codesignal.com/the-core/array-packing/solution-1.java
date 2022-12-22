int solution(int[] A) {
    var N = A.length;
    var M = 0;

    for(var i = 0; i < N; i++) {
        var a = A[i];

        M += a << (i * 8);
    }

    return M;
}