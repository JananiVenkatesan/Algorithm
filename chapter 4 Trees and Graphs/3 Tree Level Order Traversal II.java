public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return lists;
        
        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        l.add(root);
        value.add(root.val);
        lists.add(value);
        
        while(l.size() != 0){
            ArrayList<TreeNode> prev = l;
            l = new ArrayList<TreeNode>();
            value = new ArrayList<Integer>();
            
            for(TreeNode n : prev){
                if(n.left != null){
                    l.add(n.left);
                    value.add(n.left.val);
                }
                if(n.right != null){
                    l.add(n.right);
                    value.add(n.right.val);
                }
            }
            if(value.size() != 0){
                lists.add(0,value);  // IMPORTANT!! LinkedList -> addFirst(index, E); But this is ArrayList
            }
        }
        return lists;
    }
}