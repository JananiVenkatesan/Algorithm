
public class ShortestPath{
	public static void main(String[] args){
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); 
		theGraph.addVertex('C'); 
		theGraph.addVertex('B'); 
		theGraph.addVertex('D'); 
		theGraph.addVertex('E');
		
		theGraph.addEdge(0, 1, 50); 
		theGraph.addEdge(0, 3, 80); 
		theGraph.addEdge(1, 2, 60); 
		theGraph.addEdge(1, 3, 90); 
		theGraph.addEdge(2, 4, 40); 
		theGraph.addEdge(3, 2, 20); 
		theGraph.addEdge(3, 4, 70); 
		theGraph.addEdge(4, 1, 50);

		System.out.println("Shortest path");
		theGraph.path(); 
		System.out.println();
	} // end main()
} // end class PathApp

/*
Shortest path
A=inf(A)
C=50(A)
B=100(D)
D=80(A)
E=140(B)
*/
class DistParent{  // distance and parent - items stored in sPath array
	public int distance;    // distance from start to this vertex
	public int parentVert;  // current parent of this vertex

	public DistParent(int pv, int d){
		parentVert = pv;
		distance = d;
	}
}

class Vertex{
	public char label;   //label(e.g. ‘A’) 
	public boolean isInTree;

    public Vertex(char lab){
		label = lab; 
		isInTree = false; 
	}
}

class Graph{
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex[] vertexList;  // list of vertices
	private int[][] adjMatrix;    // adjacency matrix
	private int nVerts;			  // current number of vertices
	private int nTree;			  // number of verts in tree
	private int currentVert;      // current vertex
	private DistParent[] sPath;   // array for shortest-path data
	private int startToCurrent;   // distance to currentVert
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMatrix = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		for(int i = 0; i < MAX_VERTS; i++)
			for(int j = 0; j < MAX_VERTS; j++)
				adjMatrix[i][j] = INFINITY;
		sPath = new DistParent[MAX_VERTS];  // shortest paths
	}

	public void addVertex(char l){
		vertexList[nVerts++] = new Vertex(l);
	}

	public void addEdge(int start, int end, int weight){
		adjMatrix[start][end] = weight;  // directed
	}

	// carries out the actual shortest-path algorithm
	public void path(){  // find all shortest paths
		int startTree = 0;  // The starting vertex is always at index 0 of the vertexList[] array. 
		vertexList[startTree].isInTree = true;
		nTree = 1;  // The first task in path() is to put this vertex into the tree

		// transfer row of distances from adjMatrix to sPath
		for(int i = 0; i < nVerts; i++){
			int tempDist = adjMatrix[startTree][i];  // startTree this the parent
			sPath[i] = new DistParent(startTree, tempDist);  // the distance between startTree and every other vertice
		}

		
		while(nTree < nVerts){  // until all vertices are in the tree
			int indexMin = getMin();  // get minimum from sPath
			int minDist = sPath[indexMin].distance;

			if(minDist == INFINITY){  // if all INFINITY or in tree, 
				System.out.println("There are unreachable vertices"); 
				break;  // sPath is complete
			}else{  // reset currentVert to the closest vertex
				currentVert = indexMin;	
				startToCurrent = minDist; //sPath[indexMin].distance;
				// minimum distance from start is to currentVert, and is startToCurrent
			}
			// put current vertex in tree
			vertexList[currentVert].isInTree = true;
			nTree++;
			adjust_sPath();  // update sPath[] array
		}   // end while(nTree<nVerts)

		displayPaths();  // display sPath[] contents

		nTree = 0;  // clear tree 
		for(int j = 0; j < nVerts; j++)
			vertexList[j].isInTree = false;
	}

	public int getMin(){  // get entry from sPath with minimum distance
		int minDist = INFINITY;  // assume large minimum
		int indexMin = 0;
		for(int i = 1; i < nVerts; i++){  // for each vertex other than vertexList[0]
			// if it is not in tree and has the shortest distance
			if(!vertexList[i].isInTree && sPath[i].distance < minDist){
				minDist = sPath[i].distance;
				indexMin = i;
			}
		}
		// return it
		return indexMin;
	}

	// update the sPath[] entries to reflect new information obtained from the vertex just inserted in the tree. 
	public void adjust_sPath(){ 
		int column = 1;  // skip starting vertex
		while(column < nVerts){  // go across columns
			// if this column’s vertex already in tree, skip it
			if(vertexList[column].isInTree){
				column++;
				continue;
			}
			// calculate distance for one sPath entry 
				// get edge from currentVert to column
			int currentToFringe = adjMatrix[currentVert][column];
				// add distance from start
			int startToFringe = startToCurrent + currentToFringe;
				// get distance of current sPath entry
			int sPathDist = sPath[column].distance;

			// compare distance from start with sPath entry
			if(startToFringe < sPathDist){  // if shorter
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}
	// display contents of sPath[]
	public void displayPaths(){
		for(int i = 0; i < nVerts; i++){ // B=
			System.out.print(vertexList[i].label + "=");   // B=
			if(sPath[i].distance == INFINITY)
				System.out.print("inf");	 // inf
			else
				System.out.print(sPath[i].distance);  // 50
			char parent = vertexList[sPath[i].parentVert].label;
			System.out.println("(" + parent + ")");  // (A)
		}
		System.out.println("");
	}
}



/*
Explanation of path() method:

    The starting vertex is always at index 0 of the vertexList[] array. 
The first task in path() is to put this vertex into the tree. As the 
algorithm proceeds, we’ll be moving other vertices into the tree as well. 
The Vertex class contains a flag that indicates whether a vertex object
is in the tree. Putting a vertex in the tree consists of setting this 
flag and incrementing nTree, which counts how many vertices are in the tree.

    Second, path() copies the distances from the appropriate row of the 
adjacency matrix to sPath[]. This is always row 0, because for simplicity 
we assume 0 is the index of the starting vertex. Initially, the parent field
of all the sPath[] entries is A, the starting vertex.

    We now enter the main while loop of the algorithm. This loop terminates 
after all the vertices have been placed in the tree. There are basically 
three actions in this loop:
    1. Choose the sPath[] entry with the minimum distance.
    2. Put the corresponding vertex (the column head for this entry) in the 
    tree. This becomes the “current vertex,” currentVert.
    3. Update all the sPath[] entries to reflect distances from currentVert.

    If path() finds that the minimum distance is infinity, it knows that 
some vertices are unreachable from the starting point. Why? Because not all 
the vertices are in the tree (the while loop hasn’t terminated), and yet 
there’s no way to get to these extra vertices; if there were, there would be 
a non-infinite distance.

    Before returning, path() displays the final contents of sPath[] by calling 
the displayPaths() method. This is the only output from the program. Also, 
path() sets nTree to 0 and removes the isInTree flags from all the vertices, 
in case they might be used again by another algorithm (although they aren’t in 
this program).

------------

Explanation of adjust_sPath() method:
    Updating sPath[] with adjust_sPath()
    
    The adjust_sPath() method is used to update the sPath[] entries to reflect 
new infor- mation obtained from the vertex just inserted in the tree. When this 
routine is called, currentVert has just been placed in the tree, and startToCurrent 
is the current entry in sPath[] for this vertex. The adjust_sPath() method now 
examines each vertex entry in sPath[], using the loop counter column to point to 
each vertex in turn. For each sPath[] entry, provided the vertex is not in the 
tree, it does three things:

    1. It adds the distance to the current vertex (already calculated and now in 
    startToCurrent) to the edge distance from currentVert to the column vertex. We 
    call the result startToFringe.

    2. It compares startToFringe with the current entry in sPath[].

	3. If startToFringe is less, it replaces the entry in sPath[].

	This is the heart of Dijkstra’s algorithm. It keeps sPath[] updated with the 
shortest distances to all the vertices that are currently known. Here’s the code 
for adjust_sPath():
*/





