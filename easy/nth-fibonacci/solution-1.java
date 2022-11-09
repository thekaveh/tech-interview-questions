import java.util.*;

class Program {
    public static int getNthFib(int n) {
        if(n == 1 || n == 2) { return n - 1; }
        else                 { return getNthFib(n - 2) + getNthFib(n - 1); }
    }
}