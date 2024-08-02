package Arrays.SlidingWindow;

import java.util.Arrays;

class Tuple<X, Y> {
	public X x;
	public Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}
}

public class BuySellStockPrices {
	public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockNums) {

		if (stockNums == null || stockNums.length < 2) {
			return null;
		}

		int buy = stockNums[0];
		int sell = stockNums[1];

		int global_profit = sell - buy;
		int current_profit = Integer.MIN_VALUE;

		for (int i = 1; i < stockNums.length; i++) {

			current_profit = stockNums[i] - buy;
			if (current_profit > global_profit) {
				global_profit = current_profit;
				sell = stockNums[i];
			}

			if (buy > stockNums[i]) {
				buy = stockNums[i];
			}
		}

		Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(sell - global_profit, sell);
		return result;
	}

	public static void main(String[] args) {

		int[] stockNums = {8, 6, 5, 4, 3, 2, 1};
		System.out.println("Stocks: " + Arrays.toString(stockNums));
		
		Tuple<Integer, Integer> result = findBuySellStockPrices(stockNums);	
		
		if (result != null) {
			System.out.println("Buy Price: " + result.x + ", Sell Price: " + result.y);
		} else {
			System.out.println("Buy Price: null, Sell Price: null");
		}
	}

}
