
interface A {
	default String show() {
		return "Default method A";
	}
}

interface B {
	default String show() {
		return "Default method B";
	}
}

interface C extends A,B {
	default String show() {
		return "Default method C";
	}
}
public class LambdaFunctionalInterfaceDemo implements  A, C{
	public static void main(String[] args) {
		B obj = new LambdaFunctionalInterfaceDemo();
		System.out.println(obj.show());
	}

	
}