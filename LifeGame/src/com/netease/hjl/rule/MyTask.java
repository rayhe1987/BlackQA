package com.netease.hjl.rule;

import javax.swing.JPanel;

public class MyTask extends java.util.TimerTask{
    private JPanel panel;
	public MyTask(JPanel contentPane) {
		this.panel = contentPane;
	}
	@Override
	public void run() {
		GameRule.getNextStatus();
		panel.updateUI();
	}

}
