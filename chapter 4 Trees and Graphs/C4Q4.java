/*

Problem:

	Given a binary tree, design an algorithm which creates a linked 
list of all the nodes at each depth (e.g., if you have a tree with 
depth D, you'll have D linked lists).



Solution 1:

	Using depth first search (DFS).

	We can implement a simple modification of the pre-order traversal 
algorithm, where we pass in level + 1 to the next recursive call.The 
code below provides an implementation using DFS.

*/

public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, 
									int level){
	if(root == null)
		return;

	LinkedList<TreeNode> list = null;
	if(ArrayList.size() == level){  // ArrayList does not contain this level
		list = new LinkedList<TreeNode>();
	}else{
		list = lists.get(level);
	}

	list.add(root);
	createLevelLinkedList(root.left, lists, level + 1);
	createLevelLinkedList(root.right, lists, level + 1);
}

public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>(); 
	createLevelLinkedList(root, lists, 0);
	return lists;
}

/*

Solution 2:

	Using breadth first search (BFS).
	we can also implement a modification of breadth first search. 
With this implementation, we want to iterate through the root first, 
then level 2, then level 3, and soon.
	With each level i, we will have already fully visited all nodes 
on level i - 1. This means that to get which nodes are on level i, 
we can simply look at all children of the nodes of level i - 1.
*/

ArrayList<ArrayList<Node>> createLevelList(Node root){
	ArrayList<ArrayList<Node>> lists = new ArrayList<ArrayList<Node>>();
	if(root == null){
		return lists;
	}

	LinkedList<Node> l = new LinkedList<Node>();
	l.add(root);
	while(l.size() != null){
		LinkedList<Node> prev = l;
		l = new LinkedList<Node>();

		for(Node n : prev){
			if(n.left != null){
				l.add(n.left);
			}
			if(n.right != null){
				l.add(n.right);
			}
		}
		lists.add(l);
	}
	return lists;
}


/*
	One might ask which of these solutions is more efficient. Both 
run in 0(N) time, but what about the space efficiency? At first, we 
might want to claim that the second solution is more space efficient.

	In a sense, that's correct. The first solution uses O(log N) 
recursive calls, each of which adds a new level to the stack. The 
second solution, which is iterative, does not require this extra space.
*/

