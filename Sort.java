SYN(synchronous),建立联机。
ACK(acknowledgement),确认。
PSH(push),传输。
FIN(finish),结束。
RST(reset),重置。
URG(urgent),紧急。

三次握手建立连接阐述：
第一次握手：客户端要和服务端进行通信，首先要告知服务端一声，遂发出一个SYN=1的连接请求信号,”服务端哥哥，我想给你说说话”。

第二次握手：当服务端接收到客户端的连接请求，此时要给客户端一个确认信息，”我知道了（ACK）,我这边已经准备好了，你现在能连吗（SYN）”。

第三次握手：当客户端收到了服务端的确认连接信息后，要礼貌的告知一下服务端，“好的，咱们开始联通吧（ACK）”。

到此整个建立连接的过程已经结束，接下来就是双方你一句我一句甚至同时交流传递信息的过程了。




四次挥手断开连接阐述：
第一次挥手：双方交流的差不多了，此时客户端也已经结尾了，接下来要断开通信连接，所以告诉服务端“我说完了（FIN）”，此时自身形成等待结束连接的状态。

第二次挥手：服务端知道客户端已经没话说了，服务端此时还有两句心里话要给客户端说，“我知道你说完了（ACK），我再给你说两句，&*……%￥”。

第三次挥手：此时客户端洗耳恭听继续处于等待结束的状态，服务器端也说完了，自身此时处于等待关闭连接的状态，并对告诉客户端，“我说完了，咱们断了吧（FIN）”。

第四次挥手：客户端收知道服务端也说完了，也要告诉服务端一声（ACK），因为连接和断开要双方都按下关闭操作才能断开，客户端同时又为自己定义一个定时器，因为不知道刚才说的这句话能不能准确到达服务端（网络不稳定或者其他因素引起的网络原因），默认时间定为两个通信的最大时间之和，超出这个时间就默认服务器端已经接收到了自己的确认信息，此时客户端就关闭自身连接，服务器端一旦接收到客户端发来的确定通知就立刻关闭服务器端的连接。

到此为止双方整个通信过程就此终结。这里要声明一下：断开链接不一定就是客户端，谁都可以先发起断开指令，另外客户端和服务端是没有固定标准的，谁先发起请求谁就是客户端。


1、TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接

2、TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保证可靠交付

3、TCP面向字节流，实际上是TCP把数据看成一连串无结构的字节流;UDP是面向报文的

UDP没有拥塞控制，因此网络出现拥塞不会使源主机的发送速率降低（对实时应用很有用，如IP电话，实时视频会议等）

4、每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信




<1>    应用层
        OSI参考模型中最靠近用户的一层，是为计算机用户提供应用接口，也为用户直接提供各种网络服务。我们常见应用层的网络服务协议有：HTTP，HTTPS，FTP，POP3、SMTP等。
	
<2>    表示层
        表示层提供各种用于应用层数据的编码和转换功能,确保一个系统的应用层发送的数据能被另一个系统的应用层识别。如果必要，该层可提供一种标准表示形式，用于将计算机内部的多种数据格式转换成通信中采用的标准表示形式。数据压缩和加密也是表示层可提供的转换功能之一。
       
<3>    会话层
        会话层就是负责建立、管理和终止表示层实体之间的通信会话。该层的通信由不同设备中的应用程序之间的服务请求和响应组成。      

<4>   传输层
        传输层建立了主机端到端的链接，传输层的作用是为上层协议提供端到端的可靠和透明的数据传输服务，包括处理差错控制和流量控制等问题。该层向高层屏蔽了下层数据通信的细节，使高层用户看到的只是在两个传输实体间的一条主机到主机的、可由用户控制和设定的、可靠的数据通路。我们通常说的，TCP UDP就是在这一层。端口号既是这里的“端”。
       
<5>   网络层
       本层通过IP寻址来建立两个节点之间的连接，为源端的运输层送来的分组，选择合适的路由和交换节点，正确无误地按照地址传送给目的端的运输层。就是通常说的IP层。这一层就是我们经常说的IP协议层。IP协议是Internet的基础。
       
<6>   数据链路层 
        将比特组合成字节,再将字节组合成帧,使用链路层地址 (以太网使用MAC地址)来访问介质,并进行差错检测。

<7>  物理层     
        实际最终信号的传输是通过物理层实现的。通过物理介质传输比特流。规定了电平、速度和电缆针脚。常用设备有（各种物理设备）集线器、中继器、调制解调器、网线、双绞线、同轴电缆。这些都是物理层的传输介质。
        


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
	
	
	
    /*
     * 
     * 把输入的数组分成两份，要是输入的数组长度是1就不用分了，随后递归调用merge(merge_sort(left_arr), merge_sort(right_arr));
     * 这样的递归调用会使每次传入merge函数的两个arr各自都是排好序的。
     * 
     */
	public static int[] merge_sort(int[] arr){
		if (arr.length<2) {
				return arr;
			}
		int middle = arr.length / 2;
		int left_arr[] = Arrays.copyOfRange(arr, 0, middle);
		int right_arr[] = Arrays.copyOfRange(arr, middle, arr.length);

		return merge(merge_sort(left_arr), merge_sort(right_arr));
    }
    
    /*
     * 
     * merge 函数的作用是把两个已经各自排好序arr排序后合在一起，所以先声明一个result数组用于 返回，长度是两个arr长度的和，
     * idx指针指向result的第一个元素，随后一起逐元素遍历两个arr数组，遍历的方式是对比两个数组的第一个元素，取最小元素的出栈，该放入result的元素，
     * 出栈的方式使用Arrays.copyOfRange(arr, 1, arr.length)的方式，相当于移除了刚才出栈的元素，方便下次判断。倘若两个arr中任一一个元素全部
     * 出栈了，那就把另一个arr的值全部放到result剩余空间里就好了。放的方式依旧是Arrays.copyOfRange(arr, 1, arr.length)，从左到右一个个放。
     * 
     */
	public static int[] merge(int[] left_arr, int[] right_arr) {
		int[] result = new int[left_arr.length + right_arr.length];
		int idx = 0;
		while (left_arr.length > 0 && right_arr.length > 0) {
			if(left_arr[0] > right_arr[0]) {
				result[idx++] = right_arr[0];
				right_arr = Arrays.copyOfRange(right_arr, 1, right_arr.length);
			}else {
				result[idx++] = left_arr[0];
				left_arr = Arrays.copyOfRange(left_arr, 1, left_arr.length);
			}
		}
		
		while(left_arr.length > 0) {
			result[idx++] = left_arr[0];
			left_arr = Arrays.copyOfRange(left_arr, 1, left_arr.length);
		}
		while(right_arr.length > 0) {
			result[idx++] = right_arr[0];
			right_arr = Arrays.copyOfRange(right_arr, 1, right_arr.length);
		}
		return result;
	}	
		
	
	public static int[] quick_sort(int[] arr, int left, int right) {
		if (right <= left) {	
	//    		System.out.print(left);
	//    		System.out.print("  ");
	//    		System.out.print(right);
	//    		System.out.print("  ");
	//    		System.out.println(Arrays.toString(arr));
				return arr;
			}

		int i =  left;
		int j = right + 1;	// j = right + 1的原因：要执行++i，--j的操作, i++会先返回i,然后i+1。 ++i会直接返回i+1
		// 用++i而不是i++的好处就是i先增加或减少，在判断，如果不成立i指向的就是不成立的元素
		// 而i++如果不成立那i指向的是当前位置前一个元素。
		int anchor_value = arr[left];	// 将anchor设为left索引对应的元素
		while(true) {
			while(is_less(arr[++i], anchor_value) && i<right); // i指针从left处右移，找到比anchor大的数，用i指向它。从left右移因为不用判断left，left是anchor。
			while(is_less(anchor_value, arr[--j]) && j>left);  // j指针从right+1处左移，找到比anchor小的数，用j指向它。 从j+1往左移因为使用了--j，得判断right所以对应的数。
			if(i >= j)
				break;
			swap(arr, i, j); // 交换i和j对应的数，把小于anchor的移到左边，大于anchor的移到右边。
			// 如果此时i，j相遇了，该交换的都交换完了，没有需要交换的了，则继续走一下循环，i不用管，j左移一定指向了一个比anchor小的数，
			// 并且因为此时i一定是大于等于j的，于是break推出循环。执行swap(arr, left, j);则换了后anchor左边的元素一定给都小于anchor，右边的元素都大于anchor。
		}
			swap(arr, left, j);

		int sep_idx  = j; // j当前指向的就是刚刚的anchor，于是从anchor作为界限点把数组分成两份，循环操作。
		quick_sort(arr, left, sep_idx-1);
		quick_sort(arr, sep_idx+1, right);
		return arr;
    	
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
