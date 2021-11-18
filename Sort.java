package job;

import java.util.Arrays;
import java.util.Iterator;

import javax.xml.transform.Templates;

public class Sort {
	
	
	public static void main(String[] args) {
//		int arr[] = {2,6,5,0,0,4,1};
//		int arr[] = {0,0,0,0,0,0};
		int arr[] = {3,4,7,9,5,8,8,2,0};
//		arr = selection_sort(arr);
//		arr = bubble_sort(arr);
		arr = shell_sort(arr);
//		System.out.println(Arrays.toString(arr));
//		MinHeap_Sort(arr, arr.length);
//		MaxHeap_Sort(arr, arr.length);
//		insertion(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	// 插入排序
	// 从数组的第二个元素开始，持续与##前一个##元素判断，如果当前元素比前一个小，就与前一个元素对调位置
	// 直到把元素移到正确的位置
	public static void insertion(int arr[]) {
		for(int i=1; i<arr.length; i++) {	//从第二个元素开始，因为要与第一个元素判断
			for(int j=i; j>0 && arr[j]<arr[j-1]; j--) { //j指向当前元素，j左边的数组应该是已经排好序的了
				swap(arr, j, j-1);
			}
		}
	}
	public static void MinHeap_Sort(int arr[], int length){
		
		/*
		 * 1. 先建立最小堆
		 * 2. 从最后一个叶子节点开始（索引），与当前最小堆的根节点换位置，视为将根节点，
		 *    也就是最小值出栈，于是代表数组长度的i元素减1，然后再对刚换到根节点的元素，也就是数组的第一个元素，索引为0
		 *    做minHeapSink(arr, 0 ,i)操作，将数组的0到i间的元素调整成新的最小堆，随后循环刚才的操作
		 */
		

		  MakeMinHeap(arr,length);
		  for(int i=length-1;i>0;i--){
			  swap(arr, 0, i);
		      minHeapSink(arr, 0 ,i);
		  }    
		}
	
	
	public static void MakeMinHeap(int a[], int length){
		// 从最后一个叶子节点，索引为数组长度(length-1)，找到它的父节点，也就是整个堆所有父节点中最后面的父节点，索引为(length-1)/2，然后从这个父节点开始与它的
		// 叶子节点判断调整，如果叶子节点比它小就对调，把值小的叶子结点上浮，让它的根节点下沉。然后调整当前父节点的前一个父节点节点，循环
		 for(int i=(length-1)/2 ; i>=0 ; i--){
		     minHeapSink(a,i,length);
		 }
	}
	public static void minHeapSink(int arr[],int i,int length){

		   // i 代表根节点的索引
		   int j = 2*i+1; //j代表索引为i的根节点的左子节点

		   while(j<length){
		       //在左右子节点中寻找最小的
		       if(j+1<length && arr[j+1]<arr[j]){  //j+1是索引为i的根节点的右子节点
		           j++;
		       }

		       if(arr[i] <= arr[j])	//如果根节点小于等于它的叶子结点，就跳出循环不用调整了
		           break;

		       //把值小的叶子结点上浮，让它的根节点下沉
		       swap(arr, i, j);
		       i = j; //继续追踪这个结点的值，向下判断
		 
		       j = 2*i+1;
		       
		       //在建立好最小堆后，排序调整时只需要继续追踪移到顶点的元素即可，也就是原来追踪i，随后加入左子节点比它小，i=j，还是继续追踪这个数值。
		       //不用管没有换的另一边右子节点，因为没有调整肯定还是最小堆
		   }
		}
	public static void MaxHeap_Sort(int arr[], int length) {
		/*
		 * 1. 先建立最大堆
		 * 2. 从最后一个叶子节点开始（索引），与当前最大堆的根节点换位置，视为将根节点，
		 *    也就是最大值出栈，于是代表数组长度的i元素减1，然后再对刚换到根节点的元素，也就是数组的第一个元素，索引为0
		 *    做maxHeapSwim(arr, 0 ,i)操作，将数组的0到i间的元素调整成新的最大堆，随后循环刚才的操作
		 */
		
		MakeMaxHeap(arr, length);
		for(int i=length-1; i>0; i-- ) {
			swap(arr, 0, i);
			maxHeapSwim(arr, 0, i);
		}
	}
	public static void MakeMaxHeap(int a[], int length){
		// 从最后一个叶子节点，索引为数组长度(length-1)，找到它的父节点，也就是整个堆所有父节点中最后面的父节点，索引为(length-1)/2，然后从这个父节点开始与它的
		// 叶子节点判断调整，如果叶子节点比它大就对调，把值大的叶子结点上浮，让它的根节点下沉。然后调整当前父节点的前一个父节点节点，循环
		 for(int i=(length-1)/2 ; i>=0 ; i--){
		     maxHeapSwim(a, i, length);
		 }
	}
	public static void maxHeapSwim(int arr[], int i, int length) {
		int j = 2*i + 1; //左节点
		while (j<length) {
			//在左右节点中找最大的
			if(j+1<length && arr[j+1]>arr[j]) {
				j++;
			}
			if(arr[i]>=arr[j])
				break;
			
			//把值大的叶子结点上浮，让它的根节点下沉
			swap(arr, i, j);
			i = j;
			j = 2*i+1;
		}
	}
	
	/*
	 * 
	 * 希尔排序，就相当跨元素版插入排序
	 * 
	 */
	public static int[] shell_sort(int[] arr) {
		
		int interval = 1;
		while (interval < arr.length/3) {
			interval = 3 * interval + 1;
		}
		while(interval >= 1) {
			for(int i=interval; i<arr.length; i++) {
				for(int j=i; j>=interval && is_less(arr[j], arr[j-interval]); j-=interval) {
					arr = swap(arr, j, j-interval);
				}
			}
			interval = interval / 3;
		}
		return arr;
	}
	
	/*
	 * 冒泡排序
	 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
	 * 相当于先排最大的元素，排完一个i就左移一个
	 * 如果中途所有元素就排好了，也就是没有发生交换操作，则就不用在跑了，neednt_sort表示“不需要排序了”，每次遍历时
	 * 都设为true认为不需要排了，遍历过程中一旦遇到逆序元素，neednt_sort就变为false表示仍需排序。
	 * 
	 */
	public static int[] bubble_sort(int[] arr) {
		boolean neednt_sort = false; //
		for (int i=arr.length-1; i>=0 && !neednt_sort; i-- ) {
			neednt_sort = true;
			for (int j=0; j<i; j++) {
				if(is_less(arr[j+1], arr[j])) {
					neednt_sort = false;
					arr = swap(arr, j, j+1);	
				}
			}
		}
		
		return arr;
	}
	
	/*
	 * 选择排序
	 * 从最小的数开始排，先用i指向数组的第一个元素，并且假设这个元素就是数组的最小值，然后用j指向它的下一个元素，
	 * 用j遍历数组，找到并记录最小值的下标minimum_idx，与i位置的元素对调，把当前最小值移到了左边
	 * 
	 */
	public static int[] selection_sort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			int minimum_idx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(is_less(arr[j], arr[minimum_idx])) {
					minimum_idx = j;
				}
			}
			arr = swap(arr, i, minimum_idx);
		}
		return arr;
	}
	public static int[] swap(int []arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}
	public static boolean is_less(int num1, int num2) {
		if (num1 < num2) {
			return true;
		}else {
			return false;
		}
	}
}
