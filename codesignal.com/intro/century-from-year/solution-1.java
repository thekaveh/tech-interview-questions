int solution(int year) {
    return (year / 100) + ((year % 100) > 0 ? 1 : 0);
}