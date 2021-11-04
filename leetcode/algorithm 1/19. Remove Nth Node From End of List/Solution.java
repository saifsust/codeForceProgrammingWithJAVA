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
        if(isNull(head)) return null;
        
        int len  = length(head) - n;
        ListNode prev = null,next = null, temp = head;
        
        while(!isNull(temp) && len >= 1){
            prev = temp;
            temp = temp.next;
            --len;
        }
        
        next = temp.next;
        temp.next = null;
        if(!isNull(prev)) prev.next = next;
        else {
            head = next;
        }
        
        return head;
    }
    
    
    private int length(ListNode node){
        int len  = 0;
        while(!isNull(node)){
            ++len;
            node = node.next;
        }
        return len;
    }
    private boolean isNull(ListNode node){return node == null;}
    
}
