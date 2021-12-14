package JianZhi;

import java.util.LinkedList;
import java.util.Queue;

public class T28 {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	return judge(root.left, root.right);
    	
    }
    public boolean judge(TreeNode A, TreeNode B) {
    	if(A==null && B==null) return true;
    	if(A==null || B==null) return false;
    	return (A.val==B.val) && judge(A.left, B.right) && judge(A.right, B.left);
    }
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(1);
		queue.addLast(2);
		queue.addLast(3);
//		System.out.println(queue.pollFirst());
//		System.out.println(queue.pollFirst());
//		System.out.println(queue.pollFirst());
		System.out.println(queue.pollLast());
		System.out.println(queue.pollLast());
		System.out.println(queue.pollLast());
	}
}
