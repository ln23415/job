package JianZhi;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T41 {
	// 假如数据是 1, 2, 3, 4, 5, 6, 7, 8, 9
	// 小顶堆放的都是较大的元素 = 5, 6, 7, 8, 9
	// 大顶堆放的都是较小的元素 =    4, 3, 2, 1
	static Queue<Integer> minHeap = new PriorityQueue<Integer>();
	
	
	static Queue<Integer> maxHeap = new PriorityQueue<Integer>((x, y) -> (y - x));
	
	public T41() 
	{
		
	}
	
    public void addNum(int num) 
    {
    	if(minHeap.size() != maxHeap.size()) {
    		minHeap.add(num);
    		maxHeap.add(minHeap.poll());
    	}else {
    		maxHeap.add(num);
    		minHeap.add(maxHeap.poll());
    	}
    }
    
    public static double findMedian() 
    {
    	if(minHeap.size() != maxHeap.size()) {
    		return minHeap.peek();
    	}
    	else {
    		return (minHeap.peek() + maxHeap.peek()) / 2;
    	}
    }
    public static void main(String[] args) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		System.out.println(findMedian());
//		minHeap.add(9);
//		minHeap.add(2);
//		minHeap.add(5);
//		while(minHeap.size()>0) {
//			System.out.println(minHeap.poll());
//		}
	}
}
