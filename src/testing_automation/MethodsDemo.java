package testing_automation;

public class MethodsDemo {

	// Metodi

	public void getData() {
		System.out.println("I'm retrieving data!");
	}
	
	public String sayMyName() {
		return "My name is Mattia";
	}

	public static void main(String[] args) {
		MethodsDemo demo = new MethodsDemo();
		demo.getData();
		System.out.println();
		String nome = demo.sayMyName();
		System.out.println(nome);
		
		System.out.println();
		
		System.out.println(MethodsDemo2.getUserData());
	}

}
