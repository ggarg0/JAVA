package Swings;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class SliderMajorTickSpacing {
  public static void main(String args[]) {
	JFrame f = new JFrame("JSlider");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JSlider slider = new JSlider();
	slider.setMinorTickSpacing(2);
	slider.setMajorTickSpacing(10);
	slider.setPaintTicks(true);
	slider.setSnapToTicks(true);
	slider.setPaintTrack(false);
	slider.setPaintLabels(true);
	f.getContentPane().add(slider, BorderLayout.CENTER);
	f.setSize(300, 100);
	f.setVisible(true);
  }
}
