package algoexpert.easy.nth_fibonacci;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int getNthFib(int n) {
        if(n == 1 || n == 2) { return n - 1; }
        else                 { return getNthFib(n - 2) + getNthFib(n - 1); }
    }
}
