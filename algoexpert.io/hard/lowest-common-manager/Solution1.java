import java.util.*;

class Solution1 {
	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart repA, OrgChart repB) {
		return getLCM(topManager, repA, repB).first;
	}

	private static Pair<OrgChart, Integer> getLCM(OrgChart node, OrgChart repA, OrgChart repB) {
		Pair<OrgChart, Integer> ret = new Pair<>(node, (node.name == repA.name || node.name == repB.name)
				? 1
				: 0);

		for (OrgChart report : node.directReports) {
			Pair<OrgChart, Integer> reportRet = getLCM(report, repA, repB);

			if (reportRet.second == 2) {
				return reportRet;
			} else if (reportRet.second == 1) {
				ret.second++;
			}
		}

		return ret;
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

	static class Pair<T, V> {
		T first;
		V second;

		Pair(T first, V second) {
			this.first = first;
			this.second = second;
		}
	}
}