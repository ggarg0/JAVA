import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DialogExample {
    private static JDialog dialog;
    DialogExample() {
        JFrame f= new JFrame();
        dialog = new JDialog(f , "Dialog Example", true);
        dialog.setLayout( new FlowLayout() );
        JButton b = new JButton ("OK");
         b.setPreferredSize(new Dimension(100, 100));
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                DialogExample.setVisible(false);
            }
        });
        dialog.add( new JLabel ("Click button to continue."));
        dialog.add(b);
        dialog.setSize(300,300);
       dialog.setVisible(true);
    }
    public static void main(String args[])
    {
        new DialogExample();
    }
}