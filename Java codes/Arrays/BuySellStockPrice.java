package Arrays;

public class BuySellStockPrice {

	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int price : prices) {
			min = Math.min(min, price);
			max = Math.max(price - min, max);
		}
		return max;
	}

	public static void maxProfitDisplay(int[] stockNums) {
		if (stockNums.length < 2) {
			System.out.println("Invalid stock values");
		} else {
			int buy = stockNums[0];
			int sell = stockNums[1];

			int maxProfit = 0;
			int profit = 0;

			for (int i = 1; i < stockNums.length; i++) {

				profit = stockNums[i] - buy;
				if (profit > maxProfit) {
					maxProfit = profit;
					sell = stockNums[i];
				}

				if (buy > stockNums[i]) {
					buy = stockNums[i];
				}

			}
			System.out.println(sell - maxProfit + " and " + sell);
		}
	}

	public static void main(String[] args) {
		int[] stockNums = { 4, 2, 4, 8, 1 };
		System.out.println(maxProfit(stockNums));
		maxProfitDisplay(stockNums);
	}
}
