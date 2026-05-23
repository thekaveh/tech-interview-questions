package algoexpert.hard.reverse_linked_list;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public static LinkedList reverseLinkedList(LinkedList H) {
		return reverse(null, H);
	}

	private static LinkedList reverse(LinkedList P, LinkedList C) {
		if (C == null) {
			return P;
		}

		var N = C.next;

		C.next = P;

		P = C;
		C = N;

		return reverse(P, C);
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
