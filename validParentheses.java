/*
Given a string containing just the characters 
'(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, 
"()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
	public boolean isValid(String s) {
		if (s == null || s.length() <= 1 || s == " ") {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		Set<Character> set = new HashSet<Character>();
   		set.add('(');
   		set.add('{');
   		set.add('[');

   		for(Character c : s.toCharArray()) {
   			if (set.contains(c)) {
   				stack.push(c);
   			} else {
   				if (!stack.isEmpty() && helper(stack.peek(), c)) {
   					stack.pop();
   				} else {
   					return false;
   				}
   			}
   		}
   		return stack.isEmpty();

	}

	private boolean helper(Character c1, Character c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
				|| (c1 == '[' && c2 == ']');
	}
}