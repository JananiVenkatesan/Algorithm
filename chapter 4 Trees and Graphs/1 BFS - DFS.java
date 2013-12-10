public Node BFS(Node node, int key){
	if(node == null){
		return null;
	}
	if(node.val == key){
		return node;
	}
	node.state = State.Visited;
	Queue<Node> queue = new Queue<Node>();

	while(!queue.isEmpty()){
		Node n = queue.remove();
		while( (Node adj = n.getAdjUnvisited()) != null){
			if(adj.val == key){
				return adj;
			}
			adj.state = State.Visited;
			queue.add(adj);
		}
	}
	return new Node(Integer.MIN_VALUE);
}

public Node DFS(Node node, int key){
	if(node == null){
		return null;
	}
	if(node.val == key){
		return node;
	}
	node.state = State.Visited;
	Stack<Node> stack = new Stack<Node>();
	while(!stack.isEmpty()){
		Node n = stack.peek();
		Node adj = n.getAdjUnvisited();
		if(adj != null){
			if(adj.val == key){
				return adj;
			}
			adj.state = State.Visited;
			stack.push(adj);
		}else{
			stack.pop();
		}
	}
	return new Node(Integer.MIN_VALUE);
}