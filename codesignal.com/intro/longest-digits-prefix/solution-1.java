String solution(String txt) {
    var N = txt.length;

    for(var i = 0; i < N; i++) {
        var c = txt.charAt(i);

        if(!Character.isDigit(c)) { return txt.substring(0, i); }
    }

    return txt;
}