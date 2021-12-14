package JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T34 {
	
//	     1. 为什么path要定义成LinkedList而不是ArrayList，
//			这个函数种一个需求是在path中先添加再删除一个元素
//			如果用ArrayList，元素时用path.remove(root.val)，root.val会被理解为删除index=root.val的元素，
//			即使用path.remove((Integer)root.val)，一旦出现重复元素，还是会删错因为整形是基本类型
//			
	
	LinkedList<Integer> path = new LinkedList<Integer>(); 
	List<List<Integer>>  paths = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        2. 为什么不写成，毕竟如果root.val都大于target了那没必要再继续遍历它的子节点了
//    		if(root == null && root.val > target) {
//    			return paths;
//    		}
//    	  因为如果树中值是负的，如root.val=-2, root.left.val=-3, target=-5，这种条件就不成立了。
    	
    	if(root == null) {
    		return paths;
    	}
    	
    	path.add(root.val);
    	if(root.val == target && root.left==null && root.right==null) {
    		paths.add(new ArrayList<Integer>(path));
    	}
    	else{
			pathSum(root.left, target - root.val);
			pathSum(root.right, target - root.val);
		}
    	path.removeLast();
    	return paths;
    }
    
}
