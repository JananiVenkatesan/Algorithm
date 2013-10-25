/*
Problem:
	Imagine a robot sitting on the upper left comer of an X by Ygrid. The robot 
can only move in two directions: right and down. How many possible paths are there 
for the robot to go from (0, 0) to (X, Y) ?

Solution：
*/

public boolean getPath(int x, int y, ArrayList<Point> path){
	Point p = new Point(x, y);
	path.add(p);
	if(x == 0 && y == 0){
		return true;  // found a path
	}
	boolean success = false;
	if(x >= 1 && isFree(x - 1, y)){  // Try left
		success = getPath(x - 1, y, path);  // go left!
	}
	if(!success && y >= 1 && isFree(x, y - 1)){  // Try down
		success = getPath(x, y - 1, path);  // go down!
	} 
	if(success){
		path.add(p);  // add to path
	}
	return success;
}

/*
FOLLOW UP:
	Imagine certain spots are "off limits," such that the robot cannot step on them. 
Design an algorithm to find a path for the robot from the top left to the bottom 
right.

Solution:
	Earlier, we'd mentioned an issue with duplicate paths. To find a path 
to (X,Y), we look for a path to an adjacent coordinate: (X-1,Y) or (X, Y -l). 
Of course, if one of those squares is off limits, we ignore it. Then, we 
look at their adjacentcoordinates: (X-2,Y), (X-ljY-1), (X-ljY-l^and (X,Y-2).
The spot (X-1,Y-1) appears twice, which means that we're duplicating effort. 
Ideally, we should remember that we already visited (X-l^Y-l) sothat we don't
waste our time.
	This is what the dynamic programming algorithm below does.
*/

public boolean getPath(int x, int y, 
	   ArrayList<Point> path, HashTable<Point, Boolean> cache){
	Point p = new Point(x, y);
	if(cache.containsKey(p)){  // Already visited this cell
		return cache.get(p);
	}
	if(x == 0 && y == 0){
		return true;  // found a path
	}
	boolean success = false;
	if(x >= 1 && isFree(x - 1, y)){  // try right
		success = getPath(x - 1, y, path, cache);  // Free! Go right
	}
	if(!success && y >= 1 && isFree(x, y - 1)){  // try down
		success = getPath(x, y - 1, path, cache);  // Free! Go down
	}
	if(success){
		path.add(p); // Right way! Add to path
	}
	cache.put(p, success);
	return success;
}