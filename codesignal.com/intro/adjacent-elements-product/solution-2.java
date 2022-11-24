int solution(int[] A) {
    var N = A.length;

    return IntStream.range(1, N)
                    .map(i -> A[i] * A[i-1])
                    .max()
                    .getAsInt();
}