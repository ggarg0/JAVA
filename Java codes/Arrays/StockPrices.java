package Arrays;

public class StockPrices {

	public static void main(String[] args) {
		int[] stockNums = { 7, 1, 5, 3, 6, 9 };

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

		System.out.println(buy + " and " + sell);
	}
}
