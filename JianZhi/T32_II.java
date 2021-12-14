package JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JianZhi.TreeNode;
public class T32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> re = new ArrayList<List<Integer>>();
    	if (root==null) {
    		return re;
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		List<Integer> row = new ArrayList<Integer>();
    		int iters = queue.size();
    		for(int i=0; i<iters; i++) {
    			TreeNode node = queue.poll();
    			row.add(node.val);
    			if(node.left!=null) queue.add(node.left);
    			if(node.right!=null) queue.add(node.right);
    		}
    		re.add(row);
    	}
    	return re;
    	
    }
	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);
		
		List<Integer> c = new ArrayList<Integer>();
		c.add(3);
		c.add(4);
		c.add(5);
		a.add(b);
		a.add(c);
		Object[] p = a.toArray();
		System.out.println("");
	}
}
