/*
Problem:
	You have a stack of n boxes, with widths w(i), heights h(i) and 
depths d(i). The boxes cannot be rotated and can only be stacked on 
top of one another if each box in the stack is strictly larger than 
the box above it in width, height, and depth. Implement a method to 
build the tallest stack possible, where the height of a stack is the 
sum of the heights of each box.
*/

// Recursive
public ArrayList<Box> createStack(Box[] boxes){
	if(boxes == null || boxes.length == 0)
		return new ArrayList<Box>();
	Box bottom = findLargestBox(boxes);
	return createStack(boxes, bottom);
}

private ArrayList<Box> createStack(Box[] boxes, Box bottom){
	ArrayList<Box> max_stack = new ArrayList<Box>();
	int max_height = 0;
	for(int i = 0; i < boxes.length; i ++){
		if(boxes[i].canBeAbove(bottom)){
			ArrayList<Box> new_stack = createStack(boxes, boxes[i]);
			int h = new_stack.size();
			if(h > max_height){
				max_height = h;
				max_stack = new_stack;
			}
		}
	}
	if(bottom != null){
		max_stack.add(0, bottom);
	}
	return max_stack;
}



// Dynamic Programming
public ArrayList<Box> createStack(Box[] boxes){
	if(boxes == null || boxes.length == 0)
		return new ArrayList<Box>();
	Box bottom = findLargestBox(boxes);
	HashMap<Box, ArrayList<Box>> hm = new HashMap<Box, ArrayList<Box>>();
	return createStack(boxes, bottom, hm);
}

private ArrayList<Box> createStack(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> hm){
	if(hm.containsKey(bottom))
		return hm.get(bottom);
	ArrayList<Box> max_stack = new ArrayList<Box>();
	int max_height = 0;
	for(int i = 0; i < boxes.length; i ++){
		if(boxes[i].canBeAbove(bottom)){
			ArrayList<Box> new_stack = createStack(boxes, boxes[i], hm);
			int h = new_stack.size();
			if(h > max_height){
				max_height = h;
				max_stack = new_stack;
			}
		}
	}
	if(bottom != null){
		max_stack.add(0, bottom);
	}
	hm.put(bottom, max_stack);
	return (ArrayList<Box>)max_stack.clone();  // IMPORTANT!!!
}



