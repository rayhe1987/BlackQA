package com.netease.hjl.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.netease.hjl.rule.GameRule;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	int averageWidth = 0;
	
	public MyPanel() {
		super();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Point point = arg0.getPoint();
				int i = point.x/averageWidth;
				int j = point.y/averageWidth;
				System.out.println(i);
				System.out.println(j);
				GameRule.matrix[i][j] = true;
				updateUI();
			}
		});
		setOpaque(false); // we don't paint all our bits
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public Dimension getPreferredSize() {
		// Figure out what the layout manager needs and
		// then add 100 to the largest of the dimensions
		// in order to enforce a 'round' bullseye 
		/*    	the use of "super." is very important, 
    	  because otherwise the JRE will throw a StackOverflowError.
    	  And because of the JFrame.pack() used above, 
    	  the JFrame window will be resized to adapter the Container size.*/
		Dimension layoutSize = super.getPreferredSize();
		int max = Math.max(layoutSize.width,layoutSize.height);
		return new Dimension(max+100,max+100);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Dimension size = getSize();
		System.out.println(size.width);
		System.out.println(size.height);
		int len = size.width >= size.height ? size.height : size.width;
		this.averageWidth = (len-10)/GameRule.NUM;
		for (int i = 0; i <= GameRule.NUM; i++) {
			int x1 = averageWidth*i;
			g.drawLine(x1, 0, x1, averageWidth*GameRule.NUM);
		}
		for (int i = 0; i <= GameRule.NUM; i++) {
			int y1 = averageWidth*i;
			g.drawLine(0, y1, averageWidth*GameRule.NUM, y1);
		}
		for (int i = 0; i < GameRule.NUM; i++) {
			int x = averageWidth*i;
			for (int j = 0; j < GameRule.NUM; j++) {
				int y = averageWidth*j;
				if (GameRule.matrix[i][j]) {
					g.setColor(Color.green); 
					g.fillRect(x, y, averageWidth, averageWidth);
				}
				
			}
		}
	}

}
