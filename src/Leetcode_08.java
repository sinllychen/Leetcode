import java.util.ArrayList;

class  TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Leetcode_08 {
	 private ArrayList<Integer> nodes=new ArrayList<Integer>();
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
	          if(root==null)
	        	   return nodes;
	          nodes.add(root.val);
	          if(root.left!=null)
	        	   preorderTraversal(root.left);
	          if(root.right!=null)
	        	   preorderTraversal(root.right);
	          return nodes;
	 }
	 public static void main(String[] args)
	 {
		   TreeNode root=new TreeNode(1);
		   root.right=new TreeNode(2);
		   root.right.left=new TreeNode(3);
		   ArrayList<Integer> list=new Leetcode_08().preorderTraversal(root);
		   for(int value:list)
			   System.out.print(value+" ");
	 }
}
