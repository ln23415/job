package JianZhi;

public class T18 {
    public ListNode deleteNode(ListNode head, int val) {
    	ListNode cur = head;
    	ListNode pre = null;
    	while(cur!=null) {
    		if(cur.val == val) {
    			if(pre == null) {	// �����һ���ڵ���Ҫ��ɾ����
    				head = cur.next;	// ����Ҫ���ص�headָ��
                    cur = cur.next;		// ����curָ��
                    continue;
    			}else {
    				pre.next = cur.next;
    				if (cur.next!=null) {	//���cur��ǰָ��Ĳ������һ���ڵ�
        				cur = pre.next;
                        continue;
					}else {			// ���cur��ǰָ��������һ���ڵ㣬ִ��cur = pre.next;�ͻᱨ����Ϊpre.next��null������break
						break;
					}
    			}
    		}
			pre = cur;
			cur = cur.next;
    	}
    	return head;
    }
}
