import java.util.Scanner;

public class Unit8HW1{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//make your own 2D test array of integers (or whatever)
		int[][] arr = {
				{1,2,3},
				{3,4,5},
				{5,6,7}
		};
		int columnNumber;
		while (true) {
			columnNumber = beaUtils.askForThing("Enter a column number to go to: ",Scanner::nextInt,scanner);
			--columnNumber;
			if (columnNumber < arr[0].length) {
				break;
			}
			System.out.println("Enter a number between 1 and " + arr.length);
		}
		//print the column number they asked for with each element on a new line
		columnPrinter(columnNumber,arr);

	}
	// arr
	private static void columnPrinter(int column,int[][] arr){
		for (int[] intArr : arr) {
			System.out.println(intArr[column]);
		}
	}
}
