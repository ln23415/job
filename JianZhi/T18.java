package JianZhi;

public class T18 {
    public ListNode deleteNode(ListNode head, int val) {
    	ListNode cur = head;
    	ListNode pre = null;
    	while(cur!=null) {
    		if(cur.val == val) {
    			if(pre == null) {	// 如果第一个节点是要被删除的
    				head = cur.next;	// 更新要返回的head指针
                    cur = cur.next;		// 更新cur指针
                    continue;
    			}else {
    				pre.next = cur.next;
    				if (cur.next!=null) {	//如果cur当前指向的不是最后一个节点
        				cur = pre.next;
                        continue;
					}else {			// 如果cur当前指向的是最后一个节点，执行cur = pre.next;就会报错因为pre.next是null，所以break
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
