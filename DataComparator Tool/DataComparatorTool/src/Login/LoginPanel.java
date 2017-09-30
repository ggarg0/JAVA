package Login;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField userId = new JTextField(10);
	   private JPasswordField password = new JPasswordField(15);
	   private JTextField database = new JTextField(15);
	   private JTextField server = new JTextField(15);

	 
	   
	   public LoginPanel() {
		  setPreferredSize(new Dimension(300, 200));
	      setLayout(new GridLayout(6, 2, 5, 5)); 
	      add(new JLabel());
	      add(new JLabel());
	      add(new JLabel("Schema : "));
	      add(userId);
	      add(new JLabel("Password : "));
	      add(password);
	      add(new JLabel("Database : "));
	      add(database);
	      add(new JLabel("Oracle Server : "));
	      add(server);
	      add(new JLabel());
	      add(new JLabel());
	   }

	   public String getName() {
	      return userId.getText();
	   }

	   public String getPassword() {
	      return new String(password.getPassword());
	   }
	   public String getdatabase() {
		      return new String(database.getText());
		   }
	   public String getOracleServer() {
		      return new String(server.getText());
		   }
}
