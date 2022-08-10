package Core;
public class JavaVersionTest
{
  public static void main(String[] args)
  {
    String javaVersion = System.getProperty("java.version");
	System.out.format("Java Version = '%s'", javaVersion);
    if (javaVersion.startsWith("1.7"))
	{
	  System.out.format("Java Version = '%s'", javaVersion);
	}
  }
}