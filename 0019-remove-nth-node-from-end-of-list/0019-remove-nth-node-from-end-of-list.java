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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i=0; i< n; i++){
            fast = fast.next;
        }

        //edge case
        //if fast == null -> delete head
        if(fast== null){
            return head.next;
        }
        
        // Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Delete node
        slow.next = slow.next.next;
        return head;

    }
}