package algoexpert.hard.find_loop;
import java.util.*;

// Approach: TODO.
class Solution2 {
	public static LinkedList findLoop(LinkedList head) {
		LinkedList pA, pB;

		for (pA = head.next, pB = head.next.next; pA != pB; pA = pA.next, pB = pB.next.next)
			;

		for (pA = head; pA != pB; pA = pA.next, pB = pB.next)
			;

		return pA;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
