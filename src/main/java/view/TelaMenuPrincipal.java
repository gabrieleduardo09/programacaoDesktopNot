package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaMenuPrincipal {

	private JFrame frame;
	private JTable table;
	private JLabel lbl;
	private JTextField txt;

	public TelaMenuPrincipal() {

//		String[] opcoes = {"Opçôes", "1", "2"};
//		frame = new JFrame();
//		frame.setTitle("Menu Principal");
//		table = new JTable(opcoes);
//		JScrollPane sp = new JScrollPane(table);
//		frame.add(sp);
		// table.setBounds(30, 0, 0, 0);
		
		String[] columnNames = { "Name", "Address", "Email" };
		
		frame = new JFrame();
		frame.setTitle("JTableExample");
		
		lbl = new JLabel("1");
		lbl.setBounds(10, 10, 10, 10);
		txt = new JTextField("Opções");
		
		
		txt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(txt);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int frameWidth = 500;
		int frameHeight = 200;
		frame.setSize(frameWidth, frameHeight);
		int locationX = (int) (width - frameWidth) / 2;
		int locationY = (int) (height - frameHeight) / 2;
		frame.setLocation(locationX, locationY);

		frame.setVisible(true);

	}

}
