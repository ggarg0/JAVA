package AVSServer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.jcraft.jsch.JSchException;

import connection.SshClient;
import layout.ServerRestartToolTabbedPane;

public class AVSServerClass {
	static JButton Submit = new JButton("Submit");
	static JButton Close = new JButton("Close");

	static String host = "";
	static String login = "";
	static String password = "";
	static String Fll1Serverselect = "";
	static String RTEserverselect = "";

	static JRadioButton START_AVS = new JRadioButton("Start AVS server");
	static JRadioButton STOP_AVS = new JRadioButton("Stop AVS server");
	static JRadioButton START_ADMIN = new JRadioButton("Start Admin server");
	static JRadioButton STOP_ADMIN = new JRadioButton("Stop Admin server");
	static ButtonGroup grp1 = new ButtonGroup();

	public static JPanel AVSServerRestartpanel() {

		JPanel AVSENV = new JPanel();
		JPanel AVSFLL1 = new JPanel();
		// JPanel AVSRTE = new JPanel();
		JPanel AVSButton = new JPanel();
		JPanel AVSMain = new JPanel();
		JLabel BlankLabel = new JLabel();
		JLabel BlankLabel1 = new JLabel();

		AVSButton = addComponentsToButtonadd();
		final JRadioButton AVS_FLL1 = new JRadioButton("AVS Domain Server FLL1");
		final JRadioButton AVS_RTE = new JRadioButton("AVS Domain Server RTE");


		final ButtonGroup grp = new ButtonGroup();
		grp.add(AVS_FLL1);
		grp.add(AVS_RTE);

		final ButtonGroup grp1 = new ButtonGroup();
		grp1.add(START_AVS);
		grp1.add(STOP_AVS);
		grp1.add(START_ADMIN);
		grp1.add(STOP_ADMIN);

		START_ADMIN.setEnabled(false);
		STOP_ADMIN.setEnabled(false);
		START_AVS.setEnabled(false);
		STOP_AVS.setEnabled(false);

		AVSENV.setBorder(BorderFactory
				.createTitledBorder("AVS Servers Selection "));
		AVSENV.setPreferredSize(new Dimension(300, 100));
		AVSENV.setLayout(new GridLayout(2, 1));
		AVSENV.add(BlankLabel);
		AVSENV.add(AVS_FLL1);
		AVSENV.add(BlankLabel1);
		AVSENV.add(AVS_RTE);

		AVSFLL1.setBorder(BorderFactory.createTitledBorder("AVS Domain Server"));
		AVSFLL1.setPreferredSize(new Dimension(400, 100));
		AVSFLL1.setLayout(new GridLayout(2, 4));
		AVSFLL1.add(BlankLabel);
		AVSFLL1.add(START_AVS);
		AVSFLL1.add(BlankLabel1);
		AVSFLL1.add(STOP_AVS);
		AVSFLL1.add(BlankLabel);
		AVSFLL1.add(START_ADMIN);
		AVSFLL1.add(BlankLabel1);
		AVSFLL1.add(STOP_ADMIN);
		AVSFLL1.add(BlankLabel1);

		AVSMain.setBorder(BorderFactory.createTitledBorder(""));
		AVSMain.setPreferredSize(new Dimension(500, 500));
		AVSMain.setLayout(new BorderLayout(5, 5));

		AVSMain.setLayout(new BoxLayout(AVSMain, BoxLayout.Y_AXIS));
		AVSMain.add(AVSENV);
		AVSMain.add(AVSFLL1);
		AVSMain.add(AVSButton);

		ActionListener SelectionListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae19) {
				if (AVS_FLL1.isSelected()) {

					host = "wlsvite21";
					login = "wlsavs";
					password = "Wls.avs123";

					START_ADMIN.setEnabled(true);
					STOP_ADMIN.setEnabled(true);
					START_AVS.setEnabled(true);
					STOP_AVS.setEnabled(true);
					AVS_RTE.setSelected(false);
					grp1.clearSelection();

				} else if (AVS_RTE.isSelected()) {

					host = "wlsvdev12";
					login = "wlsavs";
					password = "Wls.avs123";

					START_ADMIN.setEnabled(true);
					STOP_ADMIN.setEnabled(true);
					START_AVS.setEnabled(false);
					STOP_AVS.setEnabled(false);
					AVS_FLL1.setSelected(false);
					grp1.clearSelection();
				}
				
				

			}

		};
		AVS_FLL1.addActionListener(SelectionListener);
		AVS_RTE.addActionListener(SelectionListener);

		ActionListener SubmitButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae19) {
				// remember to trim input
				SshClient client = new SshClient();

				if (AVS_FLL1.isSelected()) {

					if (START_AVS.isSelected()) {
						Fll1Serverselect = "AvsServer";
						STOP_AVS.setSelected(false);
						START_ADMIN.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {

							String AvsServer = "cd /bea/domains/avsdomain/servers/avsserver/bin \n ksh startavsserver";

							client.executeCommand(AvsServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									Fll1Serverselect
									+ " AVS servers started successfully.",
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

					} else if (STOP_AVS.isSelected()) {
						Fll1Serverselect = "AvsServer";
						START_AVS.setSelected(false);
						START_ADMIN.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {

							String AvsServer = "cd /bea/domains/avsdomain/servers/avsserver/bin \n ksh stopavsserver";
							client.executeCommand(AvsServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									Fll1Serverselect
									+ " AVS servers Stopped successfully.",
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

					else if (START_ADMIN.isSelected()) {
						Fll1Serverselect = "AdminServer";
						STOP_AVS.setSelected(false);
						START_AVS.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {
							String AdminServer = "";
							AdminServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh startadminserver";
							client.executeCommand(AdminServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									Fll1Serverselect
									+ " Admin servers started successfully.",
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
					} else if (STOP_ADMIN.isSelected()) {
						Fll1Serverselect = "AdminServer";
						STOP_AVS.setSelected(false);
						START_AVS.setSelected(false);
						START_ADMIN.setSelected(false);

						try {

							String AdminServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh stopadminserver";
							client.executeCommand(AdminServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									Fll1Serverselect
									+ " Admin servers Stopped successfully.",
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
					
					else {
						JOptionPane
						.showMessageDialog(
								null,
								Fll1Serverselect
								+ " Please Select Server.",
								"Message", 1);
					}

				}

				if (AVS_RTE.isSelected()) {

					if (START_AVS.isSelected()) {
						RTEserverselect = "AvsServer";
						STOP_AVS.setSelected(false);
						START_ADMIN.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {

							String AvsServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh startavsserver";

							client.executeCommand(AvsServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									RTEserverselect
									+ " AVS servers is not available please start admins server",
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
					} else if (STOP_AVS.isSelected()) {
						RTEserverselect = "AvsServer";
						START_ADMIN.setSelected(false);
						START_AVS.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {

							String AvsServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh stopavsserver";
							client.executeCommand(AvsServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane
							.showMessageDialog(
									null,
									RTEserverselect
									+ " AVS servers is not available please stop admins server",
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
					else if (START_ADMIN.isSelected()) {
						RTEserverselect = "AdminServer";
						STOP_AVS.setSelected(false);
						START_AVS.setSelected(false);
						STOP_ADMIN.setSelected(false);

						try {
							String AdminServer = "";
							AdminServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh startadminserver";
							client.executeCommand(AdminServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane.showMessageDialog(null, RTEserverselect
									+ " Admin servers started successfully.",
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
					} else if (STOP_ADMIN.isSelected()) {
						RTEserverselect = "AdminServer";
						STOP_AVS.setSelected(false);
						START_AVS.setSelected(false);
						START_ADMIN.setSelected(false);

						try {

							String AdminServer = "cd /bea/domains/avsdomain/servers/adminserver/bin \n ksh stopadminserver";
							client.executeCommand(AdminServer, login, password,
									host);
							grp1.clearSelection();
							JOptionPane.showMessageDialog(null, RTEserverselect
									+ " Admin servers Stopped successfully.",
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
					
					else {
						JOptionPane
						.showMessageDialog(
								null,
								Fll1Serverselect
								+ " Please Select Server.",
								"Message", 1);
					}

					
				}
				
				if(!AVS_RTE.isSelected() && !AVS_FLL1.isSelected())
				{
					JOptionPane.showMessageDialog(null,
							"Please select environment.", "Error Message",
							1);
				}

			}

		};
		Submit.addActionListener(SubmitButtonListener);

		return AVSMain;
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

		Buttonadd.add(Submit);

		Buttonadd.add(Close);
		return Buttonadd;
	}

}