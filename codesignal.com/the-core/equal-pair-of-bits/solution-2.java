class SOlution {
    int solution(int n, int m) {
        return Integer.lowestOneBit(~(n ^ m));
    }
}