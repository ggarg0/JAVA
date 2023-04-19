package Swings;
import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table {
  public static void main(String args[]) {
	String rows[][] = { { "A", "a" }, { "B", "b" }, { "E", "e" } };
	String headers[] = { "Upper", "Lower" };

	JComboBox comboBox = new JComboBox(rows[0]);
	comboBox.setMaximumRowCount(4);
    
	TableCellEditor editor = new DefaultCellEditor(comboBox);

	JFrame frame = new JFrame("JTable");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JTable table = new JTable(new DefaultTableModel(rows, headers));

	table.getColumnModel().getColumn(1).setCellEditor(editor);

	JScrollPane scrollPane = new JScrollPane(table);
	frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	frame.setSize(300, 150);
	frame.setVisible(true);
  }
}
