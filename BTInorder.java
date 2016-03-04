/*Given a binary tree, return the inorder traversal of its nodes' values. */

//recursion
public void BSTinorder(Treenode root) {
	if(root != null) {
		BSTinorder(root.left);
		System.out.println(root.value);
		BSTinorder(root.right);
	}
}



public List<Integer> BSTinorder(Treenode root) {
	List<Integer> res = new ArrayList<Integer>();
    Stack<Treenode> stack  = new Stack<Treenode>();
    if(root == null) {
    	return res;
    }
    while(root != null || !stack.isEmpty()) {
    	while(root != null) {
	    	stack.push(root);
	    	root = root.left;
	    }
	    root = stack.pop();
	    res.add(root.val);
	    root = root.right;
    }
    return res;

}