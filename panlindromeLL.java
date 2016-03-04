/*Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	ListNode middle = findMiddle(head);
    	middle.next = reverse(middle.next);

    	ListNode l1 = head;
    	ListNode l2 = middle.next;

    	while (l1 != null && l2 != null & l1.val == l2.val) {
    		l1 = l1.next;
    		l2 = l2.next;
    	}

    	return l2 == null;

    }

    private ListNode findMiddle(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    private void reverse(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = null;
    	while(head != null) {
    		cur = head.next;
    		head.next = pre;
    		pre = head;
    		head = cur;
    	}
    	return pre;

    }
}