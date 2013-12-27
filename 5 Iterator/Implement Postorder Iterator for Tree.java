class Tree implement Iterable<Integer>{
	TreeNode root = null;

	public Tree(TreeNode t){
		root = t;
	}

	public Iterator<Integer> iterator(){
		return new MyIterator();
	}

	private class MyIterator implement PostorderIterator<Integer>{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		TreeNode cur = null;

		public MyIterator(){
			cur = root;
			stack.push(cur);

			while(!stack.isEmpty()){
				cur = stack.pop();
				list.addFirst(cur.val);
				if(cur.left != null)
					stack.push(cur.left);
				if(cur.right != null)
					stack.push(cur.right);
			}
		}

		public boolean hasNext(){
			return !list.isEmpty();
		}

		public Integer next(){
			if(!hasNext())
				throw new NoSuchElementException();
			return list.poll();
		}

		public void remove(){}
	}
}