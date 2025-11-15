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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i =l1;
        ListNode j = l2;
        int carry = 0;
        ListNode ansH = null;
        ListNode ansT = null;
        while(i!=null && j!=null){
            int sum = i.val + j.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(ansH == null && ansT == null){
                ansH = newNode;
                ansT = newNode;
            } else{
                ansT.next = newNode;
                ansT = newNode;
            }
            i=i.next;
            j=j.next;
        }
        while(i!=null){
            int sum = i.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(ansH == null && ansT == null){
                ansH = newNode;
                ansT = newNode;
            } else{
                ansT.next = newNode;
                ansT = newNode;
            }
            i=i.next;
        }
        while(j!=null){
            int sum = j.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            if(ansH == null && ansT == null){
                ansH = newNode;
                ansT = newNode;
            } else{
                ansT.next = newNode;
                ansT = newNode;
            }
            j=j.next;
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            ansT.next = newNode;
            ansT = newNode;
        }
        return ansH;
    }
}
