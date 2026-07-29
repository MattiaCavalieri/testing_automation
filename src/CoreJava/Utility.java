package CoreJava;

public class Utility {

	int a;

	public Utility(int a) {
		this.a = a;
	}

	/**
	 * Increments value of a by 1
	 * 
	 * @return value of a
	 */
	public int increment() {
		a = a + 1;
		return a;
	}

	/**
	 * Decrement value of a by 1
	 * 
	 * @return value of a
	 */
	public int decrement() {
		a = a - 1;
		return a;
	}

}
