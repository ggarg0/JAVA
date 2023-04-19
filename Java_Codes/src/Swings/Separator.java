package Swings;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Separator {
	public static void main(String args[]) {
		JFrame f = new JFrame("JSeparator Sample");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new GridLayout(0, 1));
		JLabel above = new JLabel("Above Separator");
		f.getContentPane().add(above);
		JSeparator separator = new JSeparator();
		f.getContentPane().add(separator);
		JLabel below = new JLabel("Below Separator");
		f.getContentPane().add(below);
		f.setSize(300, 100);
		f.setVisible(true);
	}
}
