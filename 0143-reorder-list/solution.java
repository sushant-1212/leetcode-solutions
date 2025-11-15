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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null || head.next==null){
            return;
        }
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next=null;
        ListNode prev = null;
        ListNode current = second;
        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second = prev;
        ListNode first = head;
        while(first!=null && second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            if(t1==null) break;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
