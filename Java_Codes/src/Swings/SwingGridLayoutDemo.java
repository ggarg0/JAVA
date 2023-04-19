package Swings;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingGridLayoutDemo {
   private static JFrame mainFrame;
   private static JLabel headerLabel;
   private static JLabel statusLabel;
   private static JPanel controlPanel;
   private static JLabel msglabel;


   public static void main(String[] args){
	     mainFrame = new JFrame("Java SWING Examples");
	         mainFrame.setSize(600,600);

	         /*mainFrame.setLayout(new GridLayout(3, 1));

	         headerLabel = new JLabel("",JLabel.CENTER );
	         statusLabel = new JLabel("Status",JLabel.CENTER);
	         statusLabel.setSize(500,100);*/

	         mainFrame.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent windowEvent){
	               System.exit(0);
	            }
	         });
	         controlPanel = new JPanel();
	         controlPanel.setLayout(new FlowLayout());

	       //  mainFrame.add(headerLabel);
	         mainFrame.add(showGridLayoutDemo());
	        // mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
      SwingGridLayoutDemo swingLayoutDemo = new SwingGridLayoutDemo();
      //swingLayoutDemo.showGridLayoutDemo();
   }

   private static JPanel showGridLayoutDemo(){
       JPanel panel = new JPanel();

      //panel.setSize(900,900);
      GridLayout layout = new GridLayout(4,1);
      layout.setHgap(50);
      layout.setVgap(50);

      panel.setLayout(layout);
      panel.add(new JButton("Button 1"));
      panel.add(new JButton("Button 2"));
      panel.add(new JButton("Button 3"));
      panel.add(new JButton("Button 4"));
      panel.add(new JButton("Button 5"));

      return panel;
   }
}