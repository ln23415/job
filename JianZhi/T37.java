package test;

import java.util.LinkedList;
import java.util.Queue;

public class T37 {
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root == null) return "[]";
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        StringBuilder stringBuilder = new StringBuilder("[");
//        while(!queue.isEmpty()) {
//        	TreeNode node = queue.poll();
//        	if(node != null) {
//        		stringBuilder.append(node.val).append(",");
//        		queue.offer(node.left);
//        		queue.offer(node.right);
//        	}
//        	else {
//        		stringBuilder.append("null,");
//        	}
//        }
//        stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]");
//        return stringBuilder.toString();
//    }
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        String[] vals = data.substring(1, data.length()-1).split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[i++]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	if(!"null".equals(vals[i])) {
        		node.left = new TreeNode(Integer.parseInt(vals[i]));
        		queue.offer(node.left);
        	}
        	i ++;
        	if(!"null".equals(vals[i])) {
        		node.right = new TreeNode(Integer.parseInt(vals[i]));
        		queue.offer(node.right);
        	}
        	i ++;
        }
        return root;
    }
    
    public static void main(String[] args) {
		T37 test = new T37();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(test.serialize(root));
		
		TreeNode node = test.deserialize("[3,1,2,null,null,6,7,null,null,null,null]");
		System.out.println(node);
	}
    
}
