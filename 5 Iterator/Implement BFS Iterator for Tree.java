import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class BFSTree implements Iterable<Integer>{
    TreeNode root; 

    public BFSTree(TreeNode node){
        if(node != null){
            root = node;
        }
    }

    public Iterator<Integer> iterator(){
        return new MyIterator();
    }

    private class MyIterator<Integer> implements BFSTreeIterator<Integer>{
        int cur = -1;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        public MyIterator{
            cur = -1;
            list.add(root));  // Initialization
        }

        public boolean hasNext(){
            if(cur < list.size() - 1){  // cur is not the end of the ArrayList
                return true;
            }   
            else if(cur == list.size() - 1){  // cur is the end of the ArrayList
                for(TreeNode n : list){  // Some nodes in the list have children
                    if(n.left != null || n.right != null){
                        return true;
                    }
                }
                return false;  // All nodes in the list don't have children
            }
            else
                return false;
        }

        public Integer next(){
            if(cur < list.size() - 1){
                cur ++;
                return (Integer)(list.get(cur)).val;
            }
            if(cur == list.size() - 1){  // cur is the end of the ArrayList
                ArrayList<TreeNode> temp = new ArrayList<TreeNode>();  // Traverse next level
                for(TreeNode n : list){
                    if(n.left != null){
                        temp.add(n.left);
                    }
                    if(n.right != null){
                        temp.add(n.right);
                    }
                }

                if(temp.size() == 0){  // No more element in the tree
                    throw new NoSuchElementException();
                }
                list = temp;  // Switch ArrayList
                cur = 0;  // Reset cur
                return (Integer)(list.get(cur)).val;
            }
        }
        public void remove(){}
    }
}

interface BFSTreeIterator<Integer> extends Iterator<Integer> { 
    public boolean hasNext();
    public Integer next();
    public void remove();
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

        BBFSTree it = new BFSTree(root);
        while(it.hasNext()){
            System.out.println(it.next());
        }
      }
}