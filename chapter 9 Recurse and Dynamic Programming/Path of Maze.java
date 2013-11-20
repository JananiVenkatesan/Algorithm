/*
  -------------
  |   |   |   |
  |         e |
  |   |   |   |
  -   ---------
  |   |   |   |
  |            |
  |   |   |   |
  -----   -   -
  |   |   |   |
  | s   S |   |
  |   | S |   |
  -------------

        3
        ^
        |
  2<--+-->0
        |
        V
        1

*/
bool isEnd(Pos pos);
bool isBlocked(Pos pos, int dir);
Pos  move(Pos pos, int dir);


public boolean findPath(Pos pos){
	if(pos == null)
		return null;
	return findPathHelper(pos);
}

public boolean findPathHelper(Pos pos){
	if(isEnd(pos))
		return true;
	if(!isBlocked(pos, 0))
	return findPathHelper(move(p, 0 ));
}
	else if(!isBlocked(pos, 1))
		return findPathHelper(move(p, 1));
	else if(!isBlocked(pos, 2))
		return findPathHelper(move(p, 2));
	else
		return findPathHelper(move(p, 3));
}





public Stack<Pos> findPath(Pos pos){
	if(pos == null)
		return null;
	Stack<Pos> stack = new Stack<Pos>();
	stack.push(pos);
	pos.state = State.Visited;
	while(!stack.isEmpty()){
		Pos p = stack.peek();
		Pos adj = getUnvisitedPos(p);
		if(adj != null){
			if(isEnd(adj))
				return stack;
			pos.state = State.Visited;
			stack.push(adj);
}
else{
	stack.pop();
}
}
return null;
}

public Pos getUnvisitedPos(Pos p){
	if(!isBlock(p, 0) && move(p, 0).state != Visited)
		return move(p, 0);
	else if(!isBlock(p, 1) && move(p,1).state != Visited)
		return move(p, 1);
	else if(!isBlock(p,2) && move(p, 2).state != Visited)
		return move(p,2);
	else if(!isBlock(p,3) && move(p,3).state != Visited)
		return move(p,3);
	return null;
}

class enum State{
	Visited, Unvisited;
}



