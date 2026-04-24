package testing_automation;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {

		int myNum = 5;
		String myName = "Mattia Cavalieri Manasse";
		char letterM = 'm';
		float decimal = 0.5f;
		boolean open = true;

		System.out.println(myName);
		System.out.println(myNum);
		System.out.println(letterM);
		System.out.println(decimal);
		System.out.println(open);

		// Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 5;
		arr[3] = 7;
		arr[4] = 9;

		int[] arr2 = { 1, 3, 5, 7, 9 };
		int secondIndex = arr2[2];
		System.out.println(arr2[0]);
		System.out.println(secondIndex);

		// stampare i valori presenti in un array di interi
		// for loop
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		String[] names = { "Mattia", "Micol", "Delfina" };

		// stampare i valori di un array di stringhe-
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// metodo alternativo
		for (String name : names) {
			System.out.println(name);
		}
	}

}
