package com.snakhawa.homework.linkedlist;

import com.snakhawa.homework.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class LinkedListCycle {

  /*
    Example Node with cycle:
    ListNode node4 = new ListNode(4);
    ListNode node2 = new ListNode(2, node4);
    ListNode head = new ListNode(1, node2);
    node2.next.next = node2;
   */
  public static Boolean hasCycle(ListNode head){
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast){
        return true;
      }
    }
    return false;
  }
}
