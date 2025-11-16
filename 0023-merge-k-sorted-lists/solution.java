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
        int min = (int)(1e9);
        int index = -1;
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null && lists[i].val<min){
                min = lists[i].val;
                index = i;
            }
        }
        if(index==-1){
            return null;
        }
        ListNode startNode = lists[index];
        lists[index] = lists[index].next;
        startNode.next = mergeKLists(lists);
        return startNode;
        
    }
}
