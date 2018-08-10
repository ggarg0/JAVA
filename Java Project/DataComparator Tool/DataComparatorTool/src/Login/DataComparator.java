package Login;

import javax.swing.BorderFactory;

import javax.swing.*;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import QueryDataBase.QueryDataBaseDB;

public class DataComparator extends JPanel implements ActionListener {

	static JFrame frame = new JFrame("Data Comparator Tool");

	static String Schema;
	static String database;
	static String password;
	static String OracleServer;
	static String InputFileText;
	static String QueryText;
	static String OutputFileText;
	static String OutputFileMissText;
	static String QueryType = "";
	static boolean SelectQueryType;
	static boolean UpdateQueryType;
	static boolean DeleteQueryType;
	static JFileChooser chooser;
	static String choosertitle;
	static JCheckBox inputfile = new JCheckBox("Input file ");
	static JCheckBox outputfile = new JCheckBox("Output file ");
	static JCheckBox outputmissfile = new JCheckBox("Output miss file ");

	static JTextField InputFileTextField = new JTextField(30);

	static JTextArea QueryTextField = new JTextArea();
	JScrollPane scrollPaneResponse = new JScrollPane(QueryTextField);

	static JTextField OutputFileTextField = new JTextField(30);
	static JTextField OutputFileMissTextField = new JTextField(30);

	public JPanel addComponentsToMainView(String[] accesslevel) {

		JPanel top = new JPanel();
		JPanel file = new JPanel();
		JPanel bottom = new JPanel();
		JPanel MainLoginView = new JPanel();
		JPanel MainLoginViewChange = new JPanel();
		JPanel Buttonadd = new JPanel();
		JPanel TopPaneladd = new JPanel();
		JPanel InputButton = new JPanel();
		JPanel TextField = new JPanel();
		TopPaneladd = addComponentsToTopPanel();
		Buttonadd = addComponentsToButtonadd();

		InputButton = addComponentsToFileButtonadd();

		TextField = addComponentTextFields();

		String QueryString = "<html><p>Query should contain variable word "
				+ "<BR> Example : select * from emp where emp_id = variable and sal = max(sal) </p></html>";

		JLabel QueryLabel = new JLabel(QueryString, SwingConstants.LEFT);

		/*
		 * InputFileTextField.setText("D:\\DataComparator\\Book2.xls");
		 * QueryTextField
		 * .setText("update item set item_id=01738821 where item_sys_nbr = variable"
		 * ); OutputFileTextField.setText("D:\\DataComparator\\Book12.xls");
		 * OutputFileMissTextField.setText("D:\\DataComparator\\Book22.xls");
		 */

		MainLoginViewChange.setLayout(new GridLayout(1, 1, 10, 10));

		MainLoginViewChange.setPreferredSize(new Dimension(200, 125));
		MainLoginViewChange
				.setBorder(BorderFactory.createTitledBorder("Query"));
		QueryTextField.setLineWrap(true);
		QueryTextField.setWrapStyleWord(true);

		scrollPaneResponse
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneResponse.setPreferredSize(new Dimension(15, 30));

		// MainLoginViewChange.add(QueryLabel);
		MainLoginViewChange.add(scrollPaneResponse);

		MainLoginView.setBorder(BorderFactory
				.createTitledBorder("Data Comparator Tool"));
		top.setLayout(new BorderLayout(5, 5));
		bottom.setLayout(new BorderLayout(5, 5));
		file.setLayout(new BorderLayout(5, 5));
		
		file.add(InputButton, BorderLayout.EAST);
		file.add(TextField, BorderLayout.WEST);
		MainLoginView.setLayout(new BorderLayout(5, 5));
		top.add(TopPaneladd, BorderLayout.PAGE_START);
		top.add(file, BorderLayout.PAGE_END);
		//bottom.add(file, BorderLayout.NORTH);
		bottom.add(MainLoginViewChange, BorderLayout.PAGE_START);
		bottom.add(Buttonadd, BorderLayout.PAGE_END);
		MainLoginView.add(top, BorderLayout.PAGE_START);
		MainLoginView.add(bottom, BorderLayout.PAGE_END);
		return MainLoginView;
	}

	// Adding components to Buttonadd Panel

	public JPanel addComponentsToButtonadd() {

		JPanel Buttonadd = new JPanel();
		JButton Submit = new JButton("Submit");
		Submit.setDisplayedMnemonicIndex(0);

		JButton Close = new JButton("Close");
		Close.setDisplayedMnemonicIndex(0);

		ActionListener CloseButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				  
				frame.dispose();

			}
		};

		Close.addActionListener(CloseButtonListener);

		ActionListener SubmitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae19) {

				try {
					InputFileText = InputFileTextField.getText().trim();
					QueryText = QueryTextField.getText().trim();
					OutputFileText = OutputFileTextField.getText().trim();
					OutputFileMissText = OutputFileMissTextField.getText()
							.trim();

					UpdateQueryType = QueryText.toLowerCase()
							.contains("update");
					SelectQueryType = QueryText.toLowerCase()
							.contains("select");
					DeleteQueryType = QueryText.toLowerCase()
							.contains("delete");
					System.out.println("UPdateQueryType : " + UpdateQueryType
							+ " & " + InputFileText);
					System.out.println("SelectQueryType : " + SelectQueryType
							+ " & " + OutputFileText);
					System.out.println("DeleteQueryType : " + DeleteQueryType
							+ " & " + OutputFileMissText);

					boolean InputFilePathValid = DataComparatorValidation
							.InputFileTextValidations(InputFileText,
									OutputFileText, OutputFileMissText);
					boolean OutputFilePathValid = DataComparatorValidation
							.OutputFileTextValidations(OutputFileText,
									OutputFileMissText);
					boolean OutputFileMissValid = DataComparatorValidation
							.OutputFileMissTextValidations(OutputFileMissText);
					boolean QueryValid = DataComparatorValidation
							.QueryTextValidations(QueryText);
					if (InputFilePathValid == true && QueryValid == true
							&& OutputFilePathValid == true
							&& OutputFileMissValid == true) {

						String TransactionFlag = "";
						QueryDataBaseDB db = new QueryDataBaseDB();
						if (QueryType != null
								&& QueryType
										.equalsIgnoreCase("Select Transaction")) {

							if (UpdateQueryType == true
									|| DeleteQueryType == true) {
								JOptionPane.showMessageDialog(null,
										"Please enter select query only",
										"Error Message", 1);
							} else {
								TransactionFlag = "select";
								db.QueryData(Schema, password, database,
										OracleServer, QueryText, InputFileText,
										OutputFileText, OutputFileMissText,
										TransactionFlag);
							}

						} else if (QueryType != null
								&& QueryType
										.equalsIgnoreCase("Update Transaction")) {
							if (SelectQueryType == true
									|| DeleteQueryType == true) {
								JOptionPane.showMessageDialog(null,
										"Please enter update query only",
										"Error Message", 1);

							} else {
								TransactionFlag = "update";
								db.QueryData(Schema, password, database,
										OracleServer, QueryText, InputFileText,
										OutputFileText, OutputFileMissText,
										TransactionFlag);

							}

						} else if (QueryType != null
								&& QueryType
										.equalsIgnoreCase("Delete Transaction")) {
							if (SelectQueryType == true
									|| UpdateQueryType == true) {
								JOptionPane.showMessageDialog(null,
										"Please enter delete query only",
										"Error Message", 1);

							} else {
								TransactionFlag = "delete";
								db.QueryData(Schema, password, database,
										OracleServer, QueryText, InputFileText,
										OutputFileText, OutputFileMissText,
										TransactionFlag);

							}

						} else {
							JOptionPane.showMessageDialog(null,
									"Select transaction type", "Error Message",
									1);
						}

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Exception occured : "
							+ e, "Error Message", 1);
				}

			}
		};

		Submit.addActionListener(SubmitButtonListener);
		Buttonadd.setPreferredSize(new Dimension(100, 50));
		Buttonadd.add(Submit);
		Buttonadd.add(Close);
		return Buttonadd;
	}

	
	public JPanel addComponentsToFileButtonadd() {

		JPanel FileButtonadd = new JPanel();
		JButton Input = new JButton("Open");
		JButton Output = new JButton("Open");
		JButton OutputMiss = new JButton("Open");
		JLabel BlankLabel = new JLabel();
		
		ActionListener inputfileListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle(choosertitle);
					chooser
							.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {

						InputFileTextField.setText(chooser.getSelectedFile()
								.toString().trim());
					
				} else {
					InputFileTextField.setText("");
				}

			}
		};
		Input.addActionListener(inputfileListener);
		
		
		ActionListener OutputfileListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle(choosertitle);
					chooser
							.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {

						OutputFileTextField.setText(chooser.getSelectedFile()
								.toString().trim());
					
				} else {
					OutputFileTextField.setText("");
				}

			}
		};
		Output.addActionListener(OutputfileListener);
		
		ActionListener OutputMissfileListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle(choosertitle);
					chooser
							.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {

						OutputFileMissTextField.setText(chooser.getSelectedFile()
								.toString().trim());
					
				} else {
					OutputFileMissTextField.setText("");
				}

			}
		};
		OutputMiss.addActionListener(OutputMissfileListener);

	

		/*ActionListener SubmitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae19) {
			}
		};

		Submit.addActionListener(SubmitButtonListener);*/
		FileButtonadd.setPreferredSize(new Dimension(75, 150));
		FileButtonadd.setLayout(new GridLayout(4, 1, 10, 10));
		FileButtonadd.add(Input);
		FileButtonadd.add(Output);
		FileButtonadd.add(OutputMiss);
		FileButtonadd.add(BlankLabel);
		
		return FileButtonadd;
	}

	
	
	public JPanel addComponentsToTopPanel() {

		JPanel TopPaneladd = new JPanel();

		String Blank = "";
		String SelectCombo = "Select Transaction";
		String UpdateCombo = "Update Transaction";
		String DeleteCombo = "Delete Transaction";
		String comboBoxItems[] = { Blank, SelectCombo, UpdateCombo, DeleteCombo };
		final JComboBox cbTransactionSelected = new JComboBox(comboBoxItems);
		JLabel SchemaLabel = new JLabel("Schema : " + Schema.toUpperCase());
		JLabel DatabaseLabel = new JLabel("Database : "
				+ database.toUpperCase());

		JLabel BlankLabel = new JLabel();
		JLabel BlankLabel1 = new JLabel();
		JLabel BlankLabel2 = new JLabel();
		JLabel BlankLabel3 = new JLabel();


		ItemListener countrySelected = new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				QueryType = cbTransactionSelected.getSelectedItem().toString()
						.trim();
				System.out.println("QueryType in item change: " + QueryType);

			}
		};

		cbTransactionSelected.addItemListener(countrySelected);

		JLabel SelectTransactionLabel = new JLabel("Select transaction type : ");
		TopPaneladd.setPreferredSize(new Dimension(100, 150));
		TopPaneladd.setLayout(new GridLayout(4, 2, 10, 10));

		TopPaneladd.add(SchemaLabel);
		TopPaneladd.add(DatabaseLabel);

		TopPaneladd.add(BlankLabel);
		TopPaneladd.add(BlankLabel1);

		TopPaneladd.add(SelectTransactionLabel);
		TopPaneladd.add(cbTransactionSelected);
		
		TopPaneladd.add(BlankLabel2);
		TopPaneladd.add(BlankLabel3);


		return TopPaneladd;
	}

	public static JPanel addComponentTextFields() {

		JPanel TextFields = new JPanel();
		String InputFileString = "<html><p>Input file path : "
				+ "<BR>(Maximum 30000 records per excel file)</p></html>";
		String OutputFileString = "<html><p>Output file path : "
				+ "<BR>(Contains Data found in input excel file  )<nbsp;><nbsp;>   </p></html>";
		String OutputMissFileString = "<html><p>Output miss file path : "
				+ "<BR>(Contains Data not found in input excel file)</p></html>";

		JLabel InputFileLabel = new JLabel(InputFileString, SwingConstants.LEFT);
		JLabel BlankLabel = new JLabel();
		JLabel BlankLabel1 = new JLabel();
		JLabel OutputFileLabel = new JLabel(OutputFileString,
				SwingConstants.LEFT);
		JLabel OutputFileMissLabel = new JLabel(OutputMissFileString,
				SwingConstants.LEFT);

		TextFields.setPreferredSize(new Dimension(750, 150));
		TextFields.setLayout(new GridLayout(4, 2, 10, 10));
		TextFields.add(InputFileLabel);
		TextFields.add(InputFileTextField);

		TextFields.add(OutputFileLabel);
		TextFields.add(OutputFileTextField);

		TextFields.add(OutputFileMissLabel);
		TextFields.add(OutputFileMissTextField);
		TextFields.add(BlankLabel);
		TextFields.add(BlankLabel1);

		return TextFields;
	}

	// Admin page

	public void actionPerformed(ActionEvent ae) {

	}

	public static void main(String[] args) {
		String[] accessDetails = new String[3];
		try {
			LoginPanel login = new LoginPanel();
			int response = JOptionPane.showConfirmDialog(null, login,
					"Data Comparator Tool", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (response == JOptionPane.OK_OPTION) {
				Schema = login.getName();
				password = login.getPassword();
				database = login.getdatabase();
				OracleServer = login.getOracleServer();

				boolean schemaValid = DataComparatorValidation
						.SchemaValidations(Schema);
				boolean passwordValid = DataComparatorValidation
						.PasswordValidations(password);
				boolean databaseValid = DataComparatorValidation
						.DatabaseValidations(database);
				boolean OracleServerValid = DataComparatorValidation
						.OracleServerValidations(OracleServer);

				if (schemaValid == true && passwordValid == true
						&& databaseValid == true && OracleServerValid == true) {

					DataComparator obj = new DataComparator();

					JPanel MainView = new JPanel();

					MainView = obj.addComponentsToMainView(accessDetails);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					frame.add(MainView);
					frame.setVisible(true);
					frame.setSize(850, 550);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);

				}

				else {

					JOptionPane.showMessageDialog(null,
							"Login Failed. \n(Please Login again)",
							"Error Message", 1);

				}
			}
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "Exception occured : " + e,
					"Error Message", 1);
		}
	}
}
