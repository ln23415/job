package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T59_II {
	Queue<Integer> queue;
	Deque<Integer> auxiliary_queue;
    public T59_II() {
    	queue = new LinkedList<Integer>();
    	auxiliary_queue = new LinkedList<Integer>();
    }
    
    public int max_value() {
    	return auxiliary_queue.isEmpty()? -1: auxiliary_queue.peekFirst();
    }
    
    public void push_back(int value) {
    	queue.offer(value);

		while((!auxiliary_queue.isEmpty()) && auxiliary_queue.peekLast() < value) {
			auxiliary_queue.removeLast();
		}
		auxiliary_queue.offerLast(value);
    	
    }
    
    public int pop_front() {
    	if (queue.isEmpty()) {
			return -1;
		}
    	int value = queue.poll();
    	if(value == (int)auxiliary_queue.peekFirst()) {
    		auxiliary_queue.poll();
    	}
    	return value;
    }
}
