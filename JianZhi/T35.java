package JianZhi;

import java.util.HashMap;
import java.util.Map;

public class T35 {
    public Node copyRandomList(Node head) {
    	if(head == null)
    		return null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        while(p != null) {
        	map.put(p, new Node(p.val));
        	p =  p.next;
        }
        p = head;
        while(p != null) {
        	map.get(p).next = p.next;
        	map.get(p).random = p.random;
        }
        return map.get(head);
    }
}
