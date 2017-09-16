import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalIconFactory;

public class ToolBar {
  public static void main(String args[]) {
	JFrame f = new JFrame("JToolBar Sample");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JToolBar toolbar = new JToolBar();
	Icon icon = MetalIconFactory.getFileChooserDetailViewIcon();
	JToggleButton button = new JToggleButton(icon);
	toolbar.add(button);
	icon = MetalIconFactory.getFileChooserHomeFolderIcon();
	button = new JToggleButton(icon);
	toolbar.add(button);
	icon = MetalIconFactory.getFileChooserListViewIcon();
	button = new JToggleButton(icon);
	toolbar.add(button);
	f.getContentPane().add(toolbar, BorderLayout.NORTH);
	f.setSize(300, 100);
	f.setVisible(true);
  }
}
