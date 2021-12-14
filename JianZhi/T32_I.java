package JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JianZhi.TreeNode;
public class T32_I {
    public int[] levelOrder(TreeNode root) {
    	if (root == null) {
			return new int[0];
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	List<Integer> list = new ArrayList<Integer>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		list.add(node.val);
    		if(node.left!=null) queue.add(node.left);
    		if(node.right!=null) queue.add(node.right);
    	}
        int re[] = new int[list.size()];
        for(int i=0; i<re.length; i++) {
        	re[i] = list.get(i);
        }
        return re;
    }
}
