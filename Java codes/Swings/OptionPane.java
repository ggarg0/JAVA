import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class OptionPane {

  public static void main(String[] a) {
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("Set Message");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    optionPane.setOptions(new Object[] {new JButton("Button")});
    JDialog dialog = optionPane.createDialog(null, "Icon/Text Button");
    dialog.setVisible(true);
  }
}
