package JianZhi;

public class T26 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
    	if(A == null && B == null) return true;
    	if(A == null || B == null) return false;

    	return recurs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B); //���ڵ��������
    }
    public static boolean recurs(TreeNode A, TreeNode B) {
    	if (B == null) return true; //���������null�ˣ�˵����������Ԫ�ض������ˣ�ͨ��������true
    	if(A==null || A.val!=B.val) return false;
    	return recurs(A.left, B.left) && recurs(A.right, B.right);
    }
    public static void main(String[] args) {
    	System.out.println(isSubStructure(null, null));
	}
}
