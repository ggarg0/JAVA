package Swings;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class ProgressBar {
  public static void main(String args[]) {
	JFrame f = new JFrame("JProgressBar");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JProgressBar progressBar = new JProgressBar();
	progressBar.setValue(75);
	progressBar.setStringPainted(true);
	Border border = BorderFactory.createTitledBorder("Loading...");
	progressBar.setBorder(border);
	f.getContentPane().add(progressBar, BorderLayout.NORTH);
	f.setSize(300, 100);
	f.setVisible(true);
  }
}
