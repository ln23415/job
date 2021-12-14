package JianZhi;

import JianZhi.ListNode;
public class T24 {
    public static ListNode reverseList(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = head;
    	while(cur!=null) {
    		ListNode nxt = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = nxt;
    	}
    	return pre;
    }
    public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(2);
		n1.next.next = new ListNode(3);
		n1.next.next.next = new ListNode(4);
		ListNode re = reverseList(n1);
		System.out.println(re);
	}
}
