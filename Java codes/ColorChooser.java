import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser {

  public static void main(String[] a) {
	JFrame frame = new JFrame("JColorChooser Popup");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	final JLabel label = new JLabel("Color Chooser", JLabel.CENTER);
	label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
	frame.getContentPane().add(label, BorderLayout.SOUTH);

	final JColorChooser colorChooser = new JColorChooser(label.getBackground());
	colorChooser.setBorder(BorderFactory.createTitledBorder("Pick the Color! "));

	ColorSelectionModel model = colorChooser.getSelectionModel();
	ChangeListener changeListener = new ChangeListener() {
	  public void stateChanged(ChangeEvent changeEvent) {
		Color newForegroundColor = colorChooser.getColor();
		label.setForeground(newForegroundColor);
	  }
	};
	model.addChangeListener(changeListener);
	frame.getContentPane().add(colorChooser, BorderLayout.CENTER);

	frame.pack();
	frame.setVisible(true);
  }

}
