int solution(String txt) {
    return Arrays.stream(txt.split("\\D+"))
                 .filter(s -> !s.isEmpty())
                 .map(s -> Integer.valueOf(s))
                 .reduce(0, (a, b) -> a + b);
}