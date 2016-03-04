/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (n <= 0) {
    		return null;
    	}

    	ListNode temp = new ListNode(0);
    	temp.next = head;
    	ListNode pre = temp;
    	for (int i = 0; i < n; i++) {
    		if (head == null) {
    			return null;
    		}
    		head = head.next;
    	}

    	while(head != null) {
    		head = head.next;
    		pre = pre.next;
    	}

    	pre.next = pre.next.next;
    	return temp.next;
    }
}