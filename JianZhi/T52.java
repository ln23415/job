package JianZhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	Set<ListNode> set = new HashSet<ListNode>();
    	
        while(headA!=null) {
        	set.add(headA);
        	headA = headA.next;
        }
        while (headB!=null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
        return null;
    }
}
