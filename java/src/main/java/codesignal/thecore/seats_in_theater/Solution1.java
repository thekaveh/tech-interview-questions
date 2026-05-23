package codesignal.thecore.seats_in_theater;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Formula: (nCols − col + 1) * (nRows − row).
class Solution1 {
    static int solution(int nCols, int nRows, int col, int row) {
        return (nCols - col + 1) * (nRows - row);
    }
}
