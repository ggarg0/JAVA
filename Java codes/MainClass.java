import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MainClass {
  public static void main(String args[]) throws Exception {
    JFrame frame = new JFrame("");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel dogLabel = new JLabel("www.java2s.com");
    JScrollPane scrollPane = new JScrollPane();
    //scrollPane.setViewportView(dogLabel);
   scrollPane.getViewport().setView(dogLabel);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

}
