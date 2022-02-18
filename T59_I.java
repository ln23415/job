package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class T59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length == 0 || k == 0) return new int[0];
    	Deque<Integer> deque = new LinkedList<Integer>();
    	int i = 0, j = 0, idx = 0;
    	int[] res = new int[nums.length - k + 1];
    	
    	// 怎么判断循环条件是((j - i) != k)还是((j - i + 1) != k)
    	// 可以带入j = i = 0, k = 1, 时试一下，如果用((j - i + 1) != k)，第一个nums的元素进不去窗口
    	while((j - i) != k) { 
    		while(!deque.isEmpty() && deque.peekLast()<nums[j]) {
    			deque.removeLast();
    		}
    		deque.offerLast(nums[j++]);
    	}
    	
    	
    	res[idx++] = deque.peekFirst();
    	// idx指向的是res中下一个最大值，下面的循环判断(idx < (res.length)) 就好，如果(idx < (res.length-1))
    	// 会导致res缺少最后一个值就返回了
    	
    	while(idx < (res.length)) {
    		if(nums[i++] == (int)deque.peekFirst()) {
    			deque.removeFirst();
    		}
    		
    		// 形成窗口后，j指向窗口中最后一个元素的下一个元素
    		// 所以这里直接判断deque.peekLast()<nums[j]就好
    		while(!deque.isEmpty() && deque.peekLast()<nums[j]) {
    			deque.removeLast();
    		}
    		deque.offerLast(nums[j++]);
    		res[idx++] = deque.peekFirst();
    	}
    	return res;
    	
    }
    public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		T59_I test = new T59_I();
		int[] res = test.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(res));
	}
}
