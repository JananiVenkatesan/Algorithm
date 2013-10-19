/*
	Minimum Spanning Tree for a weighted graph
*/

class Edge{
	public int srcVert;   // index of a vertex starting edge
	public int destVert;  // index of a vertex ending edge
	public int distance;  // distance from src to dest

	public Edge(int sv, int dv, int d){
		srcVert = sv;
		destVert = dv;
		distance = d;
	}
}

class PriorityQ{
	private final int SIZE = 20;
	private Edge[] queueArray;
	private int size;

	public PriorityQ(){
		queueArray = new Edge[SIZE];
		size = 0;
	}

	public void insert(Edge item){
		int i;
		for(i = 0; i < size; i++)  // find place to insert
			if(item.distance >= queueArray[i].distance)
				break;
		for(int j = size - 1; j >= i; j--)  // move items up
			queueArray[j + 1] = queueArray[j];
		queueArray[i] = item;  // insert item
		size++;
	}

	public Edge removeMin(){  // remove minimum item
		return queueArray[--size];
	}

	public void removeN(int n){  // remove item at n
		for(int i = n; i < size - 1; i++)
			queueArray[i] = queueArray[i + 1];
		size--;
	}

	public Edge peekMin(){  // peek at minimum item
		return queueArray[size - 1];
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}	

	public Edge peekN(int n){  // peek at item n
		return queueArray[n];
	}

	public int find(int findDex){
		for(int i = 0; i < size; i++)
			if(queueArray[i].destVert == findDex)
				return i;
		return -1;
	}
}

class Vertex{
	public char label;
	public boolean isInTree;
	public Vertex(char l){
		label = l;
		isInTree = false;
	}
}

class Graph{
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex[] vertexList;  // list of vertices
	private int[][] adjMatrix;    // adjacency matrix
	private int nVerts;			  // current number of vertices
	private int currentVert;
	private PriorityQ thePQ;	  // number of verts in tree
	private int nTree;

	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int i = 0; i < MAX_VERTS; i++)
			for(int j = 0; j < MAX_VERTS; j++)
				adjMatrix[i][j] = INFINITY;
		thePQ = new PriorityQ();
	}

	public void addVertex(char l){
		vertexList[nVerts++] = new Vertex(l);
	}

	public void addEdge(int start, int end, int weight){
		adjMatrix[start][end] = weight;
		adjMatrix[end][start] = weight;
	}

	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}

	public void mstv(){   // minimum spanning tree of weighted graph
		currentVert = 0;  // start at 0 in vertexList[]
		while(nTree < nVerts - 1){  // while not all verts in tree 
			// put currentVert in tree
			vertexList[currentVert].isInTree = true;
			nTree++;
			// insert edges adjacent to currentVert into Priority Queue
			for(int i = 0; i < nVerts; i++){  // for each vertex
				if(i == currentVert)  // skip if it’s us
					continue;
				if(vertexList[i].isInTree)  // skip if in the tree
					continue;
				int distance = adjMatrix[currentVert][i];
				if(distance == INFINITY)  // skip if no edge
					continue;
				putInPQ(i, distance);  // put it in PQ (maybe)
			}
			if(thePQ.size() == 0){  // no vertices in PQ?
				System.out.println("GRAPH NOT CONNECTED");
				return;
			}
			// remove edge with minimum distance, from PQ
			Edge theEdge = thePQ.removeMin();
			int sourceVert = theEdge.srcVert;  // source vert
			currentVert = theEdge.destVert;    // destination vert
			// display edge from source to current
			displayVertex(sourceVert); 
			displayVertex(currentVert); 
			System.out.print(" ");
		}

		// mst is complete
		for(int i = 0; i < nVerts; i++) // unmark vertices
			vertexList[i].isInTree = false;
	}

	public void putInPQ(int newVert, int newDist){
		// is there another edge with the same destination vertex?
		int queueIndex = thePQ.find(newVert);
		if(queueIndex != -1){  // if there is one, get edge's index
			Edge tempEdge = thePQ.peekN(queueIndex);
			int oldDist = tempEdge.distance;
			if(oldDist > newDist){  // if new edge shorter,
	 			thePQ.removeN(queueIndex);  // remove old edge
	 			Edge theEdge = new Edge(currentVert, newVert, newDist);
	 			thePQ.insert(theEdge);  // insert new edge
	  		}
		}else{
			// so insert new one
			Edge theEdge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(theEdge);
		}
	}
}

class MSTW{
	public static void main(String[] args){
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); 
		theGraph.addVertex('B'); 
		theGraph.addVertex('C'); 
		theGraph.addVertex('D'); 
		theGraph.addVertex('E'); 
		theGraph.addVertex('F');

		theGraph.addEdge(0, 1, 6); 
		theGraph.addEdge(0, 3, 4);
		theGraph.addEdge(1, 2, 10); 
		theGraph.addEdge(1, 3, 7);
		theGraph.addEdge(1, 4, 7);
		theGraph.addEdge(2, 3, 8);
		theGraph.addEdge(2, 4, 5);
		theGraph.addEdge(2, 5, 6);
		theGraph.addEdge(3, 4, 12);  
		theGraph.addEdge(4, 5, 7);
		System.out.print("Minimum spanning tree: "); 
		theGraph.mstv(); // minimum spanning tree 
		System.out.println();
	} 
} 




