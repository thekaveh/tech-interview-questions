int[] solution(int[] A, int k) {
    var N = A.length;

    return IntStream.range(0, N)
                    .filter(i -> (i + 1) % k != 0)
                    .map(i -> A[i])
                    .toArray();
}