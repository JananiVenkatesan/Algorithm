import java.util.*;

class InOrderTree implements InOrderIterator<Integer> {  
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = null;

    public InOrderTree(TreeNode root){
        if(root != null){
            cur = root;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
    }
    

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public Integer next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }

        return (Integer)node.val;
    }

    public void remove(){}
}


interface InOrderIterator<Integer> extends Iterator<Integer> { 
  public boolean hasNext();
  public Integer next(); 
  public void remove();
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

        InOrderTree it = new InOrderTree(root);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}