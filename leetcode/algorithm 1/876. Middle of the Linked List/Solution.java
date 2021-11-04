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
    public ListNode middleNode(ListNode head) {
        ListNode faster = head, slow = head;
        if(isNull(head) || isNull(slow.next)) return head;
        while( !isNull(faster) && !isNull(faster.next)){
            slow = slow.next;
            faster = faster.next;
            if(!isNull(faster)) faster = faster.next;
        }
        return slow;
        
    }
    private boolean isNull(ListNode node){
        return node == null;
    }
}
