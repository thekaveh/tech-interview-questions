package algoexpert.medium.spiral_traverse;
import java.util.*;

// Approach: Recursive shrinking boundary.
class Solution2 {
	public static List<Integer> spiralTraverse(int[][] A) {
		List<Integer> aux = new ArrayList<Integer>();
		
		spiralTraverse(A, aux, 0, 0);
		
		return aux;
	}

	private static void spiralTraverse(int[][] A, List<Integer> aux, int rowLo, int colLo) {
		int M = A.length
			, N = A[0].length
			, rowHi = M - 1 - rowLo
			, colHi = N - 1 - colLo;
		
		if(rowLo > rowHi || colLo > colHi) { return; }
		
		for(int c = colLo; c <= colHi; c++) 	{ aux.add(A[rowLo][c]); }
		for(int r = rowLo + 1; r < rowHi; r++) 	{ aux.add(A[r][colHi]); }
		
		for(int c = colHi; rowLo != rowHi && c >= colLo; c--)		{ aux.add(A[rowHi][c]); }
		for(int r = rowHi - 1; colLo != colHi && r > rowLo; r--)	{ aux.add(A[r][colLo]); }
		
		spiralTraverse(A, aux, rowLo + 1, colLo + 1);
	}
}
