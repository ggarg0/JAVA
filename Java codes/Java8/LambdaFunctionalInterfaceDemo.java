
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
	default String show1() {
			return "Default method C1";
	}

}
public class LambdaFunctionalInterfaceDemo implements C{
	public static void main(String[] args) {
		C obj = new LambdaFunctionalInterfaceDemo();
		System.out.println(obj.show());
		System.out.println(obj.show1());
	}
}