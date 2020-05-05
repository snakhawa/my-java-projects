package com.snakhawa.homework.linkedlist;

public class Practice {

    /**
     * list -> [ 1 ] -> [ 2 ]    TO  list -> [ 1 ] -> [ 2 ] -> [ 3 ]
     */
    public static void addNodeToTail_9() {
        ListNode head = new ListNode(1, new ListNode(2));
        head.next.next = new ListNode(3);
        printNode(head);
    }

    /**
     * list -> [ 1 ] -> [ 2 ] -> null    TO  list -> [ 3 ] -> [ 1 ] -> [ 2 ] -> null
     */
    public static void addNodeToHead_10() {
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode n3 = new ListNode(3, head);
        printNode(n3);
    }

    /**
     * list -> [ 1 ] -> [ 2 ] -> null    TO  list -> [ 1 ] -> [ 3 ] -> [ 4 ] --> [ 2 ] -> null
     */
    public static void insertNodeBetweenNodes_11() {
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode n34 = new ListNode(3, new ListNode(4));
        n34.next.next = head.next;
        head.next = n34;
        printNode(head);
    }

    /**
     * list -> [ 1 ] -> [ 2 ] -> [ 3 ] --> null
     * TO
     * list -> [ 2 ] -> null
     * &
     * list2 -> [ 1] -> [ 3 ] -> null
     */
    public static void breakList_12() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = head; //  1 - 2 - 3
        head = head.next; // list -> 2
        list2.next = list2.next.next; // 1 -> 3
        head.next = null; // 2

        printNode(head);
        printNode(list2);

    }

    /**
     * list -> [ 5 ] -> [ 4 ] -> [ 3 ] --> null
     * TO
     * list -> [ 4] -> [ 5 ] -> [ 3 ] -> null
     */
    public static void swapNode_13() {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(3)));
        ListNode node4 = head.next; //[ 4 ] -> [ 3 ] --> null
        head.next = head.next.next; //[ 5] -> [ 3 ] -> null
        node4.next = head; //[4] -> [ 5 ] -> [ 3 ] --> null
        head = node4; //[ 2 ] --> null
        printNode(head);

    }


    /**
     * list -> [ 5 ] -> [ 4 ] -> [ 3 ] --> null
     * TO
     * list -> [ 3 ] -> [ 4 ] -> [ 5 ] -> null
     */
    public static void reverse_14() {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(3)));
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode followNode = head;
        while (currNode != null) {
            followNode = followNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = followNode;
        }
        printNode(prevNode);

    }

    /**
     * list -> [ 1 ] -> [ 2 ] -> [ 3 ] --> null
     * temp -> [ 4 ] -> [ 5] -> [ 6 ] --> null
     * TO
     * list -> [ 5 ] -> [ 3 ] -> [ 4 ] -> [ 2 ] -> null
     */
    public static void merge_15() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode temp = new ListNode(4, new ListNode(5, new ListNode(6)));

        ListNode n5 = temp.next; // [5]
        temp.next = head.next; // 4 - 2 - 3 - null
        n5.next = head.next.next; // 5 - 3 - null
        temp.next.next = null; // 4 - 2 - null
        head = n5; // 5 - 3 - null
        head.next.next = temp; // 5 - 3 - 4 - 2 - null

        printNode(head); // [ 5 ]-->[ 3 ]-->[ 4 ]-->[ 2 ]-->

    }

    /**
     * list -> [ 1 ] -> null
     * list2 -> [ 2] -> [ 3] -> [ 4 ] --> null
     * TO
     * list -> [ 4 ] -> [ 1 ] -> [ 2 ] --> null
     * &
     * list2 -> [ 3 ] -> null
     */
    public static void problem_16() {
        ListNode list = new ListNode(1, null);
        ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));
        list.next = list2; // 1 -> 2 -> 3 -> 4 -> null
        list2 = list2.next; // 3 -> 4 - null
        list.next.next = null; // 1 -> 2 -> null
        ListNode n4 = list2.next; // 4 -> null
        list2.next = null; // 3 -> null
        n4.next = list; // 4 -> 1 -> 2 -> null
        list = n4;

        printNode(list);
        printNode(list2);

    }

    /**
     * list -> [ 1 ] -> [ 2] -> [ 3] -> [ 4 ] --> null
     * TO
     * list -> [ 4 ] -> [ 2 ] --> null
     * &
     * list2 -> [ 3 ] -> [ 1 ] -> null
     */
    public static void problem_17() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode even = null;
        ListNode odd = null;
        while (head != null) {
            ListNode temp = head.next;
            if (head.data % 2 == 0) {
                head.next = even;
                even = head;
            } else {
                head.next = odd;
                odd = head;
            }
            head = temp;
        }

        printNode(odd);
        printNode(even);

    }

    public static void mergeSortedList() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(1, new ListNode(5, new ListNode(6)));

        ListNode merged = new ListNode(0);
        ListNode cur = merged;
        ListNode cur1 = l1;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                cur.next = new ListNode(l1.data);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.data);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        printNode(merged.next);
        printNode(cur1);

    }

   /* 1-> 2-> 3-> 4-> 5-> 6 -> 7 -> NULL

  1-> 2-> 5->4->3 -> 6 -> 7-> NULL

  Given a list and index, x, y reverse nodes only within the index

  Reverse(head, 2, 4);
  Reveres(ListNode head; int x, int j)
  curr = head;
  for(int i=0; i < x; i++)
  curr = curr.next;
  */

    public static void reverse_subNodeList(ListNode head, int start, int end) {
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode curr = head;
        ListNode sub = curr;
        ListNode before = curr;
        ListNode after = curr;

        for (int i = 0; i <= end; i++) {
            ListNode currNode = head;
            ListNode prevNode = currNode;
            if (head != null && i == start) {
                sub = currNode;
            }
            if (head != null && i == end) {
                after = head.next;
            }

            head = head.next;
        }


        printNode(head);
        printNode(curr);
        printNode(sub);
        printNode(before);
        printNode(after);

    }

    //https://leetcode.com/problems/rotate-list/submissions/
    public static ListNode rotateRight(ListNode head, int k) {

        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            length += 1;
            fast = fast.next;
        }

        k = k % length;

        for (int i = length - k; i > 0; i--) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    private static void printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(String.format("[ %s ]", head.data));
            sb.append("-->");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    private static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode followNode = head;
        while (currNode != null) {
            followNode = followNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = followNode;
        }

        return currNode;
    }

}
