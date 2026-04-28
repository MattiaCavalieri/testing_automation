package testing_automation;

public class CodeJavaBrsuhUp3 {

	public static void main(String[] args) {

		// Stringhe
		// le stringhe sono Oggetti in Java
		// ci sono 2 modi per definire le stringhe in Java:

		String stringa = "This is a string";
		String stringa1 = "This is a string also";

		String stringa2 = new String("Welcome to Selenium");
		String stringa3 = new String("Welcome to Selenium");

		// spezzare una stringa usando lo spazio come separatore
		String[] spezzata = stringa.split(" ");
		System.out.println(spezzata[0]);
		System.out.println(spezzata[1]);
		System.out.println(spezzata[2]);
		System.out.println(spezzata[3]);

		System.out.println();

		String[] spezzata1 = stringa.split("a");
		System.out.println(spezzata1[0]);
		System.out.println(spezzata1[1].trim()); // rimuove gli spazi all'inizio della stringa

		System.out.println();

		// iterare sulle stringhe
		for (int i = 0; i < stringa.length(); i++) {
			System.out.println(stringa.charAt(i));
		}

		System.out.println();

		for (int i = stringa2.length() - 1; i >= 0; i--) {
			System.out.println(stringa2.charAt(i));
		}
	}

}
