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
	LinkedList<Node> queue = new LinkedList<Node>();

	for(Node n : g.getNodes()){
		n.state = State.Unvisited;
	}

	queue.add(start);
	start.state = State.Visited;
	while(!queue.isEmpty()){
		Node n = queue.removeFirst();
		while( (Node adj = getUnvisitedAdj(n)) != null)
			if(adj == end){
				return true;
			} 
			if(adj != null){
				queue.addLast(adj);
				adj.state = State.Visited;
			}
		}
	}
	return false;
}

// DFS
public boolean search(Graph g, Node start, Node end){
	Stack<Node> stack = new Stack<Node>();

	for(Node n : g.getNodes()){
		n.state = State.Unvisited；
	}

	start.state = State.Visited;
	stack.push(start);
	while(!stack.isEmpty()){
		Node n = getUnvisitedAdj(stack.peek());
		if(n == null){
			stack.pop();
		}else{
			if(n == end){
				return true;
			}
			n.state = State.Visited();
			stack.push(n);
		}
	}
	return false;
}








