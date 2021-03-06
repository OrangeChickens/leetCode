/*Merge two sorted linked lists and return i
t as a new list. The new list should be made by splicing 
together the nodes of the first two lists.

Show Company Tags
Show Tags
Show Similar Problems

*//**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode x;
        if(l1.val <= l2.val ) {
            x = new ListNode(l1.val);
            x.next = mergeTwoLists(l1.next, l2);
        } else {
            x = new ListNode(l2.val);
            x.next = mergeTwoLists(l1,l2.next);
        }
        return x;
    
    }
}
