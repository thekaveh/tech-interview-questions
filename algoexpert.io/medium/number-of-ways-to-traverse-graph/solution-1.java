import java.util.*;

class Program {
    // T: O(2^(C + R)) - S: O(C + R)
    public int numberOfWaysToTraverseGraph(int C, int R) {
        if(C == 1 || R == 1) { return 1; }

        return numberOfWaysToTraverseGraph(C - 1, R) + numberOfWaysToTraverseGraph(C, R - 1);
    }
}