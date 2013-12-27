/*
	Imagine certain spots are "off limits" such that the robot 
cannot step on them. Design an algorithm to find a path for the 
robot from the top left to the bottom right.

*/

// Recurse
public ArrayList<Pos> getPath(int x, int y){
	if(x < 0 || y < 0)
		return null;
	ArrayList<Pos> path = new ArrayList<Pos>();
	getPath(x, y, path);
	return path;
}

public boolean getPath(int x, int y, ArrayList<Pos> path){
	Pos p = new Pos(x, y);
	if(x == 0 && y == 0){
		path.add(p);
		return true;   // found a path
	}
	boolean feasible = false;
	if(x >= 1 && !isBlocked(x - 1, y)){  // Try left
		feasible = getPath(x - 1, y, path);   // go left!
	}
	if(!feasible && y >= 1 && !isBlocked(x, y - 1, path)){  // Try down
		feasible = getPath(x, y - 1, path);  // go up!
	}
	if(feasible){
		path.add(p);
	}
	return feasible;
}

// Dynamic Programming
public ArrayList<Pos> getPath(int x, int y){
	ArrayList<Pos> path = new ArrayList<Pos>();
	HashMap<Pos, Boolean> hm = new HashMap<Pos, Boolean>();
	return getPath(x, y, path, hm);
}

public boolean getPath(int x, int y, 
			ArrayList<Pos> path, HashMap<Pos, Boolean> hm){
	Pos p = new Pos(x, y);
	if(x == 0 && y == 0){
		path.add(p)
		return true;  // found a path 
	}
	if(hm.containsKey(p)){  // Already visited this cell
		return hm.get(p);
	}
	boolean feasible = false;
	if(x >= 1 && !isBlocked(x - 1, y)){  // try left
		feasible = getPath(x - 1, y, path, hm);  // Free! Go left
	}
	if(!feasible && y >= 1 && !isBlocked(x, y - 1)){  // try up
		feasible = getPath(x, y - 1, path, hm);    // Free! Go up
	}
	if(feasible){
		path.add(p);   // Right way! Add to path
	}
	hm.put(p, feasible);
	return feasible;
}

/*
	Given 3 methods: 
		boolean isEnd(Pos p)
		boolean isBlocked(Pos p, int dir)
		Pos move(Pos p, int dir)
*/
// Recurse
public ArrayList<Pos> getPath(Pos p){
	ArrayList<Pos> path = new ArrayList<Pos>();
	return getPath(p, path);
}

public boolean getPath(Pos p, ArrayList<Pos> path){
	if(isEnd(p)){
		path.add(p);
		return true;
	}
	boolean feasible = false;
	for(int i = 0; i < 4; i ++){
		if(!feasible && !isBlocked(move(p, i))){
			feasible = getPath(move(p, i), path);
		}
	}
	if(feasible){
		path.add(p);
	}
	return feasible;
}

// Dynamic Programming
public ArrayList<Pos> getPath(Pos p){
	ArrayList<Pos> path = new ArrayList<Pos>();
	HashMap<Pos, Boolean> hm = new HashMap<Pos, Boolean>();
	return getPath(p, path, hm);
}

public boolean getPath(Pos p, ArrayList<Pos> path, HashMap<Pos, Boolean> hm){
	if(isEnd(p)){
		path.add(p);
		return true;
	}
	if(hm.containsKey(p)){
		return hm.get(p);
	}
	boolean feasible = false;
	for(int i = 0; i < 4; i ++){
		if(!feasible && !isBlocked(move(p, i))){
			feasible = getPath(move(p, i), path, hm);
		}
	}
	if(feasible){
		path.add(p);
	}
	hm.put(p, feasible);
	return feasible;
}
