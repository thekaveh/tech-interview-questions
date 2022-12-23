class SOlution {
    int solution(int n, int m) {
        return (n ^ m) + 1 & ~(n ^ m);
    }
}