package JianZhi;
import java.util.Arrays;
import java.util.Stack;

public class T06 {
    public static int[] reversePrint(ListNode head) {
    	Stack<Integer> s = new Stack<Integer>();
    	while(head!=null) {
    		s.push(head.val);
    		head = head.next;
    	}
    	int re[] = new int[s.size()];
    	for(int i=0; !s.empty(); i++) { //ע�⣬����for��ѭ������������s.size()����Ϊÿpopһ�Σ�size�ͻ�-1
    		re[i] = s.pop();
    	}
    	return re;
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		System.out.println(Arrays.toString(reversePrint(head)));
	}
}
