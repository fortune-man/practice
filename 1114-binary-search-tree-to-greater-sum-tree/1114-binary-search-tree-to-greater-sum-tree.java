/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// ㅇ

class Solution {
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
    
    inorder(root,list);
    
    ArrayList<Integer> ls = new ArrayList();
    int len = list.size();
    int sum=0;
    
    for(int i=len-1;i>-1;i--)
    {
        sum+=list.get(i);
        ls.add(sum);
    }
    
    Collections.reverse(ls);
    
    helper(root,list,ls);
    
    return root;
}

    public void inorder(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return ;
        
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        
    }


    public void helper(TreeNode root,ArrayList<Integer> l1,ArrayList<Integer> l2)
    {
        if(root==null)
            return ;
    
        helper(root.left,l1,l2);
        int i=l1.indexOf(root.val);
        root.val=l2.get(i);
            
        helper(root.right,l1,l2);
        
    }  
}