package JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T34 {
	
//	     1. ΪʲôpathҪ�����LinkedList������ArrayList��
//			���������һ����������path���������ɾ��һ��Ԫ��
//			�����ArrayList��Ԫ��ʱ��path.remove(root.val)��root.val�ᱻ���Ϊɾ��index=root.val��Ԫ�أ�
//			��ʹ��path.remove((Integer)root.val)��һ�������ظ�Ԫ�أ����ǻ�ɾ����Ϊ�����ǻ�������
//			
	
	LinkedList<Integer> path = new LinkedList<Integer>(); 
	List<List<Integer>>  paths = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        2. Ϊʲô��д�ɣ��Ͼ����root.val������target����û��Ҫ�ټ������������ӽڵ���
//    		if(root == null && root.val > target) {
//    			return paths;
//    		}
//    	  ��Ϊ�������ֵ�Ǹ��ģ���root.val=-2, root.left.val=-3, target=-5�����������Ͳ������ˡ�
    	
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
