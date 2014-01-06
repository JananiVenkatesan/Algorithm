/*
Problem:
	Given a directed graph, design an algorithm to find out 
whether there is a route between two nodes.

Solution: 
	BFS or DFS
*/

public enum State{
	Unvisited, Visited;
}

// BFS
public boolean search(Graph g, Node start, Node end){
	LinkedList<Node> list = new LinkedList<Node>();

	for(Node node : g){
		node.state = State.Unvisited;
	}

	start.state = State.Visited;
	list.add(start);
	while(list.size() != 0){
		Node n = list.removeFirst();
		while((Node adj = n.getAdjUnvisited()) != null){
			if(adj == end)
				return true;
			adj.state = State.Visited;
			list.add(adj);
		}
	}
	return false;
}

// DFS
public boolean search(Graph g, Node start, Node end){
	Stack<Node> stack = new Stack<Node>();

	for(Node node: g){
		node.state = State.Unvisited;
	}

	start.state = State.Visited;
	stack.push(start);
	while(!stack.isEmpty()){
		Node n = stack.peek();
		Node adj = n.getAdjUnvisited();
		if(adj != null){
			if(adj == end){
				return true;
			}
			adj.state = State.Visited;
			stack.push(adj);
		}
		else{
			stack.pop();
		}
	}
	return false;
}







