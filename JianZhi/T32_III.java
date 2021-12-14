package JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JianZhi.TreeNode;
public class T32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> re = new ArrayList<List<Integer>>();
    	if (root==null) {
    		return re;
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int row_idx = 0; 
    	while(!queue.isEmpty()) {
    		LinkedList<Integer> row = new LinkedList<Integer>();
    		int iters = queue.size();
    		for(int i=0; i<iters; i++) {
    			TreeNode node = queue.poll();
    			if(row_idx%2==0) row.addLast(node.val);
    			else row.addFirst(node.val);
    			if(node.left!=null) {
    				queue.add(node.left);
    			}
    			if(node.right!=null) {
    				queue.add(node.right);
    			}

    		}
    		re.add(row);
    		row_idx++;
    	}
    	return re;
    	
    }
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		for (int e : ll) {
			System.out.println(e);
		}
		System.out.println(ll);
	}
}
