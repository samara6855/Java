public class ArraySum{

	public static void main(String[] args) {


		int[][] myFirst2DArray = {
				{ 3, 5, 1, 9 },
				{ 10, 15, 3, 0  },
				{ 1, 11, 31, 90 },
				{ 2, 51, 1, 9 }
		};
		int sum=0;

		for (int row = 0; row < myFirst2DArray.length; row++) {

			for (int column = 0; column < myFirst2DArray.length; column++) {
				sum +=myFirst2DArray[row][column]; //Adding elements from array
			}

			System.out.println(sum);
		}
	}
}
