package ETMSServer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.jcraft.jsch.JSchException;

import connection.SshClient;
import layout.ServerRestartToolTabbedPane;

public class ETMSServerClass {
	static JButton Submit = new JButton("Submit");
	static JButton Close = new JButton("Close");
	static JRadioButton TIBCOGatewayServer = new JRadioButton("TIBCO Gateway Server           (tibjmsnaming://qatibemsq3c.corp.pep.pvt:12322)");

	static JRadioButton ETMS_DEV = new JRadioButton("ETMS_DEV           (devtibbwd1b.corp.pep.pvt:17624)");
	static JRadioButton ETMS_FIT = new JRadioButton("ETMS_FIT            (devtibbwd1b.corp.pep.pvt:17623)");
	static JRadioButton ETMS_PERF = new JRadioButton("ETMS_PERF         (qatibemsq3c.corp.pep.pvt:18826,tcp://qatibemsq3d.corp.pep.pvt:18828)");
	static JRadioButton ETMS_PRDFIX = new JRadioButton("ETMS_PRDFIX     (devtibbwd1b.corp.pep.pvt:17622)");
	static JRadioButton ETMS_PRDITE = new JRadioButton("ETMS_PRDITE     (qatibemsq3c.corp.pep.pvt:16422,tcp://qatibemsq3d.corp.pep.pvt:16424)");
	static JRadioButton ETMS_SYS2 = new JRadioButton("ETMS_SYS2         (qatibemsq3c.corp.pep.pvt:16522,tcp://qatibemsq3d.corp.pep.pvt:16524) ");
	static JRadioButton ETMS_UAT = new JRadioButton("ETMS_UAT           (qatibemsq3c.corp.pep.pvt:18823,tcp://qatibemsq3d.corp.pep.pvt:18825)");
	static JRadioButton ETMS_SYS1 = new JRadioButton("ETMS_SYS1         (qatibemsq3c.corp.pep.pvt:18822,tcp://qatibemsq3d.corp.pep.pvt:18824)");
	

	public static JPanel ETMSServerRestartpanel() {

		JPanel ETMS = new JPanel();
		JPanel ETMSButton = new JPanel();
		JPanel ETMSTibco = new JPanel();
		JPanel ETMSMain = new JPanel();
		JLabel BlankLabel = new JLabel();
		JLabel BlankLabel1 = new JLabel();
		JLabel BlankLabel2 = new JLabel();
		JLabel BlankLabel3 = new JLabel();
		JLabel BlankLabel4 = new JLabel();
		JLabel BlankLabel5 = new JLabel();
		JLabel BlankLabel6 = new JLabel();
		JLabel BlankLabel7 = new JLabel();
		JLabel BlankLabel9 = new JLabel();
		JLabel BlankLabel10 = new JLabel();

		ETMSButton=addComponentsToButtonadd();


		final ButtonGroup grp = new ButtonGroup();
		grp.add(ETMS_DEV);
		grp.add(ETMS_FIT);
		grp.add(ETMS_PERF);
		grp.add(ETMS_PRDFIX);
		grp.add(ETMS_PRDITE);
		grp.add(ETMS_SYS2);
		grp.add(ETMS_UAT);
		grp.add(ETMS_SYS1);
	
		ETMS_DEV.setEnabled(false);
		ETMS.setBorder(BorderFactory.createTitledBorder("ETMS Server Restart"));
		ETMS.setPreferredSize(new Dimension(500, 400));
		ETMS.setLayout(new GridLayout(16, 1));
		ETMS.add(BlankLabel);
		ETMS.add(ETMS_DEV);
		ETMS.add(BlankLabel1);
		ETMS.add(ETMS_FIT);
		ETMS.add(BlankLabel2);
		ETMS.add(ETMS_PERF);
		ETMS.add(BlankLabel3);
		ETMS.add(ETMS_PRDFIX);
		ETMS.add(BlankLabel4);
		ETMS.add(ETMS_PRDITE);
		ETMS.add(BlankLabel5);
		ETMS.add(ETMS_SYS2);
		ETMS.add(BlankLabel6);
		ETMS.add(ETMS_UAT);
		ETMS.add(BlankLabel7);
		ETMS.add(ETMS_SYS1);
		


		ETMSTibco.setBorder(BorderFactory.createTitledBorder("Tibco gateway server (FLL1)"));
		ETMSTibco.setPreferredSize(new Dimension(500, 100));
		ETMSTibco.setLayout(new GridLayout(3, 1));
		ETMSTibco.add(BlankLabel9);
		ETMSTibco.add(TIBCOGatewayServer);
		ETMSTibco.add(BlankLabel10);

		ETMSMain.setBorder(BorderFactory.createTitledBorder(""));
		ETMSMain.setPreferredSize(new Dimension(500, 600));
		ETMSMain.setLayout(new BorderLayout(5, 5));

		ETMSMain.add(ETMS,BorderLayout.NORTH);
		ETMSMain.add(ETMSTibco,BorderLayout.CENTER);
		ETMSMain.add(ETMSButton,BorderLayout.SOUTH);

		return ETMSMain;
	}
	public static JPanel addComponentsToButtonadd() {

		JPanel Buttonadd = new JPanel();


		ActionListener CloseButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				ServerRestartToolTabbedPane.disposeFrame();
			}
		};

		Close.addActionListener(CloseButtonListener);
		// submit button listener

		ActionListener SubmitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae19) {
				// remember to trim input
				if (ETMS_UAT.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSUAT = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runUAT_TIBCOGateway.ksh";

						client.executeCommand(ETMSUAT, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS UAT server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				
				if (ETMS_FIT.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSFIT = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runFIT_TIBCOGateway.ksh";

						client.executeCommand(ETMSFIT, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS FIT server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (ETMS_PERF.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSPERF = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runPERF_TIBCOGateway.ksh";

						client.executeCommand(ETMSPERF, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS PERF server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (ETMS_PRDFIX.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSPRDFIX = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runPRDFIX_TIBCOGateway.ksh";

						client.executeCommand(ETMSPRDFIX, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS PRDFIX server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (ETMS_PRDITE.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSPRDITE = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runPRDITE_TIBCOGateway.ksh";

						client.executeCommand(ETMSPRDITE, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS PRDITE server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (ETMS_SYS1.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSSYS1 = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runSYS1_TIBCOGateway.ksh";

						client.executeCommand(ETMSSYS1, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS SYS1 server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (ETMS_SYS2.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbdev1";
						String login = "orbmwb18";
						String password = "orbmwb18";

						String ETMSSYS2 = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runSYS2_TIBCOGateway.ksh";

						client.executeCommand(ETMSSYS2, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"ETMS SYS2 server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}
				if (TIBCOGatewayServer.isSelected()) {
					SshClient client = new SshClient();
					try {
						String host = "orbbrn3";
						String login = "orbmst";
						String password = "abcb1234";

						String TibcoGatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runTIBCOGatewayServer.ksh";

						client.executeCommand(TibcoGatewayServer, login, password,
								host);

						JOptionPane.showMessageDialog(null,
								"TibcoGatewayServer restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e,
								"Error Message", 1);
					}
				}

			}


		};


		Submit.addActionListener(SubmitButtonListener);

		Buttonadd.add(Submit);

		Buttonadd.add(Close);
		return Buttonadd;
	}
}
