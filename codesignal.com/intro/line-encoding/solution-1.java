String solution(String txt) {
    var N = txt.length();
    var cipher = new StringBuilder();

    for(var lo = 0; lo < N; lo++) {
        var runCount = 1;
        var runChar = txt.charAt(lo);

        for(var hi = lo + 1; hi < N; hi++) {
            if(txt.charAt(hi) != runChar) { break; }

            lo++;
            runCount++;
        }

        cipher.append(runCount > 1 ? runCount : "");
        cipher.append(runChar);
    }

    return cipher.toString();
}