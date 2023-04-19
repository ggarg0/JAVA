package Swings;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A Java class to demonstrate how to put a scrolling text area
 * in a JOptionPane showMessageDialog dialog.
 *
 * Steps are simple - Just create a JTextArea, wrap it in a
 * JScrollPane, and then add the JScrollPane to the showMessageDialog.
 */
public class ShowMessageDialogWithScrollpane implements Runnable
{
  private JFrame frame = new JFrame("My JFrame Example");
  private String longMessage = "test";

  public static void main(String[] args)
  {
    ShowMessageDialogWithScrollpane example = new ShowMessageDialogWithScrollpane();
    SwingUtilities.invokeLater(example);
  }

  public void run()
  {
    // start building a jframe
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(450, 300));

    // add a button to the jframe
    JButton button = new JButton("Click Me");
    button.addActionListener(new ShowDialogListener());
    frame.getContentPane().add(button);

    // display the jframe
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  /**
   * Our button listener. Show a scrolling text area in a
   * JOptionPane showMessageDialog dialog.
   */
  class ShowDialogListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      // create a JTextArea
      JTextArea textArea = new JTextArea(50, 25);

      textArea.setText(longMessage);
      textArea.setEditable(false);


      // wrap a scrollpane around it
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setMinimumSize(new Dimension(500, 500));

      // display them in a message dialog
      JOptionPane.showMessageDialog(frame, scrollPane);



    }
  }
}