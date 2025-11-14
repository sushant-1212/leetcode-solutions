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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* aH = NULL;
        ListNode* aT = NULL;
        ListNode* i = list1;
        ListNode* j = list2;
        if(list1==NULL && list2==NULL){
            return NULL;
        }
        if(list1!=NULL && list2==NULL){
            return list1;
        }
        if(list1==NULL && list2!=NULL){
            return list2;
        }

        while(i!=NULL && j!=NULL){
            if(i->val<=j->val){
                if(aH==NULL){
                    aH = i;
                    aT = i;
                } else{
                    aT->next = i;
                    aT = i;
                }
                i=i->next;
            } else{
                if(i->val>j->val){
                    if(aH==NULL){
                        aH = j;
                        aT = j;
                    } else{
                        aT->next = j;
                        aT = j;
                    }
                    j=j->next;
                }
            }
        }
        if(i!=NULL){
            aT->next=i;
        }
        if(j!=NULL){
            aT->next=j;
        }
        return aH;
    }
};
