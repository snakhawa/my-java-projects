package com.snakhawa.homework.linkedlist;

/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


    if(l1 == null) {return l2;}
    else if(l2 == null) {return l1;}

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while(l1 != null && l2 !=null){
      if(l1.data <= l2.data){
        curr.next = l1;
        l1 = l1.next;
      } else{
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if(l1 == null){
      curr.next = l2;
    } else{
      curr.next = l1;
    }

    return dummy.next;
  }

}
