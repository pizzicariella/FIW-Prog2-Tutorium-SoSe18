package aufgabe5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstGui extends JFrame implements ActionListener{
	
	JTextField display;
	JPanel buttonPanel;
	
	public FirstGui() {
		super("Aufgabe 5");
		this.setSize(200, 250);
		this.setLocation(500, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.display=new JTextField(12);
		this.display.setPreferredSize(new Dimension(180, 30));
		this.buttonPanel=buttonPanel();
		this.getContentPane().add(this.display, BorderLayout.NORTH);
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private JPanel buttonPanel() {
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(5,2,10,10));
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bPanel.add(b0);
		bPanel.add(b1);
		bPanel.add(b2);
		bPanel.add(b3);
		bPanel.add(b4);
		bPanel.add(b5);
		bPanel.add(b6);
		bPanel.add(b7);
		bPanel.add(b8);
		bPanel.add(b9);
		return bPanel;
	}

	public static void main(String[] args) {
		new FirstGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof JButton) {
			JButton pressed = (JButton)source;
			this.display.setText(pressed.getText());
		}
	}

}
