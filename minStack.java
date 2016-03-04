/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

class Minstack {
	private class Node {
		int val;
		int min;
		Node next;
		Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
	Node head = null;

	public void push(int x) {
		if (head == null) {
			head = new Node(x, x, null);
		} else {
			head = new Node(x, Math.min(head.min, x), head);
		}
	}

	public void pop() {
		head = head.next;
	}

	public void top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

}