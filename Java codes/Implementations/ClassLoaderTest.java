public class ClassLoaderTest {

	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			// System.out.println("ClassLoaderTest.getClass().getClassLoader() : " +
			// ClassLoaderTest.class.getClassLoader());
			// System.out.println(Class.forName("ClassLoaderTest"));
			// System.out.println(Class.forName("ClassLoaderTest"));
			// trying to explicitly load this class again using Extension class loader
			System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
			System.out.println(
					Class.forName("ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent()));
		

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
