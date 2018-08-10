import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropFile {
  public static void main(String[] args) {
	InputStream input = null;

	Properties props = new Properties();
	try {

		// load a properties file
		input = new FileInputStream("config.properties");
		props.load(input);

		// get the property value and print it out
		System.out.println("Details from properties file");
		System.out.println("----------------------------");
		System.out.println(props.getProperty("db.schema"));
		System.out.println(props.getProperty("db.user"));
		System.out.println(props.getProperty("db.password"));

  		//Load XML file
        input = new FileInputStream("config.xml");
		props.loadFromXML(input);

		// get the property value and print it out
		System.out.println("Details from xml file");
		System.out.println("---------------------");
		System.out.println(props.getProperty("db.schema"));
		System.out.println(props.getProperty("db.user"));
		System.out.println(props.getProperty("db.password"));

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

  }
}