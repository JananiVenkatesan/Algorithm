import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class BFSTree implements BFSTreeIterator<Integer>{
    int cur = -1;
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();

    public BFSTree(TreeNode node){
      if(node != null){
        cur = -1;
        list.add(node);
      }
    }

    public boolean hasNext(){
        if(cur < list.size() - 1){
            return true;
        }   
        else if(cur == list.size() - 1){
            for(TreeNode n : list){
                if(n.left != null || n.right != null){
                    return true;
                }
            }
            return false;
        }
        else
            return false;
    }

    public Integer next(){
        if(cur < list.size() - 1){
            cur ++;
            return (Integer)(list.get(cur)).val;
        }
        else if(cur == list.size() - 1){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for(TreeNode n : list){
                if(n.left != null){
                    temp.add(n.left);
                }
                if(n.right != null){
                    temp.add(n.right);
                }
            }

            if(temp.size() == 0){
                throw new NoSuchElementException();
            }
            list = temp;
            cur = 0;
            return (Integer)(list.get(cur)).val;
        }
        else
            return null;
    }
    public void remove(){}
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