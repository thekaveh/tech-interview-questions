int solution(int deposit, int rate, int threshold) {
    return (int) Math.ceil(Math.log((double) threshold / deposit) / Math.log(1 + (rate / 100.0)));
}