package JianZhi;

public class T55_II {
    public static boolean isBalanced(TreeNode root) {
    	if(root == null){
			return true;
		}
    	return (Math.abs(deep(root.left) - deep(root.right)) <= 1) && 
    			isBalanced(root.left) && isBalanced(root.right);
    }
    public static int deep(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
		return Math.max(deep(root.left) + 1, deep(root.right) + 1);
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.left.left =  new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		System.out.println(isBalanced(root));
		
    
    
    }
}

