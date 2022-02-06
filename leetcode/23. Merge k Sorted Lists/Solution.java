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
        if( lists == null || lists.length ==0) return null;
        ListNode temp = lists[0];
        
         for(int i = 1; i< lists.length; i++){
             temp = merge(temp, lists[i]);
         }
        
        return temp;
        
    }
    
    private ListNode merge(ListNode first , ListNode second){
        ListNode temp = null, head = null;
        
        while(first != null && second != null){
            if(first.val < second.val){
              if(head == null){
                    head = new ListNode(first.val);
                    temp = head;
              }else {
                  temp.next = new ListNode(first.val);
                  temp = temp.next;
              }
            first = first.next;
                
        }else{
            if(head == null){
                    head = new ListNode(second.val);
                    temp = head;
            }else{
                    temp.next = new ListNode(second.val);
                     temp = temp.next;
                }
            second = second.next;
            }
            
        }
        
        while(first != null){
            
            if(head == null){
                head = new ListNode(first.val);
                temp = head;
            }else{
            temp.next = new ListNode(first.val);
            temp = temp.next;
            }
            
            first = first.next;
        }
        
        while(second != null){
             if(head == null){
                head = new ListNode(second.val);
                temp = head;
            }else{
            temp.next = new ListNode(second.val);
            temp = temp.next;
            }
            second = second.next;
        }
        
        
        return head;
    }
    
    
    private ListNode makeNode(ListNode head, ListNode temp, int val){
        
        
        return temp;
    }
}
