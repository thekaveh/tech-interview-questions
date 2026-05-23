char solution(String txt) {
    for(var c : txt.toCharArray()) {
        if(!Character.isDigit(c)) { continue; }

        return c;
    }

    return '\0';
}