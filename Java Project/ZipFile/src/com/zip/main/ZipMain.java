package com.zip.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.zip.main.ZipFile;

public class ZipMain {
	static JFileChooser chooser;
	static JFrame frame = new JFrame("Compress and Copy Files");
	static JTextField SourceText = new JTextField(50);
	static JTextField DestinationText = new JTextField(50);
	static JTextArea LogText = new JTextArea();
	JScrollPane scrollPaneResponse = new JScrollPane(LogText);
	static String SourceString = "";
	static String DestinationString = "";
	
	public static JPanel addComponentsToButtonadd() {

		JPanel Buttonadd = new JPanel();
		JButton Submit = new JButton("Zip It");
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
				
				//LogText.setText("");
				SourceString=SourceText.getText().toString().trim();
				DestinationString=DestinationText.getText().toString().trim();
				ZipFile obj = new ZipFile();
				obj.ZipIt(SourceString, DestinationString);
				
			}
		};

		Submit.addActionListener(SubmitButtonListener);
		Buttonadd.add(Submit);
		Buttonadd.add(Close);
		Buttonadd.setBorder(BorderFactory.createTitledBorder(""));
		return Buttonadd;
	}
	
	public static JPanel addComponentsToLogBox() {

		JPanel Result = new JPanel();
		Result.setLayout(new GridLayout(1, 2, 10, 10));
		Result.add(LogText);
			
		Result.setBorder(BorderFactory.createTitledBorder("OutPut"));
	//	Result.setSize(700, 200);
		return Result;
	}

	public static JPanel addComponentsToMainView() {

		JPanel MainView = new JPanel();
		JPanel Left = new JPanel();
		JPanel Right = new JPanel();

		JLabel Source = new JLabel("Select Folder/Files : ",
				SwingConstants.CENTER);
		Source.setVerticalTextPosition(AbstractButton.BOTTOM);
		Source.setHorizontalTextPosition(AbstractButton.CENTER);

		JLabel Destination = new JLabel("Destination Path : ",
				SwingConstants.CENTER);
		Destination.setVerticalTextPosition(AbstractButton.BOTTOM);
		Destination.setHorizontalTextPosition(AbstractButton.CENTER);

		JButton SelectSource = new JButton("Select");
		JButton SelectDestination = new JButton("Select");

		JLabel BlankLabel = new JLabel();
		JLabel BlankLabel1 = new JLabel();
		JLabel BlankLabel2 = new JLabel();
		JLabel BlankLabel3 = new JLabel();
		JLabel BlankLabel4 = new JLabel();
		JLabel BlankLabel5 = new JLabel();
		JLabel BlankLabel6 = new JLabel();
		JLabel BlankLabel7 = new JLabel();
		JLabel BlankLabel8 = new JLabel();
		
		ActionListener SelectSourceListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String Source = "";
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Select Folder/Files");
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {

						SourceText.setText(chooser.getSelectedFile()
								.toString().trim());
						
					
				} else {
					SourceText.setText("");
				}

			}
		};
		SelectSource.addActionListener(SelectSourceListener);
		
		ActionListener SelectDestinationListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
					chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Destination Path");
					chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					chooser.setAcceptAllFileFilterUsed(false);

					if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {

						DestinationText.setText(chooser.getSelectedFile()
								.toString().trim());
					
				} else {
					DestinationText.setText("");
				}

			}
		};
		SelectDestination.addActionListener(SelectDestinationListener);

		Left.setLayout(new GridLayout(5, 2, 10, 10));
		Left.add(BlankLabel);
		Left.add(BlankLabel1);
		Left.add(Source);
		Left.add(SourceText);
		Left.add(BlankLabel3);
		Left.add(BlankLabel4);
		Left.add(Destination);
		Left.add(DestinationText);
		Left.add(BlankLabel6);
		Left.add(BlankLabel7);

		Right.setLayout(new GridLayout(5, 3, 10, 10));
		Right.add(BlankLabel2);
		Right.add(SelectSource);
		Right.add(BlankLabel5);
		Right.add(SelectDestination);
		Right.add(BlankLabel8);

		MainView.setLayout(new BorderLayout(5, 5));
		MainView.setBorder(BorderFactory.createTitledBorder("Zip It"));
		MainView.add(Left, BorderLayout.CENTER);
		MainView.add(Right, BorderLayout.EAST);
		return MainView;
	}

	public static void main(String[] args) {

		JPanel View = new JPanel();
		JPanel Main = new JPanel();
		JPanel MainView = new JPanel();
		JPanel Button = new JPanel();
		JPanel Log = new JPanel();

		MainView = addComponentsToMainView();
		Button = addComponentsToButtonadd();
		Log = addComponentsToLogBox();
	
		View.setLayout(new BorderLayout(5, 5));
		View.add(MainView, BorderLayout.NORTH);
		View.add(Button, BorderLayout.CENTER);
	
		Main.setLayout(new BorderLayout(5, 5));
		Main.add(View, BorderLayout.NORTH);
		Main.add(Log, BorderLayout.CENTER);
		Main.setBorder(BorderFactory.createTitledBorder(""));
		frame.add(Main);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

	}

}
