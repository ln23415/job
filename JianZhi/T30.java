package JianZhi;

import java.util.Stack;

public class T30 {

	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> min_stack = new Stack<Integer>();
	
    public void push(int x) {
    	if(min_stack.empty()) {
    		min_stack.push(x);
    	}else {
    		if (x<=min_stack.peek()) {
				min_stack.push(x);
			}
    	}
    	s.push(x);
    }
    
    public void pop() {
    	if (s.peek() == (int)min_stack.peek()) { //���������==��ʹ��peek��ֵһ��Ҳ�᷵��false��
            // peek()�������ص���object������Ҫô ��(int)objectǿ��������ת��һ�£�Ҫô��equals�ж�
			min_stack.pop();
		}
    	s.pop();
    }
    
    public int top() {
    	return s.peek();
    }
    
    public int min() {
    	return min_stack.peek();
    }
    public static void main(String[] args) {
		T30 t = new T30();
		t.push(512);
		t.push(-1024);
		t.push(-1024);
		t.push(512);
		t.pop();
		System.out.println(t.min());
		t.pop();
		System.out.println(t.min());
		t.pop();
		System.out.println(t.min());
//		t.push(2147483646);
//		t.push(2147483646);
//		t.push(2147483647);
//		t.top();
//		t.pop();
//		System.out.println(t.min());
//		t.pop();
//		System.out.println(t.min());
//		t.pop();
//		t.push(2147483647);
//		t.top();
//		System.out.println(t.min());
//		t.push(-2147483648);
//		t.top();
//		System.out.println(t.min());
//		t.pop();
//		System.out.println(t.min());
	}
}
