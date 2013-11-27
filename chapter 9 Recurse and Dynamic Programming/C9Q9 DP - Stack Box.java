
// Recursive

public ArrayList<Box> createStack(Box[] boxes){
	if(boxes == null)
		return null;
	Box bottom = findLargestBox(boxes);
	return createStack(boxes, bottom);	
}

public ArrayList<Box> createStack(Box[] boxes, Box bottom){
	int max_height = 0;
	ArrayList<Box> max_stack = null;
	for(int i = 0; i < boxes.length; i ++){
		if(boxes[i].canBeAbove(bottom)){
			ArrayList<Box> new_stack = createStack(boxes, boxes[i]);
			int new_height = new_stack.size();
			if(new_height > max_height){
				max_stack = new_stack;
				max_height = new_height;
			}
		}
	}

	if(max_stack == null){
		max_stack = new ArrayList<Box>();
	}

	if(bottom != null){
		max_stack.add(0,bottom);  // Insert in bottom of stack
	}

	return max_stack;
}


// Dynamic Programming

public ArrayList<Box> createStackDP(Box[] boxes){
	if(boxes == null)
		return null;
	Box bottom = findLargestBox(boxes);
	return createStackDP(boxes, bottom, new HashMap<Box, ArrayList<Box>> hm);
}

public ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> hm){
	if(hm.containsKey(bottom)){
		return hm.get(bottom);
	}
	int max_height = 0;
	ArrayList<Box> max_stack = null;
	for(int i = 0; i < boxes.length; i ++){
		if(boxes[i].canBeAbove(bottom)){
			ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], hm);
			int new_height = new_stack.size();
			if(new_height > max_height){
				max_height = new_height;
				max_stack = new_stack;
			}
		}
	}

	if(max_stack == null){
		max_stack = new ArrayList<Box>();
	}
	if(bottom != null){
		max_stack.add(0, bottom);
	}
	hm.put(bottom, max_stack);
	return (ArrayList<Box>)max_stack.clone();
}



