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
		TreeNode adj = getUnvisitedAdj(stack.peek());
		if(adj == null){
			stack.pop();
		}else{
			if(adj == p || adj == q){
				copyStackPath(adj, stack, path);
			}
			adj.state = Visited;
			stack.push(adj);
		}
	}
	pathToCommonAncestor(path);
	retrun path;
}

public Node getUnvisitedAdj(TreeNode node){
	if(node == null)
		return  null;
	if(node.left != null && node.left.state == State.Unvisited)
		return node.left;
	else if(node.right != null && node.right.state == State.Unvisited)
		return node.right;
	else
		return null;
}
// Copy stack to list in Path
public void copyStackPath(TreeNode t, Stack<TreeNode> stack, Path path){
	if(t == p){
		Stack<TreeNode> pStack = stack;
		while(!pStack.isEmpty())
			path.pPath.add(pStack.pop());
	}else{
		Stack<TreeNode> qStack = stack;
		while(!qStack.isEmpty())
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










