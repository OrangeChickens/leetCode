/*
Given a binary tree, imagine yourself standing on the right 
side of it, return the values of the nodes you can see ordered 
from top to bottom.
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/
public class Solution {

	public List<Integer> rightSideView(TreeNode root) {
		HashMap<Integer, Integer> df = new HashMap<Integer, Integer>();
		dfs(df, root, 1);
		List<Integer> toReturn = new ArrayList();
		for(Integer k : df.values()) {
			toReturn.add(k);
		}
		return toReturn;

	}
	private void dfs(HashMap<Integer, Integer> df, TreeNode root, int depth) {
		if(root == null) {
			return;
		}
		df.put(depth, root.val);
		dfs(df, root.left, depth + 1);
		dfs(df, root.right, depth + 1);
	}

}