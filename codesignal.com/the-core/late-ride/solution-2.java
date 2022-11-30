int solution(int n) {
    var hours = n / 60;
    var minutes = n % 60;

    return hours / 10 + hours % 10 + minutes / 10 + minutes % 10;
}