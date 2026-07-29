package CoreJava;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass {

	@Test
	public void runTest() {
		Utility inc = new Utility(3);
		doThis();
		System.out.println(inc.increment());
	}

}
