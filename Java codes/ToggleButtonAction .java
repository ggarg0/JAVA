import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class ToggleButtonAction {
  public static void main(String[] args) {
	JToggleButton jtb = new JToggleButton("Click Me");
	jtb.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent ev) {
		System.out.println("I am a Toggle button");
	  }
	});
	JFrame f = new JFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = f.getContentPane();
	c.setLayout(new FlowLayout());
	c.add(jtb);
	f.pack();
	f.setVisible(true);
  }
}
