// Inorder
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while(!stack.isEmpty()){
            cur = stack.pop();
            list.add(cur.val);
            
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return list;
    }
}

// Preorder 1
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            list.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return list;
    }
}

// Preorder 2
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            list.add(cur.val);
            stack.push(cur);
            cur = cur.left;
        }
        
        while(!stack.isEmpty()){
            cur = stack.pop();
            cur = cur.right;
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
        }
        return list;
    }
}

// Postorder 1
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
            
        Stack<Integer> reverse = new Stack<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);

        while(!stack.isEmpty()){
            cur = stack.pop();
            reverse.push(cur.val);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        
        while(!reverse.isEmpty()){
            list.add(reverse.pop());
        }
        return list;
    }
}

// Postorder 2
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> mirror = new Stack<Integer>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            mirror.push(cur.val);
            cur = cur.right;
        }
        
        while(!stack.isEmpty()){
            cur = stack.pop();
            cur = cur.left;
            while(cur != null){
                stack.push(cur);
                mirror.push(cur.val);
                cur = cur.right;
            }
        }
        
        while(!mirror.isEmpty()){
            list.add(mirror.pop());
        }
        return list;
    }
}