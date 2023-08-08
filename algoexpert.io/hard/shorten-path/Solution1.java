import java.util.*;

class Solution1 {
    public static String shortenPath(String path) {
        var S = new Stack<String>();
        var tokens = path.split("/");

        if (path.startsWith("/")) { S.push("/"); }

        for (var token : tokens) {
            if (token.equals("..")) {
                if      (S.size() > 0 && S.peek().equals("/"))      { }
                else if (S.size() > 0 && !S.peek().equals(".."))    { S.pop(); }
                else                                                         { S.push(token); }
            }
            else if (token.equals(".")) { }
            else if (token.equals(""))  { }
            else                                 { S.push(token); }
        }

        var R = String.join("/", S);

        return path.startsWith("/") && R.length() > 1
            ? R.substring(1)
            : R;
    }
}