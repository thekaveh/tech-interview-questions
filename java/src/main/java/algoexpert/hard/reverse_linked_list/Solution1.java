package algoexpert.hard.reverse_linked_list;
import java.util.*;

// Approach: Iterative three-pointer reversal.
class Solution1 {
	public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList prev = null, curr = head;

		while (curr != null) {
			var next = curr.next;

			curr.next = prev;

			prev = curr;
			curr = next;
		}

		return prev;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
