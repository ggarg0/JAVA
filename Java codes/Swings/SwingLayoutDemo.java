import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingLayoutDemo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingLayoutDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();
      //swingLayoutDemo.showGridBagLayoutDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(300,300);
      mainFrame.setLayout(new GridLayout(1, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });

          JPanel panel = new JPanel();

	       panel.setSize(400,400);
	       GridBagLayout layout = new GridBagLayout();
	       panel.setLayout(layout);
	       GridBagConstraints gbc = new GridBagConstraints();

	       gbc.fill = GridBagConstraints.HORIZONTAL;
	       gbc.gridx = 0;
	       gbc.gridy = 0;
	       gbc.insets = new Insets(20, 50, 20, 20);
	       panel.add(new JButton("Button 1"),gbc);


	  	  GridBagConstraints gbc1 = new GridBagConstraints();
	       gbc1.gridx = 10;
	       gbc1.gridy = 0;
 		   gbc1.fill = GridBagConstraints.VERTICAL;
	       gbc1.insets = new Insets(20, 50, 20, 20);
	       gbc1.anchor = GridBagConstraints.CENTER;
	       panel.add(new JButton("Button2"),gbc1);

	  GridBagConstraints gbc2 = new GridBagConstraints();
	       gbc2.fill = GridBagConstraints.HORIZONTAL;
	       gbc2.gridx = 0;
	       gbc2.gridy = 20;
	       gbc2.insets = new Insets(20, 50, 20, 20);
	       panel.add(new JButton("Button 3"),gbc2);

	    GridBagConstraints gbc3 = new GridBagConstraints();
	       gbc3.gridx = 20;
	       gbc3.gridy = 20;
	       gbc3.insets = new Insets(20, 50, 20, 20);
	       panel.add(new JButton("Button 4"),gbc3);



	       mainFrame.add(panel);


 //     mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
 }

