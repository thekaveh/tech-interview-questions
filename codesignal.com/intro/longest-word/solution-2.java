String solution(String txt) {
    return Arrays.stream(txt.split("\\W+"))
                 .max((a, b) -> a.length() - b.length())
                 .get();
}