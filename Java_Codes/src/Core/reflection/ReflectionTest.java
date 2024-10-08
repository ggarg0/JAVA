package Core.reflection;

class ReflectionTest {

	void printName(Object obj) {
		Class<? extends Object> c = obj.getClass();
		System.out.println("Message from printName : " + c.getName());
	}

	public static void main(String args[]) {
		try {

			// forName and newInstance example
			Class<? extends Object> c = Class.forName("ReflectionSimple");
			ReflectionSimple s = (ReflectionSimple) c.newInstance();
			s.message();
			System.out.println("1st Message from Main : " + c.getName());

			// getClass example
			ReflectionSimple s1 = new ReflectionSimple();
			ReflectionTest t = new ReflectionTest();
			t.printName(s1);

			Class<? extends Object> c1 = Class.forName("Reflectioninterface");
			System.out.println("isInterface Check Message from Main : " + c1.isInterface());

			Class<? extends Object> c2 = Class.forName("ReflectionSimple");
			System.out.println("isInterface Check Message from Main : " + c2.isInterface());

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}