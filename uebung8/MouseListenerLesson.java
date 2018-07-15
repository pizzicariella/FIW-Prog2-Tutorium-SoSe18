package uebung8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseListenerLesson extends JFrame implements MouseListener, ComponentListener{
	int rows;
	int cols;
	JPanel mainPanel;
	JLabel info;
	JPanel[][] subPanel;
	int subPanelBreite, subPanelHoehe;
	
	public MouseListenerLesson(int rows, int cols) {
		super("MouseListener Lesson");
		this.rows=rows;
		this.cols=cols;
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainPanel=init();
		this.add(mainPanel, BorderLayout.CENTER);
		this.info=new JLabel("Click on Panel to get more Info");
		this.add(info, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private JPanel init() {
		JPanel panel = new JPanel();
		fillSubPanels();
		panel.setLayout(new GridLayout(rows,cols));
		for(int i = 0; i<this.subPanel.length;i++) {
			for(int j = 0; j<this.subPanel[i].length;j++) {
				panel.add(this.subPanel[i][j]);
			}
		}
		panel.addMouseListener(this);
		panel.addComponentListener(this);
		return panel;
	}
	
	private void fillSubPanels() {
		this.subPanel= new JPanel[rows][cols];
		for(int i = 0; i<this.subPanel.length;i++) {
			for(int j = 0; j<this.subPanel[i].length;j++) {
				JPanel subPanel = new JPanel();
				subPanel.setBackground(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
				this.subPanel[i][j]=subPanel;
			}
		}
	}

	public static void main(String[] args) {
		new MouseListenerLesson(4,3);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		Object source = me.getSource();
		if(source instanceof JPanel) {
			int gesamtBreite = mainPanel.getWidth();
			int gesamtHoehe = mainPanel.getHeight();
			int breiteProPanel = gesamtBreite/cols;
			int hoeheProPanel = gesamtHoehe/rows;
			int clickedCol = me.getX()/breiteProPanel;
			int clickedRow = me.getY()/hoeheProPanel;
			subPanel[clickedRow][clickedCol].setBackground(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
			info.setText("(w,h) = ("+breiteProPanel+" ,"+hoeheProPanel+") --> (x,y) = ("+me.getX()+" ,"+me.getY()+
					") --> (r,c) = ("+clickedRow+" ,"+clickedCol+")");
			this.subPanelBreite=breiteProPanel;
			this.subPanelHoehe=hoeheProPanel;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent ce) {
		Object source = ce.getSource();
		if(source instanceof JPanel) {
			int gesamtBreite = mainPanel.getWidth();
			int gesamtHoehe = mainPanel.getHeight();
			int breiteProPanel = gesamtBreite/cols;
			int hoeheProPanel = gesamtHoehe/rows;
			if(info.getText().contains(String.valueOf(this.subPanelBreite))) {
				info.setText(info.getText().replace(String.valueOf(this.subPanelBreite), String.valueOf(breiteProPanel))
						.replace(String.valueOf(this.subPanelHoehe), String.valueOf(hoeheProPanel)));
			}
			else {
				info.setText("(w,h) = ("+breiteProPanel+" ,"+hoeheProPanel+") !Click on Panel to get more Info!");
			}
			this.subPanelBreite=breiteProPanel;
			this.subPanelHoehe=hoeheProPanel;
		}
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
