String solution(String txt) {
    return new String(
        txt.chars()
           .map(c -> (c - 'a' + 1) % 26 + 'a')
           .toArray()
        , 0
        , txt.length()
    );
}