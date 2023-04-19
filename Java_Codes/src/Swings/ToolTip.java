package Swings;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;

public class ToolTip {

  public static void main(String args[]) {
	JFrame frame = new JFrame("Tooltip");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new JPanel();
	panel.setToolTipText("<HtMl>Tooltip<br>Message");
	frame.getContentPane().add(panel, BorderLayout.CENTER);

	JButton button = new JButton("Hello, World") {
	  public JToolTip createToolTip() {
		JToolTip tip = super.createToolTip();
		tip.setBackground(Color.lightGray);
		tip.setForeground(Color.black);
		return tip;
	  }

	  public boolean contains(int x, int y) {
		if (x < 100) {
		  setToolTipText("ToolTip Display (x < 100)");
		} else {
		  setToolTipText("ToolTip Display(else)");
		}
		return super.contains(x, y);
	  }
	};
    
	button.setToolTipText("Hello, World");
	frame.getContentPane().add(button, BorderLayout.NORTH);

	frame.setSize(300, 150);
	frame.setVisible(true);
  }
}
