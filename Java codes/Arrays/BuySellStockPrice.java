package Arrays;

public class BuySellStockPrice {

	public static void main(String[] args) {
		int[] stockNums = { 12, 5, 15, 2, 10, 40 };

		if (stockNums.length < 2) {
			System.out.println("Invalid stock values");
		} else {
			int buy = stockNums[0];
			int sell = stockNums[1];

			int maxProfit = sell - buy;
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
}
