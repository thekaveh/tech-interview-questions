int solution(int a, int b) {
    var s = 0;

    for(var x = a; x <= b; x++) {
        var t = x;

        while(t > 0) {
            s += t % 2;

            t /= 2;
        }
    }

    return s;
}