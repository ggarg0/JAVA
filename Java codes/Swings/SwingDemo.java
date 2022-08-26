package Swings;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}