int[] solution(int[] A, int from, int to) {
    return Arrays.stream(A)
                 .map(a -> a == from ? to : a)
                 .toArray();
}