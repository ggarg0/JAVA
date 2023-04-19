package Swings;
import java.awt.Event;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class RadioButtonMenuItem extends JFrame {

  public RadioButtonMenuItem() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	setJMenuBar(menuBar);

	JMenu fileMenu = new JMenu("File");
	JMenu elementMenu = new JMenu("Elements");
	fileMenu.setMnemonic('F');
	elementMenu.setMnemonic('E');

	// Construct the file pull down menu
	newItem = fileMenu.add("New");
	openItem = fileMenu.add("Open");
	closeItem = fileMenu.add("Close");
	fileMenu.addSeparator();
	saveItem = fileMenu.add("Save");
	saveAsItem = fileMenu.add("Save As...");

	JMenu colorMenu = new JMenu("Color");

	fileMenu.addSeparator();
	printItem = fileMenu.add("Print");

	newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
	openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
	saveItem.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK));
	printItem.setAccelerator(KeyStroke.getKeyStroke('P', Event.CTRL_MASK));

	elementMenu.add(lineItem = new JRadioButtonMenuItem("Line", true));
	elementMenu
		.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", false));
	elementMenu.add(circleItem = new JRadioButtonMenuItem("Circle", false));
	elementMenu.add(curveItem = new JRadioButtonMenuItem("Curve", false));
	ButtonGroup types = new ButtonGroup();
	types.add(lineItem);
	types.add(rectangleItem);
	types.add(circleItem);
	types.add(curveItem);

	lineItem.setAccelerator(KeyStroke.getKeyStroke('L', Event.CTRL_MASK));
	rectangleItem.setAccelerator(KeyStroke.getKeyStroke('E', Event.CTRL_MASK));
	circleItem.setAccelerator(KeyStroke.getKeyStroke('I', Event.CTRL_MASK));
	curveItem.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));

	elementMenu.addSeparator();

	elementMenu.add(colorMenu); // Add the sub-menu
	colorMenu.add(redItem = new JCheckBoxMenuItem("Red", false));
	colorMenu.add(yellowItem = new JCheckBoxMenuItem("Yellow", false));
	colorMenu.add(greenItem = new JCheckBoxMenuItem("Green", false));
	colorMenu.add(blueItem = new JCheckBoxMenuItem("Blue", true));

	// Add element color accelerators
	redItem.setAccelerator(KeyStroke.getKeyStroke('R', Event.CTRL_MASK));
	yellowItem.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK));
	greenItem.setAccelerator(KeyStroke.getKeyStroke('G', Event.CTRL_MASK));
	blueItem.setAccelerator(KeyStroke.getKeyStroke('B', Event.CTRL_MASK));

	menuBar.add(fileMenu);
	menuBar.add(elementMenu);
  }

  private JMenuBar menuBar = new JMenuBar();

  // File menu items
  private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem,
	  printItem;

  // Element menu items
  private JRadioButtonMenuItem lineItem, rectangleItem, circleItem, curveItem,
	  textItem;

  private JCheckBoxMenuItem redItem, yellowItem, greenItem, blueItem;

  public static void main(String[] args) {
	JFrame aWindow = new RadioButtonMenuItem();
	aWindow.setSize(200,200);
	aWindow.setVisible(true);
  }
}
