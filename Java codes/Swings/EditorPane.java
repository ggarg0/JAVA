package Swings;
import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class EditorPane {
  public static void main(String args[]) {
    JFrame f = new JFrame("JEditorPane");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JEditorPane editor = new JEditorPane(
        "text/html",
        "<center><H3>Java Swing</H3><u>JEditorPane</u><br><br>HTML Document</center>");
    editor.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(editor);
    f.getContentPane().add(scrollPane, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);
  }
}
