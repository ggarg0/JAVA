package Swings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Assignment21 extends JPanel implements ActionListener
{

		static JFrame frame = new JFrame("Track Window Request Search");
        static String dept;

        static String TypeOfSearchtxt;
        static String Prioritytxt;
        static String WorkOrderStatustxt;

        static String RollUpCTRtxt;
        static String WindowsRequiredtxt;
        static String WindowsStatustxt;
        static String WorkOrderNametxt;
        static String WorkOrderidtxt;


        static String LStxt;
        static String BMPtxt;
        static String EMPtxt;
        static String AssetIdtxt;
        static String Resoucetxt;
        static String datatxt;

        static String dept1;

        static String TypeOfSearchtxt1;
        static String Prioritytxt1;
        static String WorkOrderStatustxt1;

        static String RollUpCTRtxt1;
        static String WindowsRequiredtxt1;
        static String WindowsStatustxt1;
        static String WorkOrderNametxt1;
        static String WorkOrderidtxt1;


        static String LStxt1;
        static String BMPtxt1;
        static String EMPtxt1;
        static String AssetIdtxt1;
        static String Resoucetxt1;
        static String datatxt1;

        static String Blank = "";
        static String Both = "Both";
        static String TrackWindow="Track Windows";
        static String Workorder="Work Orders ";
        static String AllWindows="All Windows";
        static String WindowNotRequired="Window Not Required";
        static String WindowRequired="Window Required";
        static String High="High";
        static String Low="Low";
        static String Medium="Medium";
        static String complete="Complete";
        static String incomplete="Incomplete";
        static String retl="RETL";
        static String ped="PED";
        static String si="SI";
        static String yes="Yes";
        static String no="No";
        static String update="Updated";
        static String notupdate="Not Updated";

        static String se="SE";
        static String pm="PM";
        static String spm="SPM";
        static String gpm="GPM";
        static String BlankCombo = "";
        static String hrm="HRM";
        static String ccd="CCD";
        static String enr="E&R";


        static JLabel TypeOfSearch = new JLabel("Type of Search ");

        static String comboBoxItems[] = { Both, TrackWindow,Workorder };
        static JComboBox cbTypeOfSearch = new JComboBox(comboBoxItems);

        static String comboBoxItems4[] = {Blank, Low,Medium,High };
        static JComboBox cbPriority = new JComboBox(comboBoxItems4);

        static String comboBoxItems3[] = { Blank,complete,incomplete };
        static JComboBox cbWorkOrderStatus = new JComboBox(comboBoxItems3);

        static String comboBoxItems5[] = {Blank,retl,ped,si };
        static JComboBox cbSubDept = new JComboBox(comboBoxItems5);

        static String comboBoxItems6[] = {Blank, yes,no };
        static JComboBox cbRollUpCTR = new JComboBox(comboBoxItems6);

        static String comboBoxItems1[] = { AllWindows, WindowNotRequired,WindowRequired };
        static JComboBox cbWindowsRequired = new JComboBox(comboBoxItems1);

        static String comboBoxItems7[] = {Blank, update,notupdate };
        static JComboBox cbWindowsStatus = new JComboBox(comboBoxItems7);

        static JTextField WorkOrderNameText = new JTextField();

        static JTextField WorkOrderIdText = new JTextField();

        static JTextField LSText = new JTextField(6);
        static JTextField BMPText = new JTextField(6);
        static JTextField EMPText = new JTextField(6);
        static JTextField AssetIDText = new JTextField(6);

        static String comboBoxItems8[] = {BlankCombo,se,pm,spm,gpm};
        static JComboBox cbResourceRequest = new JComboBox(comboBoxItems8);

        static String comboBoxItems9[] = { BlankCombo,hrm,ccd,enr };
        static JComboBox cbDataSource = new JComboBox(comboBoxItems9);


        static JTextField AFEText = new JTextField();
        // Adding components to workOrderDetails Panel

        public static JPanel addComponentsToworkOrderDetails()
        {

            JPanel workOrderDetails = new JPanel();

            TypeOfSearch.setVerticalTextPosition(AbstractButton.BOTTOM);
            TypeOfSearch.setHorizontalTextPosition(AbstractButton.CENTER);

            cbTypeOfSearch.setEditable(false);

            ItemListener ae3 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae3)
                {
               		TypeOfSearchtxt=(cbTypeOfSearch.getSelectedItem().toString());
        	    }
            };

            cbTypeOfSearch.addItemListener(ae3);

            JLabel Priority = new JLabel("Priority ");
            Priority.setVerticalTextPosition(AbstractButton.BOTTOM);
            Priority.setHorizontalTextPosition(AbstractButton.CENTER);

            cbPriority.setEditable(false);

            ItemListener ae4 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae4)
                {
               		Prioritytxt=(cbPriority.getSelectedItem().toString());
        	    }
            };

            cbPriority.addItemListener(ae4);


            JLabel WorkOrderStatus = new JLabel("Work Order Status ");
        	WorkOrderStatus.setVerticalTextPosition(AbstractButton.BOTTOM);
        	WorkOrderStatus.setHorizontalTextPosition(AbstractButton.CENTER);

        	cbWorkOrderStatus.setEditable(false);

        	 ItemListener ae5 = new ItemListener()
             {
                	public void itemStateChanged(ItemEvent ae5)
                 {
                		WorkOrderStatustxt=(cbWorkOrderStatus.getSelectedItem().toString());
         	    }
             };

             cbWorkOrderStatus.addItemListener(ae5);

        	JLabel WorkOrderRequest = new JLabel("Work Order Request Only ");
        	WorkOrderRequest.setVerticalTextPosition(AbstractButton.BOTTOM);
        	WorkOrderRequest.setHorizontalTextPosition(AbstractButton.CENTER);

        	JLabel WorkOrderRequest1 = new JLabel();
        	WorkOrderRequest1.setVerticalTextPosition(AbstractButton.BOTTOM);
        	WorkOrderRequest1.setHorizontalTextPosition(AbstractButton.CENTER);

        	JLabel SubDept = new JLabel("Sub Dept ");
        	SubDept.setVerticalTextPosition(AbstractButton.BOTTOM);
        	SubDept.setHorizontalTextPosition(AbstractButton.CENTER);


	        cbSubDept.setEditable(false);

	        ItemListener ae = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae)
                {
               		dept=(cbSubDept.getSelectedItem().toString());
        	    }
            };

            cbSubDept.addItemListener(ae);

	        JLabel RollUpCTR = new JLabel("Rollup CTR ");
	        RollUpCTR.setVerticalTextPosition(AbstractButton.BOTTOM);
	        RollUpCTR.setHorizontalTextPosition(AbstractButton.CENTER);


	        cbRollUpCTR.setEditable(false);

	        ItemListener ae6 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae6)
                {
               		RollUpCTRtxt=(cbRollUpCTR.getSelectedItem().toString());
        	    }
            };

            cbRollUpCTR.addItemListener(ae6);

	        JLabel WindowsRequired = new JLabel("Windows Required ");
	        WindowsRequired.setVerticalTextPosition(AbstractButton.BOTTOM);
	        WindowsRequired.setHorizontalTextPosition(AbstractButton.CENTER);

	        cbWindowsRequired.setEditable(false);

	        ItemListener ae7 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae7)
                {
               		WindowsRequiredtxt=(cbWindowsRequired.getSelectedItem().toString());
        	    }
            };

            cbWindowsRequired.addItemListener(ae7);

	        JLabel WindowsStatus = new JLabel("Windows Status ");
	        WindowsStatus.setVerticalTextPosition(AbstractButton.BOTTOM);
	        WindowsStatus.setHorizontalTextPosition(AbstractButton.CENTER);


	        cbWindowsStatus.setEditable(false);

	        ItemListener ae8 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae8)
                {
               		WindowsStatustxt=(cbWindowsStatus.getSelectedItem().toString());
        	    }
            };

            cbWindowsStatus.addItemListener(ae8);

	        JLabel WorkOrderName = new JLabel("Work Order Name");
	        WorkOrderName.setVerticalTextPosition(AbstractButton.BOTTOM);
	        WorkOrderName.setHorizontalTextPosition(AbstractButton.CENTER);

	        FocusListener ae9 = new FocusListener()
            {

               	public void focusLost(FocusEvent ae)
                {
               		WorkOrderNametxt=WorkOrderNameText.getText();

                }

               	public void focusGained(FocusEvent ae)
                {

                }
            };

            WorkOrderNameText.addFocusListener(ae9);

	        JLabel WorkOrderId = new JLabel("Work Order Id");
	        WorkOrderId.setVerticalTextPosition(AbstractButton.BOTTOM);
	        WorkOrderId.setHorizontalTextPosition(AbstractButton.CENTER);


	        FocusListener ae10 = new FocusListener()
            {

               	public void focusLost(FocusEvent ae)
                {
               		WorkOrderidtxt=WorkOrderIdText.getText();

                }

               	public void focusGained(FocusEvent ae)
                {

                }
            };

            WorkOrderIdText.addFocusListener(ae10);

	        workOrderDetails.setBorder(BorderFactory.createTitledBorder("Work Order Details"));
	        workOrderDetails.setPreferredSize(new Dimension(500,300));
	        workOrderDetails.setLayout(new GridLayout(10,10,5,5));
	        workOrderDetails.add(TypeOfSearch);
	        workOrderDetails.add(cbTypeOfSearch);
	        workOrderDetails.add(Priority);
	        workOrderDetails.add(cbPriority);
	        workOrderDetails.add(WorkOrderStatus);
	        workOrderDetails.add(cbWorkOrderStatus);
	        workOrderDetails.add(WorkOrderRequest);
	        workOrderDetails.add(WorkOrderRequest1);
	        workOrderDetails.add(SubDept);
	        workOrderDetails.add(cbSubDept);
	        workOrderDetails.add(RollUpCTR);
	        workOrderDetails.add(cbRollUpCTR);
	        workOrderDetails.add(WindowsRequired);
	        workOrderDetails.add(cbWindowsRequired);
	        workOrderDetails.add(WindowsStatus);
	        workOrderDetails.add(cbWindowsStatus);
	        workOrderDetails.add(WorkOrderName);
	        workOrderDetails.add(WorkOrderNameText);
	        workOrderDetails.add(WorkOrderId);
	        workOrderDetails.add(WorkOrderIdText);
	        return workOrderDetails;
        }

        // Adding components to LocationAndSource Panel

        public static JPanel addComponentsToLocationAndSource()
        {

            JPanel LocationAndSource = new JPanel();
            JLabel Blank = new JLabel();
            JLabel Blank1 = new JLabel();

            JLabel LS = new JLabel("LS ");
            LS.setVerticalTextPosition(AbstractButton.BOTTOM);
            LS.setHorizontalTextPosition(AbstractButton.CENTER);


            FocusListener ae13 = new FocusListener()
            {
            	public void focusLost(FocusEvent ae)
                {
            		LStxt=LSText.getText();
                }

               	public void focusGained(FocusEvent ae)
                {
               		BMPText.setEnabled(true);
               		EMPText.setEnabled(true);
                }

             };

            LSText.addFocusListener(ae13);

            JLabel BMP = new JLabel("BMP ");
            BMP.setVerticalTextPosition(AbstractButton.BOTTOM);
            BMP.setHorizontalTextPosition(AbstractButton.CENTER);

            BMPText.setEnabled(false);

            FocusListener ae14 = new FocusListener()
            {
            	public void focusLost(FocusEvent ae)
                {
            		BMPtxt=BMPText.getText();
                }

               	public void focusGained(FocusEvent ae)
                {

                }
            };

            BMPText.addFocusListener(ae14);

            JLabel EMP = new JLabel("EMP ");
            EMP.setVerticalTextPosition(AbstractButton.BOTTOM);
            EMP.setHorizontalTextPosition(AbstractButton.CENTER);


            EMPText.setEnabled(false);

            FocusListener ae = new FocusListener()
            {
               	public void focusLost(FocusEvent ae)
                {

               		EMPtxt=EMPText.getText();
                }

               	public void focusGained(FocusEvent ae)
                {

                }
            };

            EMPText.addFocusListener(ae);

            JLabel AssetID = new JLabel("Asset ID ");
            AssetID.setVerticalTextPosition(AbstractButton.BOTTOM);
            AssetID.setHorizontalTextPosition(AbstractButton.CENTER);

            FocusListener ae16 = new FocusListener()
            {
            	public void focusLost(FocusEvent ae)
                {
            		AssetIdtxt=AssetIDText.getText();
                }

               	public void focusGained(FocusEvent ae)
                {

                }
            };

            AssetIDText.addFocusListener(ae16);

            JLabel ResourceRequest = new JLabel("Resource Request ");
            ResourceRequest.setVerticalTextPosition(AbstractButton.BOTTOM);
            ResourceRequest.setHorizontalTextPosition(AbstractButton.CENTER);

            cbResourceRequest.setEditable(false);

            ItemListener ae11 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae11)
                {
               		Resoucetxt=(cbResourceRequest.getSelectedItem().toString());
        	    }
            };

            cbResourceRequest.addItemListener(ae11);

            JLabel DataSource = new JLabel("Data Source ");
            DataSource.setVerticalTextPosition(AbstractButton.BOTTOM);
            DataSource.setHorizontalTextPosition(AbstractButton.CENTER);

            cbDataSource.setEditable(false);

            ItemListener ae12 = new ItemListener()
            {
               	public void itemStateChanged(ItemEvent ae12)
                {
               		datatxt=(cbDataSource.getSelectedItem().toString());
        	    }
            };

            cbDataSource.addItemListener(ae12);

            JLabel Blank2 = new JLabel();
            JLabel Blank21 = new JLabel();

            LocationAndSource.setBorder(BorderFactory.createTitledBorder("Location And Source"));
            LocationAndSource.setPreferredSize(new Dimension(500,300));
            LocationAndSource.setLayout(new GridLayout(9,9,5,5));
            LocationAndSource.add(Blank);
            LocationAndSource.add(Blank1);
            LocationAndSource.add(LS);
            LocationAndSource.add(LSText);
            LocationAndSource.add(BMP);
            LocationAndSource.add(BMPText);
            LocationAndSource.add(EMP);
            LocationAndSource.add(EMPText);
            LocationAndSource.add(AssetID);
            LocationAndSource.add(AssetIDText);
            LocationAndSource.add(ResourceRequest);
            LocationAndSource.add(cbResourceRequest);
            LocationAndSource.add(DataSource);
            LocationAndSource.add(cbDataSource);
            LocationAndSource.add(Blank2);
            LocationAndSource.add(Blank21);

        	return LocationAndSource;
        }

//      Adding components to TextSearch Panel

        public static JPanel addComponentsToTextSearch()
        {


            JPanel TextSearch = new JPanel();
            JLabel AFE = new JLabel("AFE ");
            AFE.setVerticalTextPosition(AbstractButton.BOTTOM);
            AFE.setHorizontalTextPosition(AbstractButton.CENTER);

            AFEText.setText("1500");

            Font newTextFieldFont=new Font(AFEText.getFont().getName(),Font.BOLD,AFEText.getFont().getSize());

            //Set JTextField font using new created font
            AFEText.setFont(newTextFieldFont);

            JLabel Comments = new JLabel("Comments ");
            Comments.setVerticalTextPosition(AbstractButton.BOTTOM);
            Comments.setHorizontalTextPosition(AbstractButton.CENTER);
            JTextField CommentsText = new JTextField();
            CommentsText.setEditable(false);

            TextSearch.setBorder(BorderFactory.createTitledBorder("Text Search"));
            TextSearch.setPreferredSize(new Dimension(500,125));
            TextSearch.setLayout(new GridLayout(2,2,5,5));
            TextSearch.add(AFE);
            TextSearch.add(AFEText);
            TextSearch.add(Comments);
            TextSearch.add(CommentsText);

        	return TextSearch;
        }

//   	 Adding components to date Panel

        public static JPanel addComponentsTodate()
        {

            JPanel date = new JPanel();
            JCheckBox Searchondate = new JCheckBox("Search on Date : ");
            JLabel dateBlank=new  JLabel();
            JLabel dateBlank1=new  JLabel();
            JLabel dateBlank2=new  JLabel();
            JLabel dateBlank3=new  JLabel();

            final JRadioButton Startdate =new JRadioButton("Start Date ");
            Startdate.setSelected(true);
            Startdate.setEnabled(false);

            final JRadioButton Enddate =new JRadioButton("End Date ");
            Enddate.setEnabled(false);

            final JRadioButton completedate =new JRadioButton("Complete Date ");
            completedate.setEnabled(false);

            final ButtonGroup grp1=new ButtonGroup();
            grp1.add(Startdate);
            grp1.add(Enddate);
            grp1.add(completedate);


            ActionListener ae = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae)
                {
               		Startdate.setEnabled(true);
               		Enddate.setEnabled(true);
               		completedate.setEnabled(true);

                }
            };

            Searchondate.addActionListener(ae);


            JLabel Between=new  JLabel("    between");
            JTextField date1=new JTextField();
            JLabel and=new  JLabel("    and");
            JTextField date2=new JTextField();

            date.setBorder(BorderFactory.createTitledBorder("Date "));
            date.setPreferredSize(new Dimension(500,125));
            date.setLayout(new GridLayout(3,3,5,5));
            date.add(Searchondate);
            date.add(dateBlank);
            date.add(dateBlank1);
            date.add(dateBlank2);
            date.add(Startdate);
            date.add(Enddate);
            date.add(completedate);
            date.add(dateBlank3);
            date.add(Between);
            date.add(date1);
            date.add(and);
            date.add(date2);

        	return date;
        }

//      Adding components to AssignedGang Panel

        public static JPanel addComponentsToAssignedGang()
        {
        	 final String None = "None";
             final  String All = "All";
             final  String Both = "Both";



             JPanel AssignedGang = new JPanel();

             JLabel Assigned = new JLabel("Assigned/UnAssigned ");
             Assigned.setVerticalTextPosition(AbstractButton.BOTTOM);
             Assigned.setHorizontalTextPosition(AbstractButton.CENTER);

             String comboBoxItems2[] = { Both, None,All };
             JComboBox cbAssigned = new JComboBox(comboBoxItems2);
             cbAssigned.setEditable(false);

             JLabel AssignedGangType = new JLabel("Assigned Gang Type ");
             AssignedGangType.setVerticalTextPosition(AbstractButton.BOTTOM);
             AssignedGangType.setHorizontalTextPosition(AbstractButton.CENTER);

             JComboBox cbAssignedGangType = new JComboBox();
             cbAssignedGangType.setEnabled(false);

             JLabel AssignedGang1 = new JLabel("Assigned Gang ");
             AssignedGang1.setVerticalTextPosition(AbstractButton.BOTTOM);
             AssignedGang1.setHorizontalTextPosition(AbstractButton.CENTER);

             JComboBox cbAssignedGang1 = new JComboBox();
             cbAssignedGang1.setEnabled(false);


             AssignedGang.setBorder(BorderFactory.createTitledBorder("Assigned Gang"));
             AssignedGang.setPreferredSize(new Dimension(500,125));
             AssignedGang.setLayout(new GridLayout(3,3,5,5));
             AssignedGang.add(Assigned);
             AssignedGang.add(cbAssigned);
             AssignedGang.add(AssignedGangType);
             AssignedGang.add(cbAssignedGangType);
             AssignedGang.add(AssignedGang1);
             AssignedGang.add(cbAssignedGang1);

        	 return AssignedGang;
        }

//   	 Adding components to category Panel

        public static JPanel addComponentsTocategory()
        {

            JPanel category = new JPanel();
            JCheckBox Mtce = new JCheckBox("Mtce Workplan ");
            Mtce.setSelected(true);

            JCheckBox Workbacklog = new JCheckBox("Work backlog ");
            Workbacklog.setSelected(true);

            category.setBorder(BorderFactory.createTitledBorder("Category "));
            category.setPreferredSize(new Dimension(250,125));
            category.setLayout(new GridLayout(0,1,5,5));
            category.add(Mtce);
            category.add(Workbacklog);

        	return category;
        }

//   	 Adding components to status Panel

        public static JPanel addComponentsTostatus()
        {
        	JPanel status = new JPanel();
            JCheckBox Searchfor = new JCheckBox("Search For : ");
            Searchfor.setEnabled(false);

            JRadioButton DelTrack =new JRadioButton("Del Track Windows ");
            DelTrack.setSelected(true);
            DelTrack.setEnabled(false);
            JRadioButton ExpTrack =new JRadioButton("Exp Track Windows ");
            ExpTrack.setEnabled(false);

            final ButtonGroup grp=new ButtonGroup();
            grp.add(DelTrack);
            grp.add(ExpTrack);

            status.setBorder(BorderFactory.createTitledBorder("Status "));
            status.setPreferredSize(new Dimension(250,125));
            status.setLayout(new GridLayout(0,1,5,5));
            status.add(Searchfor);
            status.add(DelTrack);
            status.add(ExpTrack);

        	return status;
        }

//   	 Adding components to task,task11 Panel

        public static JPanel addComponentsToMain()
        {

        	final JTextField tasktext=new JTextField();
            JPanel task = new JPanel();
            JPanel task11 = new JPanel();

            JLabel ExcludetaskName=new  JLabel("Exclude Task Name(s) ");
            JCheckBox task1 = new JCheckBox();
            JLabel TaskName=new  JLabel("Task Name ");
            JButton SelectTask=new  JButton("Select Task");
            SelectTask.setPreferredSize(new Dimension(2,2));
            SelectTask.setDisplayedMnemonicIndex(5);

            ActionListener ae = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae)
                {
               		if(dept==null)
               		{
               			JOptionPane.showMessageDialog(null, "You have not selected Department.","Alert", 1);
               		}
               		else
               		{
               			initialize();
               		}
               	}
               	public void initialize()
               	{
               		JDialog j = new JDialog(frame,"Select the Task");
               		String list[]={"Printing","Editing","Code Review","Documentation"};
               		JLabel notes=new JLabel("Notes");

               		Object display[]={"Select the Task for " + dept,new JList(list),notes
               		};

               		String des=JOptionPane.showInputDialog(null,display,"SELECT TASK",1);

               		if(des != null)
                		tasktext.setText(des);
    				else
    					JOptionPane.showMessageDialog(null, "You clicked on cancel button.","Input Box", 1);

               		};
            };
            SelectTask.addActionListener(ae);

            tasktext.setPreferredSize(new Dimension(500,60));
            tasktext.setText("I am learning Swings and I am enjoying it");
            tasktext.setEditable(false);
            task11.add(tasktext);


            task.setLayout(new GridLayout(2,2,5,5));
            task.add(ExcludetaskName);
            task.add(task1);
            task.add(TaskName);
            task.add(SelectTask);

            //Adding task,task11 Panel to Main Panel

            JPanel Main=new JPanel();
            Main.setBorder(BorderFactory.createTitledBorder("Task Selection "));
            Main.setPreferredSize(new Dimension(1000,100));
            Main.setLayout(new BorderLayout(5,5));
            Main.add(task,BorderLayout.LINE_START);
            Main.add(task11,BorderLayout.LINE_END);

        	return Main;
        }

//   	 Adding components to Buttonadd Panel

        public static JPanel addComponentsToButtonadd()
        {

            JPanel Buttonadd=new JPanel();
            JButton search=new  JButton("Search");
            search.setDisplayedMnemonicIndex(0);
            search.setBackground(java.awt.Color.green);

            JButton clear=new  JButton("Clear");
            clear.setDisplayedMnemonicIndex(1);
            clear.setBackground(java.awt.Color.green);

            JButton cancel=new  JButton("Cancel");
            cancel.setDisplayedMnemonicIndex(0);
            cancel.setBackground(java.awt.Color.green);


            ActionListener ae = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae)
                {
               		frame.dispose();
                }
            };

            cancel.addActionListener(ae);

            ActionListener ae19 = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae19)
                {

               		System.out.println("Type of Search : "+TypeOfSearchtxt);
               		System.out.println("Priority : "+Prioritytxt);
               		System.out.println("WorkOrder Status  : "+WorkOrderStatustxt);
               		System.out.println("Sub Dept  : "+dept);
               		System.out.println("RollUp CTR  : "+RollUpCTRtxt);
               		System.out.println("Windows Required  : "+WindowsRequiredtxt);
               		System.out.println("Windows Status : "+WindowsStatustxt);
               		System.out.println("WorkOrder Name : "+WorkOrderNametxt);
               		System.out.println("WorkOrder id : "+WorkOrderidtxt);
               		System.out.println("LS : "+LStxt);
               		System.out.println("BMP : "+BMPtxt);
               		System.out.println("EMP : "+EMPtxt);
               		System.out.println("AssetId : "+AssetIdtxt);
               		System.out.println("Resource Request : "+Resoucetxt);
               		System.out.println("Data Source : "+datatxt);
               		JOptionPane.showMessageDialog(null, "Values are displayed on console window","Alert", 1);

                }
            };

            search.addActionListener(ae19);

            ActionListener ae20 = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae20)
                {
               	    cbTypeOfSearch.setSelectedIndex(0);
               	    cbPriority.setSelectedIndex(0);
                    cbWorkOrderStatus.setSelectedIndex(0);
             	    cbSubDept.setSelectedIndex(0);
                    cbRollUpCTR.setSelectedIndex(0);
                    cbWindowsRequired.setSelectedIndex(0);
                    cbWindowsStatus.setSelectedIndex(0);
                    cbResourceRequest.setSelectedIndex(0);
                    cbDataSource.setSelectedIndex(0);

                    WorkOrderNameText.setText("");
                    WorkOrderIdText.setText("");
                    LSText.setText("");
                    BMPText.setText("");
                    EMPText.setText("");
                    AssetIDText.setText("");
                    AFEText.setText("1500");

                }
            };

            clear.addActionListener(ae20);

            Buttonadd.add(search);
            Buttonadd.add(clear);
            Buttonadd.add(cancel);

        	return Buttonadd;
        }

        public void actionPerformed(ActionEvent ae)
        {

        }

        public static void main(String[] args)
        {

                //Create and set up the content pane.

                JPanel workOrderDetails=new JPanel();
                JPanel LocationAndSource=new JPanel();
                JPanel TextSearch=new JPanel();
                JPanel date=new JPanel();
                JPanel AssignedGang=new JPanel();
                JPanel category=new JPanel();
                JPanel status=new JPanel();
                JPanel Main=new JPanel();
                JPanel Buttonadd=new JPanel();

                workOrderDetails=addComponentsToworkOrderDetails();

                LocationAndSource=addComponentsToLocationAndSource();

                TextSearch=addComponentsToTextSearch();

                date=addComponentsTodate();

                AssignedGang=addComponentsToAssignedGang();

                category=addComponentsTocategory();

                status=addComponentsTostatus();

                Main=addComponentsToMain();

                Buttonadd=addComponentsToButtonadd();


               //Adding workOrderDetails,LocationAndSource panel
               // to first Panel

                JPanel first=new JPanel();

                first.setLayout(new BorderLayout());
                first.add(workOrderDetails,BorderLayout.LINE_START);
                first.add(LocationAndSource,BorderLayout.LINE_END);

                // Adding TextSearch,date panel
                // to third Panel

                JPanel third=new JPanel();

                third.setLayout(new BorderLayout());
                third.add(TextSearch,BorderLayout.LINE_START);
                third.add(date,BorderLayout.LINE_END);

                // Adding category,Main,AssignedGang,status,
                // Buttonadd panel to third Panel

                JPanel second=new JPanel();

                second.setLayout(new BorderLayout(5,5));
                second.add(category,BorderLayout.CENTER);
                second.add(Main,BorderLayout.NORTH);
                second.add(AssignedGang,BorderLayout.WEST);
                second.add(status,BorderLayout.EAST);
                second.add(Buttonadd,BorderLayout.SOUTH);

                // Adding first,second,third
                // panel to last Panel

                JPanel last=new JPanel();
                JPanel main=new JPanel();

                last.setLayout(new BorderLayout(5,5));
                last.add(first,BorderLayout.PAGE_START);
                last.add(third,BorderLayout.CENTER);
                last.add(second,BorderLayout.PAGE_END);
                main.add(last);

                frame.setBackground(java.awt.Color.yellow);
                frame.add(main);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);

        }
}