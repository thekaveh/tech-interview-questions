package algoexpert.hard.lowest_common_manager;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public static OrgChart getLowestCommonManager(OrgChart R, OrgChart A, OrgChart B) {
		var P = new HashMap<Character, OrgChart>();
		var Q = new LinkedList<OrgChart>();

		var dA = -1;
		var dB = -1;

		Q.offer(R);
		P.put(R.name, null);

		var d = 0;

		while (!Q.isEmpty() && (dA == -1 || dB == -1)) {
			var L = Q.size();

			while (0 < L--) {
				var v = Q.poll();

				if (v == A) {
					dA = d;
				}
				if (v == B) {
					dB = d;
				}

				for (var w : v.directReports) {
					P.put(w.name, v);
					Q.offer(w);
				}
			}

			d++;
		}

		while (dA < dB) {
			B = P.get(B.name);
			dB--;
		}
		while (dB < dA) {
			A = P.get(A.name);
			dA--;
		}

		while (A != B) {
			A = P.get(A.name);
			B = P.get(B.name);
		}

		return A;
	}

	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}
}
