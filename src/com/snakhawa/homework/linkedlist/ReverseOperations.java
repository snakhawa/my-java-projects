package com.snakhawa.homework.linkedlist;

import static com.snakhawa.homework.linkedlist.Practice.printNode;

public class ReverseOperations {
    /**
     * You are given a singly-linked list that contains N integers.
     * A subpart of the list is a contiguous set of even elements, bordered either by the end of the list or an odd element.
     * For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
     * <p>
     * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
     * The goal of this question is: given a resulting list, determine the original order of the elements.
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(8, new ListNode(9, new ListNode(12, new ListNode(16))))));
        reverseEvenElements(head);

    }

    public static ListNode reverseEvenElements(ListNode head) {
        return reverseEvens(head, null);
    }

    private static ListNode reverseEvens(ListNode head, ListNode prev) {
        if (head == null) return null;
        ListNode curr = head;

        while (curr != null && curr.data % 2 == 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (curr != head) {
            head.next = curr;
            curr = reverseEvens(curr, null);
            return prev;
        } else {
            head.next = reverseEvens(head.next, head);
            return head;
        }
    }
}
