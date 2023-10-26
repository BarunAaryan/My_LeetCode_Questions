/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //check if current node or next node is null
        if(node==null || node.next== null){
            return;
        }
        //copy value of next node to current node
        node.val = node.next.val;
        //skip the next node change the pointer 
        node.next = node.next.next;
    }
}