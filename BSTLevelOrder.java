/*Binary Tree Level Order Traversal
*/
public List<List<Integer>> BSTLevelOrder(TreeNode root) {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	helper(0, root, res);
	return res;

}

private void helper(int level, TreeNode root, List<List<Integer>> res) {
	if(root = null) {
		return;
	}
	if(res.size() <= level) {
		res.add(new LinkedList<Integer>());
	}
	res.get(level).add(root.val);
	helper(level+1, root.left, res);
	helper(level+1, root.right, res);
}



// using queue

public void BSTLevelOrder(TreeNode root) {
	if(root == null) {
		return;
	}
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	q.add(root);
	while(!q.isEmpty()) {
		TreeNode tN = q.poll();
		System.out.println(tN.val);
		if(tN.left != null) {
			q.add(tN.left);
		}
		if(tN.right != null) {
			q.add(tN.right);
		}
	}
}


// levelOrder bottom up
public List<List<Integer>> BSTLevelOrder(TreeNode root) {
	List<List<Integer>> res = new LinkedList<List<Integer>>();
	helper(1, root, res);
	return res;

}

private void helper(int level, TreeNode root, List<List<Integer>> res) {
	if(root = null) {
		return;
	}
	if(res.size() < level) {
		res.add(0,new LinkedList<Integer>());
	}
	res.get(res.size() - level).add(root.val);
	helper(level+1, root.left, res);
	helper(level+1, root.right, res);
}

