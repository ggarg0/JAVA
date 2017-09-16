import java.io.*;

class Animal implements Runnable{

		private String message; //message to output
		Thread t;

        Animal(String msg)
	        {
		   message = msg;
		   t = new Thread(this, message);

		   t.start();
		}

		public void run() {
		  while (true) {
		     System.out.println(message);
		     try {
			  Thread.sleep(2000);  // sleep for 2 seconds
			 }
		     catch (InterruptedException e) { }

		} //end of while
          } // end of run
} // end of Animal


class MultiThreadDemo_Runnable {   // multithreaded client code

   public static void main(String args[])  {

      //Instantiate a thread named dog
	Animal dog = new Animal("Wuff..Wuff");


      //Instantiate a thread named cow
	Animal cow = new Animal("Moo..Moo");

    } // end of main
  }// end of MultiThreadDemo_Runnable class
