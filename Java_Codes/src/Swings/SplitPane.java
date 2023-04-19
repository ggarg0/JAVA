package Swings;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class SplitPane {
  public static void main(String args[]) throws Exception {
	JFrame vFrame = new JFrame("Vertical Split");
	vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JComponent leftButton = new JButton("Left");
	JComponent rightButton = new JButton("Right");
	final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	splitPane.setOneTouchExpandable(true);
	splitPane.setLeftComponent(leftButton);
	splitPane.setRightComponent(rightButton);
    
	ActionListener oneActionListener = new ActionListener() {
	  public void actionPerformed(ActionEvent event) {
		splitPane.resetToPreferredSizes();
	  }
	};
	((JButton) rightButton).addActionListener(oneActionListener);
    
	ActionListener anotherActionListener = new ActionListener() {
	  public void actionPerformed(ActionEvent event) {
		splitPane.setDividerLocation(10);
		splitPane.setContinuousLayout(true);
	  }
	};
    
	((JButton) leftButton).addActionListener(anotherActionListener);

	HierarchyListener hierarchyListener = new HierarchyListener() {
	  public void hierarchyChanged(HierarchyEvent e) {
		long flags = e.getChangeFlags();
		if ((flags & HierarchyEvent.SHOWING_CHANGED) == HierarchyEvent.SHOWING_CHANGED) {
		  splitPane.setDividerLocation(.75);
		}
	  }
	};
	splitPane.addHierarchyListener(hierarchyListener);

	vFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
	vFrame.setSize(300, 150);
	vFrame.setVisible(true);
  }

}
