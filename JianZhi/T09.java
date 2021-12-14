package JianZhi;

import java.util.Stack;

public class T09 {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public T09() {
		
	}
	public void appendTail(int value) {
		s1.push(value);
	}
	
    public int deleteHead() {
    	if(!s2.empty()) {
    		return s2.pop();
    	}
    	else if (s1.empty()) {
    		return -1;
		}
    	else {
        	while(!s1.empty()) {
        		s2.push(s1.pop());
        	}
        	return s2.pop();
		}

    }
    public static void main(String[] args) {
    	
	}
}
