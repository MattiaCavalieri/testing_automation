package testing_automation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// Array
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			} else {
				System.out.println(arr[i] + " non e' multiplo di 2");
			}
		}

		// ArrayList

		// ArrayList di numeri interi
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		numeri.add(5);
		numeri.add(10);
		numeri.add(1203);

		// ArrayList di stringhe
		ArrayList<String> nomi = new ArrayList<String>();
		nomi.add("Mattia");
		nomi.add("Delfina");
		nomi.add("Micol");

		System.out.println();

		// estrarre un elemento da un ArrayList
		int secondo = numeri.get(2);
		System.out.println(secondo);

		String mattia = nomi.get(0);
		System.out.println(mattia);

		System.out.println();

		// iterare sugli ArrayList
		for (int numero : numeri) {
			System.out.println(numero);
		}
		System.out.println();
		
		for (String nome : nomi) {
			System.out.println(nome);
		}
		
		System.out.println();
		
		// verificare se un elemento è presente in un ArrayList
		boolean check = numeri.contains(5);
		boolean checkNome = nomi.contains("Mattia");
		
		System.out.println(check);
		System.out.println(checkNome);
		
		System.out.println();
		
		// convertire un Array in un ArrayList
		String[] names = { "Mattia", "Micol", "Delfina" };
		List<String> nameArrayList = Arrays.asList(names);
		System.out.println(nameArrayList);

	}

}
