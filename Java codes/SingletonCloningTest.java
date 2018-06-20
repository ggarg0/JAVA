 class Singleton  implements Cloneable{
          private Singleton() {}

          /* private Singleton() {
		          if (instance != null) {
		              throw new InstantiationError("Error creating class");
		          }
    		}*/

          private static Singleton INSTANCE;
          public static Singleton getInstance() {
		  if(INSTANCE==null){
				 INSTANCE = new Singleton();
			 }
			 return INSTANCE;
          }
         public Object clone() throws CloneNotSupportedException {
			 	//return super.clone();
		  	 throw new CloneNotSupportedException();
         }
 }
 public class SingletonCloningTest {
         public static void main(String[] args) throws Exception{
			 try{
                 Singleton obj = Singleton.getInstance();
                 System.out.println("Singleton Instance : "+obj);

                 Singleton obj1 = (Singleton) obj.clone();
                 System.out.println("Singleton clone : "+obj1);
			 }catch(Exception e)
			 {
				  System.out.println("Exception clone : "+e.toString());
			 }

         }
 }