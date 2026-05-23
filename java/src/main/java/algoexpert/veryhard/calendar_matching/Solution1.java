package algoexpert.veryhard.calendar_matching;
import java.util.*;

// Approach: TODO.
class Solution1 {
	public static List<StringMeeting> calendarMatching(
			List<StringMeeting> calendar1,
			StringMeeting dailyBounds1,
			List<StringMeeting> calendar2,
			StringMeeting dailyBounds2,
			int meetingDuration) {
		calendar1.add(new StringMeeting("0:00", dailyBounds1.start));
		calendar1.add(new StringMeeting(dailyBounds1.end, "23:59"));

		calendar2.add(new StringMeeting("0:00", dailyBounds2.start));
		calendar2.add(new StringMeeting(dailyBounds2.end, "23:59"));

		var minPQ = new PriorityQueue<int[]>((v, w) -> v[0] - w[0]);

		for (var x : calendar1) {
			minPQ.offer(x.toArray());
		}
		for (var x : calendar2) {
			minPQ.offer(x.toArray());
		}

		var X = new ArrayList<int[]>();

		while (minPQ.size() > 1) {
			var v = minPQ.poll();
			var w = minPQ.peek();

			if (v[1] < w[0]) {
				X.add(v);
			} else {
				minPQ.poll();
				minPQ.offer(new int[] { v[0], Math.max(v[1], w[1]) });
			}
		}

		X.add(minPQ.poll());

		var R = new ArrayList<StringMeeting>();

		for (var at = 1; at < X.size(); at++) {
			var start = X.get(at - 1)[1];
			var end = X.get(at)[0];

			if ((end - start) < meetingDuration) {
				continue;
			}

			R.add(StringMeeting.fromArray(new int[] { start, end }));
		}

		return R;
	}

	static class StringMeeting {
		public String start;
		public String end;

		public StringMeeting(String start, String end) {
			this.start = start;
			this.end = end;
		}

		public int[] toArray() {
			return new int[] {
					Integer.parseInt(this.start.substring(0, this.start.indexOf(":"))) * 60
							+ Integer.parseInt(this.start.substring(this.start.indexOf(":") + 1, this.start.length())),
					Integer.parseInt(this.end.substring(0, this.end.indexOf(":"))) * 60
							+ Integer.parseInt(this.end.substring(this.end.indexOf(":") + 1, this.end.length()))
			};
		}

		public static StringMeeting fromArray(int[] A) {
			return new StringMeeting(
					Integer.toString(A[0] / 60) + ":" + String.format("%02d", A[0] % 60),
					Integer.toString(A[1] / 60) + ":" + String.format("%02d", A[1] % 60));
		}
	}
}
