enum State{
	Unvisited, Visited;
}


public Node BFS(Node node, Node key){
	if(node.data == key.data)
		return node;

	Queue<Node> queue = new Queue<Node>();

	node.state = State.Visited;
	queue.add(node);

	while(!queue.isEmpty()){
		Node current = queue.remove();
		while( (Node adj = getUnvisitedAdj(current)) != null){
			if(adj.data == key.data){
				return adj;
			}
			adj.state = State.Visited;
			queue.add(adj);
		}
	}
	return null;
}

//-------------------

public Node DFS(Node node, Node key){
	if(node.data == key.data)
		return node;

	Stack<Node> stack = new Stack<Node>();

	node.state = State.Visited;
	stack.push(node);

	while(!stack.isEmpty()){
		Node current = getUnvisitedAdj(stack.peek());
		if(current == null){
			stack.pop();
		}else{
			if(current.data == key.data){
				return current;
			}
			current.state = State.Visited;
			stack.push(current);
		}
	}
	return null;
}