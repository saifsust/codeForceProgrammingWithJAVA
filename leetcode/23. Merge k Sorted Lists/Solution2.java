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
   
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head =  null , temp = null;
        
        for(int min = getMinimum(lists); min != Integer.MAX_VALUE ; min = getMinimum(lists)){
            ListNode node = new ListNode(min);
            if(head == null){
                head = node;
                temp = head;
            }else {
                temp.next = node;
                temp = temp.next;
            }
        }
        
        return head;
        
    }
    
    private int getMinimum(ListNode[] lists){
        int min = Integer.MAX_VALUE;
        int minIdx = - 1;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                minIdx = i;
            }
        }
        
        if(min != Integer.MAX_VALUE){
            lists[minIdx] = lists[minIdx].next;
        }
        return min;
    }
}
