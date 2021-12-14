package JianZhi;

import java.util.LinkedList;
import java.util.Queue;

public class T27 {
    public TreeNode mirrorTree(TreeNode root) {
    	
    	if(root==null) return root;
    	TreeNode tmpNode = root.left;
    	root.left = root.right;
    	root.right = tmpNode;
    	mirrorTree(root.left);
    	mirrorTree(root.right);
    	
    	return root;
    	
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
	}
}
