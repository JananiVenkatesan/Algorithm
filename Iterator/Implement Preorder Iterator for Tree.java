import java.util.*;

class PreOrderTree implements Iterator<Integer> {  
    TreeNode cur = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public PreOrderTree(TreeNode node){
        if(node != null){
            cur = node;
            stack.push(cur);
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public Integer next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        TreeNode node = stack.pop();
        if(node.right != null)
            stack.push(node.right);
        if(node.left != null)
            stack.push(node.left);
        return (Integer)node.val;
    }
    
    public void remove(){}
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Test  {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(6);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n4.right = n6;
        n5.left = n7;

        PreOrderTree it = new PreOrderTree(root);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}