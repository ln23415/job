package JianZhi;

public class T22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode forehead_p = head;
        for(int i=1; i<k; i++) {
        	forehead_p = forehead_p.next;
        }
        while(forehead_p.next!=null) {
        	head = head.next;
        	forehead_p = forehead_p.next;
        }
        return head;
    }
}
