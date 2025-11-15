/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        if(head==NULL || head->next==NULL){
            return;
        }
        while(fast!=NULL && fast->next!=NULL && fast->next->next!=NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* second = slow->next;
        slow->next = NULL;
        ListNode* prev = NULL;
        ListNode* temp = second;
        while(temp!=NULL){
            ListNode* nxt = temp->next;
            temp->next = prev;
            prev = temp;
            temp = nxt;
        }
        second = prev;
        ListNode* first = head;
        while(first!=NULL && second!=NULL){
            ListNode* t1 = first->next;
            ListNode* t2 = second->next;
            first->next = second;
            if(t1==NULL) break;
            second->next = t1;
            first = t1;
            second = t2;
        }
        
    }
};
