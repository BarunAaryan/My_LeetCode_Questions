/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int size = getSize(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int step = 1; step < size; step *= 2) {
            ListNode prev = dummy;
            ListNode current = dummy.next;

            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, step);
                current = split(right, step);

                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return null;
        }

        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;

        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode current = prev;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else if (right != null) {
            current.next = right;
        }

        while (current.next != null) {
            current = current.next;
        }

        return current;
    }
}
