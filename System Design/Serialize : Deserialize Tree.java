/*
http://www.cs.usfca.edu/~galles/cs245/lecture/lecture9.pdf
http://stackoverflow.com/questions/4611555/how-to-serialize-binary-tree/18422820#18422820
*/

import java.util.*;

class TreeNode{
	byte value;
	TreeNode lChild, rChild;

	public TreeNode(byte v){
		value = v;
		lChild = null;
		rChild = null;
	}
}

class SerializeTree{
	public byte[] serialize(TreeNode root){
		if(root == null)
			return null;
		ArrayList<Byte> list = new ArrayList<Byte>();
		serialize(root, list); 
		// System.out.println(list);
		return toByteArray(list);
	}

	private void serialize(TreeNode node, ArrayList<Byte> list){
		if(node == null){
			list.add((byte)0);
			return;
		}
		list.add((byte)node.value);
		serialize(node.lChild, list);
		serialize(node.rChild, list);
	}

	private byte[] toByteArray(ArrayList<Byte> list){
		byte[] values = new byte[list.size()];
		int i = 0;
		for(Byte value : list){
			values[i] = value;
			i ++;
		}
		return values;
	}

	public TreeNode deserialize(byte[] values){
		Pair p = deserialize(values, 0);
		return p.node;
	}

	private Pair deserialize(byte[] values, int index){
		byte value = values[index];
		if(value == 0){
			return new Pair(null, index + 1);
		}

		TreeNode node = new TreeNode(value);

		Pair p1 = deserialize(values, index + 1);
		node.lChild = p1.node;

		Pair p2 = deserialize(values, p1.rightStartIndex);
		node.rChild = p2.node;

		return new Pair(node, p2.rightStartIndex);
	}

	private static final class Pair{ 
		TreeNode node;
		int rightStartIndex;

		private Pair(TreeNode n, int i){
			node = n;
			rightStartIndex = i;
		}
	}
}

public class Test{
	public static void printTree(TreeNode node){
		System.out.println();
		System.out.println("Print Tree : ");
		printTreeInorder(node);
		System.out.println();
	}

	public static void printTreeInorder(TreeNode node){
		if(node == null){
			System.out.print(0 + " ");
			return;
		}
		System.out.print(node.value + " ");
		printTreeInorder(node.lChild);
		printTreeInorder(node.rChild);
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode((byte)10);

		TreeNode p1 = new TreeNode((byte)1);
		TreeNode p2 = new TreeNode((byte)2);
		TreeNode p3 = new TreeNode((byte)3);
		TreeNode p4 = new TreeNode((byte)4);
		TreeNode p5 = new TreeNode((byte)5);
		TreeNode p6 = new TreeNode((byte)6);

		root.lChild = p1;
		root.rChild = p5;
		p1.lChild = p2;
		p2.lChild = p3;
		p2.rChild = p4;

		printTree(root);


		SerializeTree s = new SerializeTree();
		byte[] values = s.serialize(root);
		for(Byte b : values){
			System.out.print(b + " ");
		}

		TreeNode newroot = s.deserialize(values);
		printTree(newroot);

	}
}



