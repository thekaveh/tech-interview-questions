import javax.lang.model.util.ElementScanner6;

class SOlution {
    int solution(int n, int l, int r) {
        var ret = 0;

        var lo = l;
        var hi = r;

        while(lo <= hi) {
            var t = lo + hi;

            if      (t < n) { lo++; }
            else if (n < t) { hi--; }
            else            { ret++; lo++; hi--; }
        }

        return ret;
    }
}