package DesignPatterns.Prototype;

public class PrototypeFactory {
	  private static java.util.Map<String , PrototypeCapable> prototypes = new java.util.HashMap<String , PrototypeCapable>();
	  public static final String MOVIE = "Movie";
	  public static final String SHOW = "Show";
	  
	  static
	  {
	    prototypes.put(MOVIE, new Movie());
	    prototypes.put(SHOW, new Show());
	  }
	 
	  public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
	    return ((PrototypeCapable) prototypes.get(s)).clone();
	  }
}
