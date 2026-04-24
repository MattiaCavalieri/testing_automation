package testing_automation;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			} else {
				System.out.println(arr[i] + " non e' multiplo di 2");
			}
		}

	}

}
