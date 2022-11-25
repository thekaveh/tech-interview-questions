int solution(int v1, int w1, int v2, int w2, int maxW) {
    var maxV = 0;

    if(v1 < v2 && w2 <= maxW) {
        maxV += v2; maxW -= w2;

        if(w1 <= maxW) { maxV += v1; }
    }
    else if(w1 <= maxW) {
        maxV += v1; maxW -= w1;

        if(w2 <= maxW) { maxV += v2; }
    }

    return maxV;
}