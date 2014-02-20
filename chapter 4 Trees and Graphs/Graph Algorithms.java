-------------- Minimum Spanning Tree --------------
/**

  Time complexity: O(VlogV + ElogV)

  The only difference with Dijkstra's algorithm is that when we store the neighbours
to T in a heap, we use priority values equal to the shortest edge connecting them to T,
rather than the smallest sum of "edge length plus distance of endpoint to s"
*/
function Prims(){
	for(v = 0; v < V; v ++)
		for(w = 0; w < V; w ++)
			dist[v][w] = infinity;  // Distance from v to w is infinity
			previous[w] = null;  // Previous node in optimal path from source

			PQ.add_with_priority(dist[v][w])


	while PQ is not empty
		dist[v][w] = PQ.extract_min()  // Every time extract the point with minimum distance to the source
		previous[w] = v

		for all t in adj(w)
			dist[w][t] = length(w, t)
			PQ.decrease_priority()  // Reorder v in the Queue

	return dist
}

-------------- Shortest Paths --------------

/**
  Used to find the minimum path

  Essence : Every time extract the point with minimum distance to the source

  Time complexity: O(VlogV + ElogV)
*/
function Dijkstra(Graph, source){
	dist[source] = 0
	for(v = 0; v < V; v ++)
		dist[v] = infinity;  // Unknown distance function from source to v
		previous[v] = null;  // Previous node in optimal path from source

		PQ.add_with_priority(v, dist[v])

	while PQ is not empty
		v = PQ.extract_min()  // Every time extract the point with minimum distance to the source

		for all w in adj(v)
			alt = dist[v] + length(v, w)
			if alt < dist[w]
				dist[w] = alt
				previous[w] = v
				PQ.decrease_priority(v, alt)  // Reorder v in the Queue

	return dist
}

/**
  Bellman-Ford uses DP to compute the shortest paths problem, 
  and it can deal with negative path weight 
 
  Time complexity: O(VE)
 
*/
function Bellman-Ford(Graph, source){
	// Step 1: initialize graph
	for(v = 0; v < V; v ++)
		dist[v] = infinity;
	dist[source] = 0;

	Queue q = new Queue();
	q.enqueue(source);

	// Step 2: relax edges repeatedly
	while(!q.isEmpty()){	// O(V)
		v = q.dequeue();
		for all w in adj(v)		// O(E)
			if(dist[w] > dist[v] + length[v, w])
				dist[w] = dist[v] + length[v, w];
				if(!q.isInQueue(w))
					q.enqueue(w);
	}

	// Step 3: check for negative-weight cycles
	for each edge (u, v) with weight w in edges:
       if distance[u] + w < distance[v]:
           error "Graph contains a negative-weight cycle"
}

// d[v][i] denotes the length of the shortest path from v to source that uses i or fewer edges
function Bellman-Ford(){
	for v != source
		d[v][0]	= infinity
	for i = 0 to n-1
		d[t][i] = 0

	for i = 1 to n - 1
		for each v != t
			d[v][i] = min(len(v, x) + d[x][i - 1])

	for each v
		output d[v][n - 1]
}

-------------- All Pairs Shortest Paths --------------
/**
   Floyd-Warshall uses DP to solve APSP problem
 
   Time complexity: O(v^3)

   After each iteration of the outside loop, A[i][j] = length of the 
shortest i -> j path that's allowed to use vertices in the set 1 .. k
*/
// Initialization
for i = 1 to n
	for j = 1 to n
		if (i, j) is in E
			A[i][j] = length(i, j)

for k = 1 to	// Use k as an intermediate vertice
	for i = 1 to n    //
		for j = 1 to n
			A[i][j] = min( A[i][j], A[i][k] + A[k][j] )


// This is not a symmetric matrix since the graph is directed

     1   2          ...  k  ... j   ... n
-------------------------------------------
1    0
-------------------------------------------
2        0
-------------------------------------------

-------------------------------------------
i 				 0      i,k    i,j     
-------------------------------------------
...
-------------------------------------------
k					       0   k,j
-------------------------------------------
...
-------------------------------------------
n 								        0
-------------------------------------------



-------------- Classification Of Edges --------------

for all v in V
	num[v] = 0
	stack[v] = false

for all v in V
	if num[v] == 0
		DFS(v)

k = 0

DFS(v){
	k ++
	num[v] = k
	stack[v] = true

	for all w in adj(v)
		if num[w] == 0	// Tree edge
			DFS(w)
		else if num[w] > num[v]  // Forward edge
		else if stack[w]  // Back edge
		else	// Cross edge

	stack[v] = false
}

-------------- Biconnected Components --------------
/**
	To find articulation point and biconnect components

	Articulation point: A vertex is an articulation point if its removal disconnect a graph

	A graph is biconnected if it has no articulation points
*/

for all v in V
	dfs[v] = 0

for all v in V
	if dfs[v] == 0
		BCC(v)

k = 0
S - empty stack

BCC(v){
	k ++
	dfs[v] = k
	low[v] = k
	
	for all w in adj(v)
		if dfs[w] == 0	// Unvisited nodes
			S.push( (v, w) )
			BCC(w)
			low[v] = min( low[v], low[w] )
			if low[w] >= dfs[v]
				S.popAll()
		else if dfs[w] < dfs[v] && w in S  // Backedge
			S.push( (v, w) )
			low[v] = min( low[v], dfs[w] ) 
}


-------------- Strongly Connected Components --------------

/**
	G is strongly connected if every pair (u,v) of vertices is reachable from one another
	
	A strongly connected component of G is a maximal set of vertices C such that all vertices 
in C are reachable

	A vertex is called a BASE iff it has the lowest dfs number in the SCC      dfs[v] = low[v]
*/

for all v in V
	dfs[v] = 0

for all v in V
	if dfs[v] == 0
		SCC(v)

k = 0
S - empty stack

SCC(v){
	k ++
	dfs[v] = k
	low[v] = k
	S.push(v)

	for all w in adj(v)
		if dfs[w] == 0  // Unvisited
			SCC(w)
			low[v] = min( low[v], low[w])
		else if dfs[w] < dfs[v] && w in S  // Back edge, no pop here
			low[v] = min( low[v], dfs[w] )

	if low[v] == dfs[v]	 // Base vertex of a component
		S.pop where dfs[u] >= dfs[v]  // Pop all vertice u that dfs[u] >= dfs[v]
}















