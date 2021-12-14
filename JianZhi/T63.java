package JianZhi;
import java.lang.Math;
public class T63 {
	public static int maxProfit(int[] prices) { 
        int min_price = Integer.MAX_VALUE;
		int profit = 0;
		for(int price : prices) {
			min_price = Math.min(min_price, price);
			profit = Math.max(price-min_price, profit);
		}
		return profit;
	}
}
