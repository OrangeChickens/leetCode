/*Merge k sorted linked lists and return it as 
one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
        	return null;
        }

        PriorityQuese<ListNode> pq = new PriorityQuese<ListNode>(lists.length, new Comparator<ListNode>() {
        	public int compare(ListNode o1, ListNode o2) {
        		return o1.val - o2.val;
        	}
    	});
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        for(ListNode l: lists) {
        	pq.add(l);
        }
        while(pq.size() != 0) {
        	tail.next = pq.poll();
        	tail = tail.next;
        	if(tail.next != null) {
        		pq.add(tail.next);
        	}
        }
    return temp.next;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(4);
		ListNode b = new ListNode(3);
		ListNode[] lists = new ListNode[2];
		lists[0] = a;
		lists[1] = b;
		ListNode c = mergeKLists(lists);
		System.out.println(c);
	}
}