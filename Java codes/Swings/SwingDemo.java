import java.awt.*;
import javax.swing.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class SwingDemo  implements ActionListener
{
	public static void main(String a[])
	{
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container contentPane=f.getContentPane();
JPanel contentPane=new JPanel();
		JButton but=new JButton("Start");
		JLabel lab=new JLabel("Label");
		lab.setBorder(BorderFactory.createLineBorder(Color.RED,5));
		JTextField box=new JTextField("MINE");
		box.setEnabled(false);


            ActionListener ae = new ActionListener()
            {
               	public void actionPerformed(ActionEvent ae)
                {
               		box.setEnabled(true);
                }
            };

            but.addActionListener(ae);


contentPane.setBorder(BorderFactory.createTitledBorder("title"));
	contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	contentPane.add(but);
	contentPane.add(lab);
	contentPane.add(box);

f.add(contentPane);
f.pack();
		f.setVisible(true);
		f.setSize(600,600);
	}
}