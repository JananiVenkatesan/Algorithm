import java.util.*;

class Queue{
	private final int SIZE = 20;
	private LinkedList<Integer> list;

	public Queue(){
		list = new LinkedList<Integer>();
	}

	public void insert(int i){
		list.addLast(i);
	}
	public int remove(){
		return list.removeFirst();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
}

class Vertex{
	public char label;
	public boolean wasVisited;

	public Vertex(char l){
		label = l;
		wasVisited = false;
	}
}

class Graph{
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;  // list of vertices
	private int[][] adjMatrix;    // adjacency matrix
	private int nVerts;			  // current number of vertice
	private Queue queue;

	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];

		for(int i = 0; i < MAX_VERTS; i++)
			for(int j = 0; j < MAX_VERTS; j++)
				adjMatrix[i][j] = 0;
		queue = new Queue();
	}

	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	public void addEdge(int start, int end){
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex].label);
    }

    public void bfs(){
    	vertexList[0].wasVisited = true;
    	displayVertex(0);
    	queue.insert(0);  // insert at tail

    	while(!queue.isEmpty()){
    		int v1 = queue.remove();
    		int v2;
    		while((v2 = getAdjUnvisitedVertex(v1)) != -1){
    			vertexList[v2].wasVisited = true;
    			displayVertex(v2);
    			queue.insert(v2);  // insert at tail
    		}
    	}

    	for(int i = 0; i < nVerts; i++)
    		vertexList[i].wasVisited = false;
    }

    public int getAdjUnvisitedVertex(int v){
    	for(int i = 0; i < nVerts; i++)
    		if(adjMatrix[v][i] == 1 && vertexList[i].wasVisited == false)
    			return i;
    	return -1;
    }

}

public class BreadthFirstSearch{
	public static void main(String[] args){
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); 
		theGraph.addVertex('B'); 
		theGraph.addVertex('C'); 
		theGraph.addVertex('D'); 
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');
		theGraph.addVertex('I');

		theGraph.addEdge(0, 1); 
		theGraph.addEdge(0, 2); 
		theGraph.addEdge(0, 3); 
		theGraph.addEdge(0, 4);
		theGraph.addEdge(1, 5);
		theGraph.addEdge(5, 7);
		theGraph.addEdge(3, 6);
		theGraph.addEdge(6, 8);


		System.out.print("Visits: ");
		theGraph.bfs(); // breadth-first search 
		System.out.println();
		/*
			Visits: ABCDEFGHI
		*/
	} 
} 