class Stack{
    private final int SIZE = 20;
    private int[] st;
    private int top;
    
    public Stack(){
        st = new int[SIZE];
        top = -1;
    }
    public void push(int v){
        top++;
        st[top] = v;
    }
    public int pop(){
        return st[top--]; 
    }
    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return (top == -1);
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
    private int[][] adjMat;       // adjacency matrix
    private int nVerts;           // current number of vertices
    private Stack stack;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        // set adjacency matrix to 0
        for(int i = 0; i < MAX_VERTS; i++)
            for(int j = 0; j < MAX_VERTS; j++)
                adjMat[i][j] = 0;
        stack = new Stack();
    }

    public void addVertex(char label){
        vertexList[nVerts] = new Vertex(label);
        nVerts++;
    }
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex].label);
    }

    // depth-first search
    public void dfs(){
        vertexList[0].wasVisited = true;  // start from vertexList[0]
        displayVertex(0);
        stack.push(0);  // push vertexList[0] to stack

        while(!stack.isEmpty()){  // while stack is not empty
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1){
                stack.pop();
            }else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        // reset flags
        for(int i = 0; i < nVerts; i++){
            vertexList[i].wasVisited = false;
        }
    }

    // returns an unvisited vertex adjacent to v
    public int getAdjUnvisitedVertex(int v){
        for(int i = 0; i < nVerts; i++){
            // if there is connection and the adjacent vertex has not been visited yet
            if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
                return i;  // return the index of the adjacent vertex
        }
        // there is no adjacent unvisited vertex
        return -1;
    }
}

public class DepthFirstSearch{
    public static void main(String[] args){
        Graph theGraph = new Graph();
        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2 
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC 
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE

        System.out.println("Visits: ");
        theGraph.dfs(); // depth-first search 
        System.out.println();
        /*
            Visits: ABCDE
        */
    } 
}
