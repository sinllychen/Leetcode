import java.util.ArrayList;

public class Leetcode_07 {
	   private  ArrayList<Integer> nodes=new ArrayList<Integer>();
	   public ArrayList<Integer> postorderTraversal(TreeNode root) {
		       if(root==null)
		    	   return nodes;
		       if(root.left!=null)
		    	      postorderTraversal(root.left);
		       if(root.right!=null)
		    	      postorderTraversal(root.right);
		       nodes.add(root.val);	     
		       return nodes;
	   }
	   public static void main(String[] args)
	   {
		   TreeNode root=new TreeNode(1);
		   TreeNode right=new TreeNode(2);
		   root.right=right;
		   TreeNode left=new TreeNode(3);
		   right.left=left;
		   ArrayList<Integer> list=new Leetcode_07().postorderTraversal(root);
		   for(int value : list)
			   System.out.print(value+"  ");
	   }
}
