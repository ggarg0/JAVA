package MasterfilesServer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import com.jcraft.jsch.JSchException;
import connection.SshClient;
import layout.ServerRestartToolTabbedPane;

public class MasterfilesServerClass {

	static String EnvironmentSelected = "";
	static String ServerSelected = "";
	static String NDTServerSelected = "";
	static String AcronymServerSelected = "";

	static String host = "";
	static String login = "";
	static String password = "";
	

	static JButton Submit = new JButton("Submit");
	static JButton Close = new JButton("Close");
	static JRadioButton all = new JRadioButton(
	"All servers   (This includes naming, DRF, TOT and all acronym servers)");
	static JRadioButton NDT = new JRadioButton("Naming, DRF and TOT servers");
	static JRadioButton acronym = new JRadioButton("Acronym servers");
	static JRadioButton AllServers = new JRadioButton(
	"  Naming, DRF and TOT servers");

	static JRadioButton drf = new JRadioButton("  DRF server");
	static JRadioButton tot = new JRadioButton("  TableofTable server");
	static JRadioButton imf = new JRadioButton(
	"   IMF server      (Items Masterfiles)");
	static JRadioButton imfecr = new JRadioButton(
	"   IMFECR server   (Supplier logistic)");
	static JRadioButton aim = new JRadioButton(
	"   AIM server      (Authorizations Masterfiles)");
	static JRadioButton cis = new JRadioButton(
	"   CIS server      (Customer information system)");
	static JRadioButton gpm = new JRadioButton(
	"   GPM server    (Global promotion management)");
	static JRadioButton lis = new JRadioButton(
	"   LIS server      (List Masterfiles)");
	static JRadioButton lms = new JRadioButton(
	"   LMS server    (Location management system)");
	static JRadioButton prd = new JRadioButton(
	"   PRD server    (Products Masterfiles)");
	static JRadioButton sbm = new JRadioButton(
	"   SBM server    (Standard bill of materials)");
	static JRadioButton requestController = new JRadioButton(
	"   Request Controller server");
	static JRadioButton rei = new JRadioButton(
	"   REI server    (Route engineering interface)");
	static JRadioButton RTE = new JRadioButton("RTE");
	static JRadioButton FLL1 = new JRadioButton("FLL1");
	static JCheckBox SpaceUtilized = new JCheckBox("Check Space Utilization");
	static JCheckBox killAll = new JCheckBox("KillAll process");

	static ButtonGroup grp = new ButtonGroup();
	static ButtonGroup grp1 = new ButtonGroup();
	static ButtonGroup grp2 = new ButtonGroup();
	static ButtonGroup grp3 = new ButtonGroup();

	public static JPanel MSTServerRestartpanel() {
		// Main panel
		JPanel MasterfilesPanel = new JPanel();
		JPanel EnvAndServerSelectPanel = new JPanel();
		AllServers.setEnabled(false);
		drf.setEnabled(false);
		tot.setEnabled(false);
		imf.setEnabled(false);
		aim.setEnabled(false);
		cis.setEnabled(false);
		gpm.setEnabled(false);
		lis.setEnabled(false);
		lms.setEnabled(false);
		prd.setEnabled(false);
		sbm.setEnabled(false);
		imfecr.setEnabled(false);
		rei.setEnabled(false);
		requestController.setEnabled(false);

		JPanel Environment = new JPanel();

		grp.add(RTE);
		grp.add(FLL1);

		Environment.setBorder(BorderFactory.createTitledBorder("Environment"));
		Environment.setPreferredSize(new Dimension(200, 75));
		Environment.setLayout(new GridLayout(2, 2));
		Environment.add(RTE);
		Environment.add(SpaceUtilized);
		Environment.add(FLL1);
		Environment.add(killAll);

		ActionListener RTEEnvironmentListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (RTE.isSelected()) {
					host = "orbrte3";
					login = "orbmst";
					password = "pass1234";
					
					EnvironmentSelected = "RTE";
					AllServers.setEnabled(false);
					drf.setEnabled(false);
					tot.setEnabled(false);
					imf.setEnabled(false);
					aim.setEnabled(false);
					cis.setEnabled(false);
					gpm.setEnabled(false);
					lis.setEnabled(false);
					lms.setEnabled(false);
					prd.setEnabled(false);
					sbm.setEnabled(false);
					imfecr.setEnabled(false);
					rei.setEnabled(false);
					requestController.setEnabled(false);
					grp1.clearSelection();
					grp2.clearSelection();
					grp3.clearSelection();
				}
			}
		};

		RTE.addActionListener(RTEEnvironmentListener);

		ActionListener FLL1EnvironmentListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (FLL1.isSelected()) {
					host = "orbbrn3";
					login = "orbmst";
					password = "abcb1234";
				
					EnvironmentSelected = "FLL1";
					AllServers.setEnabled(false);
					drf.setEnabled(false);
					tot.setEnabled(false);
					imf.setEnabled(false);
					aim.setEnabled(false);
					cis.setEnabled(false);
					gpm.setEnabled(false);
					lis.setEnabled(false);
					lms.setEnabled(false);
					prd.setEnabled(false);
					sbm.setEnabled(false);
					imfecr.setEnabled(false);
					rei.setEnabled(false);
					requestController.setEnabled(false);
					grp1.clearSelection();
					grp2.clearSelection();
					grp3.clearSelection();

				}

			}
		};

		FLL1.addActionListener(FLL1EnvironmentListener);

		ActionListener SpaceUtilizedListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (SpaceUtilized.isSelected()) {
					if (RTE.isSelected()) {

						SshClient client = new SshClient();
						try {
							String cmd = "df -k /prod/orbmst";
							client.executeCommand(cmd, login, password, host);
							SpaceUtilized.setSelected(false);
						} catch (JSchException jse) {
							JOptionPane.showMessageDialog(null,
									"JSch Exception occured : " + jse,
									"Error Message", 1);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Exception occured : " + e,
									"Error Message", 1);
						}
					} else if (FLL1.isSelected()) {

						SshClient client = new SshClient();
						try {
							String cmd = "df -k /prod/orbmst";
							client.executeCommand(cmd, login, password, host);
							SpaceUtilized.setSelected(false);
						} catch (JSchException jse) {
							JOptionPane.showMessageDialog(null,
									"JSch Exception occured : " + jse,
									"Error Message", 1);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Exception occured : " + e,
									"Error Message", 1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Please select environment.", "Error Message",
								1);
						SpaceUtilized.setSelected(false);
						killAll.setSelected(false);
						
					}

				}

			}
		};

		SpaceUtilized.addActionListener(SpaceUtilizedListener);

		ActionListener killAllListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (killAll.isSelected()) {
					Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null,
                                "Do you want to kill all active process.\n(Not recommended)",
                                "Confirmation",JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                null,
                                options,
                                options[0]);
                if (n == JOptionPane.YES_OPTION) {
                	if (RTE.isSelected()) {

						SshClient client = new SshClient();
						try {
							
							String cmd1 = "ksh killall.ksh";
						
							client.executeCommand(cmd1, login, password, host);
							killAll.setSelected(false);
						} catch (JSchException jse) {
							JOptionPane.showMessageDialog(null,
									"JSch Exception occured : " + jse,
									"Error Message", 1);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Exception occured : " + e,
									"Error Message", 1);
						}
					} else if (FLL1.isSelected()) {

						SshClient client = new SshClient();
						try {
							String cmd = "ksh killall.ksh";
							client.executeCommand(cmd, login, password, host);
							killAll.setSelected(false);
						} catch (JSchException jse) {
							JOptionPane.showMessageDialog(null,
									"JSch Exception occured : " + jse,
									"Error Message", 1);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"Exception occured : " + e,
									"Error Message", 1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Please select environment.", "Error Message",
								1);
						killAll.setSelected(false);
					}
                	
                } else if (n == JOptionPane.NO_OPTION) {
                	
					killAll.setSelected(false);
                } else {
                	killAll.setSelected(false);
                }
					
				}

			}
		};

		killAll.addActionListener(killAllListener);

		
		// Sub panel 2 for selecting the server
		JPanel ServerSelection = new JPanel();

		grp1.add(NDT);
		grp1.add(acronym);

		ActionListener NDTListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (EnvironmentSelected.equalsIgnoreCase("RTE")) {
					AllServers.setEnabled(true);
					drf.setEnabled(true);
					tot.setEnabled(false);
					imf.setEnabled(false);
					aim.setEnabled(false);
					cis.setEnabled(false);
					gpm.setEnabled(false);
					lis.setEnabled(false);
					lms.setEnabled(false);
					prd.setEnabled(false);
					sbm.setEnabled(false);
					imfecr.setEnabled(false);
					rei.setEnabled(false);
					requestController.setEnabled(false);
					grp3.clearSelection();
				} else if (EnvironmentSelected.equalsIgnoreCase("FLL1")) {
					AllServers.setEnabled(true);
					drf.setEnabled(true);
					tot.setEnabled(true);
					imf.setEnabled(false);
					aim.setEnabled(false);
					cis.setEnabled(false);
					gpm.setEnabled(false);
					lis.setEnabled(false);
					lms.setEnabled(false);
					prd.setEnabled(false);
					sbm.setEnabled(false);
					imfecr.setEnabled(false);
					rei.setEnabled(false);
					requestController.setEnabled(false);
					grp3.clearSelection();
				} else {
					JOptionPane.showMessageDialog(null,
							"Please select environment.", "Error Message", 1);
				}

			}
		};

		NDT.addActionListener(NDTListener);

		ActionListener acronymListener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				imf.setEnabled(true);
				aim.setEnabled(true);
				cis.setEnabled(true);
				gpm.setEnabled(true);
				lis.setEnabled(true);
				lms.setEnabled(true);
				prd.setEnabled(true);
				sbm.setEnabled(true);
				imfecr.setEnabled(true);
				rei.setEnabled(true);
				requestController.setEnabled(true);
				AllServers.setEnabled(false);
				drf.setEnabled(false);
				tot.setEnabled(false);
				grp2.clearSelection();

			}
		};

		acronym.addActionListener(acronymListener);

		ServerSelection.setBorder(BorderFactory
				.createTitledBorder("Server selection"));
		ServerSelection.setPreferredSize(new Dimension(300, 75));
		ServerSelection.setLayout(new GridLayout(2, 1));

		ServerSelection.add(NDT);
		ServerSelection.add(acronym);

		// Sub panel 3 for selecting the server
		JPanel NDTServers = new JPanel();

		grp2.add(AllServers);
		grp2.add(drf);
		grp2.add(tot);

		NDTServers.setBorder(BorderFactory
				.createTitledBorder("Naming DRF and TOT servers"));
		NDTServers.setPreferredSize(new Dimension(500, 100));
		NDTServers.setLayout(new GridLayout(1, 3));
		NDTServers.add(AllServers);
		NDTServers.add(drf);
		NDTServers.add(tot);

		// Sub panel 4 for selecting the server
		JPanel AcronymServer = new JPanel();

		grp3.add(imf);
		grp3.add(aim);
		grp3.add(cis);
		grp3.add(gpm);
		grp3.add(lis);
		grp3.add(lms);
		grp3.add(prd);
		grp3.add(sbm);
		grp3.add(imfecr);
		grp3.add(rei);
		grp3.add(requestController);

		AcronymServer.setBorder(BorderFactory
				.createTitledBorder("Acronym Server Selection"));
		AcronymServer.setPreferredSize(new Dimension(500, 250));
		AcronymServer.setLayout(new GridLayout(11, 1));
		AcronymServer.add(imf);
		AcronymServer.add(aim);
		AcronymServer.add(cis);
		AcronymServer.add(gpm);
		AcronymServer.add(lis);
		AcronymServer.add(lms);
		AcronymServer.add(prd);
		AcronymServer.add(sbm);
		AcronymServer.add(imfecr);
		AcronymServer.add(rei);
		AcronymServer.add(requestController);

		EnvAndServerSelectPanel.setLayout(new BoxLayout(
				EnvAndServerSelectPanel, BoxLayout.X_AXIS));
		EnvAndServerSelectPanel.add(Environment);
		EnvAndServerSelectPanel.add(ServerSelection);

		MasterfilesPanel.setLayout(new BoxLayout(MasterfilesPanel,
				BoxLayout.Y_AXIS));
		MasterfilesPanel.add(EnvAndServerSelectPanel);
		MasterfilesPanel.add(NDTServers);
		MasterfilesPanel.add(AcronymServer);
		MasterfilesPanel.add(addComponentsToButtonadd());
		return MasterfilesPanel;
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
				SshClient client = new SshClient();
				if (RTE.isSelected()) {
					EnvironmentSelected = "RTE";
				} else if (FLL1.isSelected()) {
					EnvironmentSelected = "FLL1";
				} else {
					JOptionPane.showMessageDialog(null,
							"Please select environment.", "Error Message", 1);
				}

				if (NDT.isSelected()) {
					ServerSelected = "NDT";
				} else if (acronym.isSelected()) {
					ServerSelected = "ACRONYM";
				}

				else {
					JOptionPane
					.showMessageDialog(
							null,
							"Please select servers to be restarted from Server selection section.",
							"Error Message", 1);
				}

				if (AllServers.isSelected()) {
					NDTServerSelected = "AllNDTServers";
					try {
						String ALLNDTserver = "";
						ALLNDTserver = "cd .. \n cd ..  \n cd orbmgr \n cd habin \n ksh startorbmgr.ksh";
					
						client.executeCommand(ALLNDTserver, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " naming, DRF and TOT servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}
				} else if (drf.isSelected()) {
					NDTServerSelected = "DRF";
					try {
						String DRFserver = "";
						
							DRFserver = "cd .. \n cd ..  \n cd orbmgr \n cd habin \n ksh startdrfserver6.ksh";
						
						client.executeCommand(DRFserver, login,
								password, host);
						JOptionPane.showMessageDialog(null, EnvironmentSelected
								+ " DRF server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}
				} else if (tot.isSelected()) {
					NDTServerSelected = "TOT";
					try {
						String TOTserver = "";
						if (FLL1.isSelected()) {
							TOTserver = "cd .. \n cd ..  \n cd orbmgr \n cd habin \n ksh starttot60.ksh";
						}

						client.executeCommand(TOTserver, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " TableofTable(TOT) server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}
				}

				else if (imf.isSelected()) {
					AcronymServerSelected = "IMF";

					try {

						String FlexServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runFlexItemServer.ksh";
						String GatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runGatewayServer.ksh";
						String AIMGatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runAIMGatewayServer.ksh";
						String CDSDGatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runCDSDGatewayServer.ksh";
						String SBMGatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runSBMGatewayServer.ksh";
						String BDSJAVA6GatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runBDSJAVA6GatewayServer.ksh";
						String TIBCOGatewayServer = "cd corbaapps \n cd imf \n cd bin \n ksh serverrestart.ksh runTIBCOGatewayServer.ksh";

						client.executeCommand(FlexServer, login, password, host);
						client.executeCommand(GatewayServer, login, password,
								host);
						client.executeCommand(AIMGatewayServer, login,
								password, host);
						client.executeCommand(CDSDGatewayServer, login,
								password, host);
						client.executeCommand(SBMGatewayServer, login,
								password, host);
						client.executeCommand(BDSJAVA6GatewayServer, login,
								password, host);
						client.executeCommand(TIBCOGatewayServer, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Items (IMF) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (cis.isSelected()) {
					AcronymServerSelected = "CIS";

					try {

						String BillingLocationMediatorServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh runBillingLocationMediator.ksh";
						String ChainMediatorServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh runChainMediator.ksh";
						String CustomerMediatorServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh runCustomerMediator.ksh";
						String OwnerMediatorServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh runOwnerMediator.ksh";
						String ChainreportServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh startchainreportserver.ksh";
						String CustomerreportServer = "cd corbaapps \n cd cis \n cd bin \n ksh serverrestart.ksh startcustomerreportserver.ksh";

						client.executeCommand(BillingLocationMediatorServer,
								login, password, host);
						client.executeCommand(ChainMediatorServer, login,
								password, host);
						client.executeCommand(CustomerMediatorServer, login,
								password, host);
						client.executeCommand(OwnerMediatorServer, login,
								password, host);
						client.executeCommand(ChainreportServer, login,
								password, host);
						client.executeCommand(CustomerreportServer, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Customer (CIS) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (gpm.isSelected()) {
					AcronymServerSelected = "GPM";

					try {

						String calmediatorServer = "cd corbaapps \n cd gpm \n cd bin \n ksh serverrestart.ksh runcalmediator.ksh";
						String eventmediatorServer = "cd corbaapps \n cd gpm \n cd bin \n ksh serverrestart.ksh runeventmediator.ksh";
						String reportserverServer = "cd corbaapps \n cd gpm \n cd bin \n ksh serverrestart.ksh runreportserver.ksh";

						client.executeCommand(calmediatorServer, login,
								password, host);
						client.executeCommand(eventmediatorServer, login,
								password, host);
						client.executeCommand(reportserverServer, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Promotion (GPM) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (aim.isSelected()) {
					AcronymServerSelected = "AIM";

					try {

						String AIMMessageServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runAIMMessageServer.ksh";
						String AIMServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runAIMServer.ksh";
						String ApprovedAuthServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runApprovedAuthServer.ksh";
						String GeographySetServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runGeographySetServer.ksh";
						String PendingAuthServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runPendingAuthServer.ksh";
						String SourceServer = "cd corbaapps \n cd aim \n cd bin \n ksh serverrestart.ksh runSourceServer.ksh";

						client.executeCommand(AIMMessageServer, login,
								password, host);
						client.executeCommand(AIMServer, login, password, host);
						client.executeCommand(ApprovedAuthServer, login,
								password, host);
						client.executeCommand(GeographySetServer, login,
								password, host);
						client.executeCommand(PendingAuthServer, login,
								password, host);
						client.executeCommand(SourceServer, login, password,
								host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Authorizations (AIM) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (lms.isSelected()) {
					AcronymServerSelected = "LMS";

					try {
						
						String DeliveryServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runDeliveryServer.ksh";
						String EmployeeServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runEmployeeServer.ksh";
						String HHCParamSetsServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runHHCParamSetsServer.ksh";
						String LocationServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runLocationServer.ksh";
						String MgmtStructureServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runMgmtStructureServer.ksh";
						String PerformanceServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runPerformanceServer.ksh";
						String RouteCompositeServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runRouteCompositeServer.ksh";
						String RouteReportServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runRouteReportServer.ksh";
						String RouteServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runRouteServer.ksh";
						String RouteTypesServer = "cd corbaapps \n cd lms \n cd bin \n ksh serverrestart.ksh runRouteTypesServer.ksh";

						client.executeCommand(DeliveryServer, login, password,
								host);
						client.executeCommand(EmployeeServer, login, password,
								host);
						client.executeCommand(HHCParamSetsServer, login,
								password, host);
						client.executeCommand(LocationServer, login, password,
								host);
						client.executeCommand(MgmtStructureServer, login,
								password, host);
						client.executeCommand(PerformanceServer, login,
								password, host);
						client.executeCommand(RouteCompositeServer, login,
								password, host);
						client.executeCommand(RouteReportServer, login,
								password, host);
						client.executeCommand(RouteServer, login, password,
								host);
						client.executeCommand(RouteTypesServer, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Location (LMS) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (lis.isSelected()) {
					AcronymServerSelected = "LIS";

					try {

						String crlreportserver = "cd corbaapps \n cd lis \n cd bin \n ksh serverrestart.ksh runcrlreportserver.ksh";
						String plreportserver = "cd corbaapps \n cd lis \n cd bin \n ksh serverrestart.ksh runplreportserver.ksh";
						String crlmediator = "cd corbaapps \n cd lis \n cd bin \n ksh serverrestart.ksh runcrlmediator.ksh";
						String plmediator = "cd corbaapps \n cd lis \n cd bin \n ksh serverrestart.ksh runplmediator.ksh";

						client.executeCommand(crlreportserver, login, password,
								host);
						client.executeCommand(plreportserver, login, password,
								host);
						client.executeCommand(crlmediator, login, password,
								host);
						client.executeCommand(plmediator, login, password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " List (LIS) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (prd.isSelected()) {
					AcronymServerSelected = "PRD";

					try {

						String FGItemServer = "cd corbaapps \n cd prd \n cd bin \n ksh serverrestart.ksh runFGItemServer.ksh";
						String PRDToECCUpdateServer = "cd corbaapps \n cd prd \n cd bin \n ksh serverrestart.ksh runPRDToECCUpdateServer.ksh";
						String UPCServer = "cd corbaapps \n cd prd \n cd bin \n ksh serverrestart.ksh runUPCServer.ksh";

						client.executeCommand(FGItemServer, login, password,
								host);
						client.executeCommand(PRDToECCUpdateServer, login,
								password, host);
						client.executeCommand(UPCServer, login, password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Product (PRD) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (sbm.isSelected()) {
					AcronymServerSelected = "SBM";

					try {

						String SBMManager = "cd corbaapps \n cd sbm \n cd bin \n ksh serverrestart.ksh runSBMManager.ksh";

						client.executeCommand(SBMManager, login, password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Standard bill of materials (SBM) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (requestController.isSelected()) {
					AcronymServerSelected = "requestController";

					try {

						String RequestControllerServer = "cd corbaapps \n cd requestcontroller \n cd bin \n ksh serverrestart.ksh runRequestControllerServer.ksh";

						client.executeCommand(RequestControllerServer, login,
								password, host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Request Controller server restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (imfecr.isSelected()) {
					AcronymServerSelected = "IMFECR";

					try {

						String IMFECRServer = "cd corbaapps \n cd imfecr \n cd bin \n ksh serverrestart.ksh runIMFECRServer.ksh";
						String LogisticsMQGet = "cd corbaapps \n cd imfecr \n cd bin \n ksh serverrestart.ksh runLogisticsMQGet.ksh";

						client.executeCommand(IMFECRServer, login, password,
								host);
						client.executeCommand(LogisticsMQGet, login, password,
								host);

						JOptionPane
						.showMessageDialog(
								null,
								EnvironmentSelected
								+ " Supplier logistic (IMFECR) servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}

				} else if (rei.isSelected()) {
					AcronymServerSelected = "REI";

					try {

						String REIServer = "cd corbaapps \n cd rei \n cd bin \n ksh serverrestart.ksh runREIServer.ksh";

						client.executeCommand(REIServer, login, password, host);

						JOptionPane.showMessageDialog(null, EnvironmentSelected
								+ " REI servers restarted successfully.",
								"Message", 1);
					} catch (JSchException jse) {
						JOptionPane.showMessageDialog(null,
								"JSch Exception occured : " + jse,
								"Error Message", 1);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Exception occured : " + e, "Error Message", 1);
					}
				}

				else {
					JOptionPane.showMessageDialog(null,
							"Please select server to be restarted.",
							"Error Message", 1);
				}

			}

		};

		Submit.addActionListener(SubmitButtonListener);

		Buttonadd.add(Submit);

		Buttonadd.add(Close);
		return Buttonadd;
	}
	public static void refresh()
	{
		grp1.clearSelection();
	}
}
