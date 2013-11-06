class Path{
	TreeNode p, q;
	LinkedList<TreeNode> pPath;
	LinkedList<TreeNode> qPath;

	public Path(TreeNode p, TreeNode q){
		this.p = p;
		this.q = q;
	}
}

enum State{
	Visited, Unvisited;
}
// DFS
public Path findPath(TreeNode root, TreeNode p, TreeNode q){
	if(root == p || root == q){
		return null;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();

	Path path = new Path(p, q);

	root.state = State.Visited;
	stack.push(root);
	while(!stack.isEmpty()){
		TreeNode t = getUnvisitedAdj(stack.peek());
		if(t == null){
			stack.pop();
		}else{
			if(t == p || t == q){
				copyStackPath(t, stack, path);
			}
			t.state = Visited;
			stack.push(t);
		}
	}
	pathToCommonAncestor(path);
	retrun path;
}
// Copy stack to list in Path
public void copyStackPath(TreeNode t, Stack<TreeNode> stack, Path path){
	if(t == p){
		Stack<TreeNode> pStack = stack;
		path.pPath.add(pStack.pop());
	}else{
		Stack<TreeNode> qStack = stack;
		path.qPath.add(qStack.pop());		
	}
}
// Remove nodes from root to their common ancestor
public void pathToCommonAncestor(Path path){
	while(path.pPath.getLast() == path.qPath.getLast()){
		path.pPath.removeLast();
		path.qPath.removeLast();
	}
}










