package Login;

import javax.swing.JOptionPane;

public class DataComparatorValidation {
	
	
	public static boolean InputFileTextValidations(String inputfile,String OutputFileText,
			String OutputFileMissText) {
		if (inputfile == null) {

			JOptionPane.showMessageDialog(null,
					"Input file path field is mandatory", "Error Message", 1);
			return false;
		} else if (inputfile.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Input file path field is mandatory", "Error Message", 1);
				return false;
			}
			else if (inputfile.trim().equalsIgnoreCase(OutputFileMissText.trim())) {

					JOptionPane.showMessageDialog(null,
							"Input file path can not be same as output File path", "Error Message", 1);
					return false;
				}
				else if (inputfile.trim().equalsIgnoreCase(OutputFileText.trim())) {

						JOptionPane.showMessageDialog(null,
								"Input file path can not be same as output File path", "Error Message", 1);
						return false;
					}
		
		return true;
	}
	
	public static boolean QueryTextValidations(String query) {
		if (query == null) {

			JOptionPane.showMessageDialog(null,
					"Query field is mandatory", "Error Message", 1);
			return false;
		} else if (!query.contains("variable"))
		{
			JOptionPane.showMessageDialog(null,
					"Query field should contain variable keyword", "Error Message", 1);
			return false;
		}
		
		else {
			if (query.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Query field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}

	public static boolean OutputFileTextValidations(String OutputFileText, String OutputFileMissText) {
		if (OutputFileText == null) {

			JOptionPane.showMessageDialog(null,
					"Output file path field is mandatory", "Error Message", 1);
			return false;
		} else if (OutputFileText.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Output file path field is mandatory", "Error Message", 1);
				return false;
			
		}
		else if (OutputFileText.trim().equalsIgnoreCase(OutputFileMissText.trim())) {

			JOptionPane.showMessageDialog(null,
					"Both Output file path can not be same", "Error Message", 1);
			return false;
		}
		return true;
	}
	
	public static boolean OutputFileMissTextValidations(String OutputFileMissText) {
		if (OutputFileMissText == null) {

			JOptionPane.showMessageDialog(null,
					"Output miss file path field is mandatory", "Error Message", 1);
			return false;
		} else {
			if (OutputFileMissText.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Output miss file path field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}
	
	public static boolean SchemaValidations(String schema) {
		if (schema == null) {

			JOptionPane.showMessageDialog(null,
					"Schema field is mandatory", "Error Message", 1);
			return false;
		} else {
			if (schema.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Schema field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}
	
	public static boolean PasswordValidations(String password) {
		if (password == null) {

			JOptionPane.showMessageDialog(null,
					"Password field is mandatory", "Error Message", 1);
			return false;
		} else {
			if (password.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Password field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}
	
	public static boolean DatabaseValidations(String database) {
		if (database == null) {

			JOptionPane.showMessageDialog(null,
					"Database field is mandatory", "Error Message", 1);
			return false;
		} else {
			if (database.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Database field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}
	
	public static boolean OracleServerValidations(String server) {
		if (server == null) {

			JOptionPane.showMessageDialog(null,
					"Oracle server field is mandatory", "Error Message", 1);
			return false;
		} else {
			if (server.trim().length() == 0) {

				JOptionPane.showMessageDialog(null,
						"Oracle server field is mandatory", "Error Message", 1);
				return false;
			}
		}
		return true;
	}
	
}
