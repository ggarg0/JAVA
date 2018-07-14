package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import AVSServer.AVSServerClass;
import MasterfilesServer.MasterfilesServerClass;
import ETMSServer.ETMSServerClass;


public class ServerRestartToolTabbedPane extends JPanel implements
		ActionListener {
	static JFrame frame = new JFrame("Server Restart Tool");
	public static void main(String args[]) {
		

		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Instructions", Instructionspanel());
		jtp.addTab("Masterfiles Server Restart", MasterfilesServerClass.MSTServerRestartpanel());
		jtp.addTab("ETMS Server Restart", ETMSServerClass.ETMSServerRestartpanel());
		jtp.addTab("AVS Server Restart", AVSServerClass.AVSServerRestartpanel());
		frame.getContentPane().add(jtp, BorderLayout.CENTER);
		frame.add(jtp);
		frame.setVisible(true);
		frame.setSize(850, 650);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	static JPanel Instructionspanel() {
		/*
		 * main sub-pane- title, layout, border and adding of sub components to
		 * the main pane
		 */
		JPanel pane1 = new JPanel();
		JLabel blank = new JLabel("Note : Please contact Masterfilesfl@pepsico.com in case of any issues.");
		
		
		String Title = "<html><h2><u>Server Restart Tool</u></h2></html> ";
				
		
		JLabel TitleLabel = new JLabel(Title,SwingConstants.CENTER);
		
			
		
		TitledBorder borderComponent1Pane1 = new TitledBorder(new LineBorder(
				Color.blue), "The purpose of Restart Tool", TitledBorder.LEFT,
				TitledBorder.BELOW_TOP);
		borderComponent1Pane1.setTitleColor(Color.black);
		//component1Pane1.setBorder(borderComponent1Pane1);
		pane1.setLayout(new BorderLayout(5, 5));

		JTextArea textArea1Pane1 = new JTextArea();
		textArea1Pane1.setText("\nThis tool is aimed to ease "
				+ "the task of restarting "
				+ "all or selected servers in Masterfiles, AVS and ETMS in Non production" +
				" environment.\n\nMasterfiles Server Restart Tab: \n\n1. Select the environment" +
				"\n2. Select the server to be restarted: a) Naming, DRF, TOT servers "
				+ ", b) Acronym servers.\n3. Select the server from the enabled list for " +
				"restarting the servers.\n\nETMS Server Restart Tab: \n\n1. Select the server " +
				"from the list for restarting the servers.\n\nAVS Server Restart Tab: \n\n1." +
				" Select the environment. \n2. Select the server from the enabled list for " +
				"restarting the servers.\n" );
		textArea1Pane1.setPreferredSize(new Dimension(400, 400));
		textArea1Pane1.setLineWrap(true);
		textArea1Pane1.setWrapStyleWord(true);
		textArea1Pane1.setBorder(borderComponent1Pane1);
		textArea1Pane1.setEditable(false);
		
		pane1.add(TitleLabel,BorderLayout.PAGE_START);
		pane1.add(textArea1Pane1,BorderLayout.CENTER);
		pane1.add(blank,BorderLayout.PAGE_END);
	
		return pane1;
	}
	public static void disposeFrame() {
		frame.dispose();

	}
		
	

}
