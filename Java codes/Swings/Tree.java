package Swings;
import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Tree {
  public static void main(String args[]) {
	JFrame frame = new JFrame("Swing Package Hierarchy");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Vector rootVector = new TreeVector("A", new String[] { "border","colorchooser","event","filechooser","plaf","table" });
	JTree tree = new JTree(rootVector);
	tree.setRootVisible(true);
	TreeModel model = tree.getModel();
	model.valueForPathChanged(new TreePath(model.getRoot()), "javax.swing");
	((DefaultTreeModel) model).reload();

	JScrollPane scrollPane = new JScrollPane(tree);
	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	frame.setSize(300, 300);
	frame.setVisible(true);
  }
}

class TreeVector extends Vector {
  String name;

  TreeVector(String name) {
	this.name = name;
  }

  TreeVector(String name, Object elements[]) {
	this.name = name;
	for (int i = 0, n = elements.length; i < n; i++) {
	  add(elements[i]);
	}
  }

  public String toString() {
	return name;
  }
}
