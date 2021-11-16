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
//		arr = shell_sort(arr);
//		System.out.println(Arrays.toString(arr));
//		MinHeap_Sort(arr, arr.length);
//		MaxHeap_Sort(arr, arr.length);
		insertion(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void insertion(int arr[]) {
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0 && arr[j]<arr[j-1]; j--) {
				swap(arr, j, j-1);
			}
		}
	}
	public static void MinHeap_Sort(int a[], int length){
		// min heap sort 从最后一个叶子节点开始，与当前最小堆的根节点换位置，视为将根节点，
		// 也就是最大值出栈，于是代表数组长度的i元素减1，然后再对刚换到根节点的元素
		// 做minheapfixdown操作，来找到现在的最大值，循环
		  MakeMinHeap(a,length);
		  for(int i=length-1;i>0;i--){
			  swap(a, 0, i);
		      MinHeapFixdown(a,0,i);
		  }    
		}
	
	
	public static void MakeMinHeap(int a[], int length){
		// minheapfixdown 从最后一个叶子节点(length-1)找到最后一个父节点(length-1)/2，然后从这个父节点开始与它的
		// 叶子节点判断调整，如果叶子节点比它小就对调
		 for(int i=(length-1)/2 ; i>=0 ; i--){
		     MinHeapFixdown(a,i,length);
		 }
	}
	public static void MinHeapFixdown(int arr[],int i,int length){

		   int j = 2*i+1; //左子节点

		   while(j<length){
		       //在左右子节点中寻找最小的
		       if(j+1<length && arr[j+1]<arr[j]){  
		           j++;
		       }

		       if(arr[i] <= arr[j])
		           break;

		       //较大节点下移
		       swap(arr, i, j);
		       i = j;
		       j = 2*i+1;
		   }
		}
	public static void MaxHeap_Sort(int arr[], int length) {
		MakeMaxHeap(arr, length);
		for(int i=length-1; i>0; i-- ) {
			swap(arr, 0, i);
			maxHeapSwim(arr, 0, i);
		}
	}
	public static void MakeMaxHeap(int a[], int length){
		// minheapfixdown 从最后一个叶子节点找到最后一个父节点，然后从这个父节点开始与它的
		// 叶子节点判断调整，如果叶子节点比它小就对调
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
			
			swap(arr, i, j);
			i = j;
			j = 2*i+1;
		}
	}
	public static int[] shell_sort(int[] arr) {
		
		int interval = 1;
		while (interval < arr.length/3) {
			interval = 3 * interval + 1;
		}
		while(interval >= 1) {
			for(int i=0; i<arr.length; i++) {
				int minimum_idx = i;
				for(int j=i+1; j<arr.length; j++) {
					if(is_less(arr[j], arr[minimum_idx])) {
						minimum_idx = j;
					}
				}
				arr = swap(arr, i, minimum_idx);
			}
			interval = interval / 3;
		}
		return arr;
	}
	public static int[] bubble_sort(int[] arr) {
		boolean neednt_sort = false;
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
