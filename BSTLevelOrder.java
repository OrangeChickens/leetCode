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

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                toAdd.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(toAdd);
        }
        return res;
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

