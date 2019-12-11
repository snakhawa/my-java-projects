package com.snakhawa.homework.linkedlist;

import org.w3c.dom.NodeList;

import java.util.HashMap;

public class PalindromeLinkedList {

  public static Boolean isPalindrome(ListNode head){
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next!= null ) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow = reverse(slow);
    fast = head;

    while(slow != null){
      if(slow.data != fast.data){
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }


  public static ListNode reverse(ListNode head){
    ListNode prevNode = null;
    ListNode currNode = head;
    ListNode followNode = head;
    while (currNode != null){
      followNode = followNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = followNode;
    }
    return prevNode;
  }
}

/*
Test cases
 ListNode node01 = new ListNode(0);
    ListNode node21 = new ListNode(2);
    ListNode node00 = new ListNode(0);
    ListNode node22 = new ListNode(2);
    ListNode node02 = new ListNode(0);

    node01.next = node21;
    node21.next = node00;
    node00.next = node22;
    node22.next = node02;


    //node4.next = node0;

    System.out.println(PalindromeLinkedList.isPalindrome(node01));

 */
