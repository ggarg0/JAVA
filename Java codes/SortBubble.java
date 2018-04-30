public class SortBubble {
	public static void main(String[] args) {
		int[] array = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int n = array.length;
   		int temp = 0;
		for(int i=0; i < n-1; i++){
			for(int j=1; j < (n-i); j++){
			    if(array[j-1] > array[j]){
			        //swap elements
		            temp = array[j-1];
		            array[j-1] = array[j];
		            array[j] = temp;
		        }
			}
         }
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
}