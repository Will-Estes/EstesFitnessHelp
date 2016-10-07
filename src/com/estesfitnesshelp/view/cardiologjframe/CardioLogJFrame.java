package com.estesfitnesshelp.view.cardiologjframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.estesfitnesshelp.model.domain.CardioLog;

public class CardioLogJFrame extends JInternalFrame {

	/**
	 * This creates the view for the Cardio Log entry form. It has methods that call
	 * the CardioLogJFrameController for processing requests 
	 */
	private static final long serialVersionUID = 625482843793371828L;

	JPanel jPanel1;
	JLabel jLabelMins, jLabelSecs;
	JTextField jTextFieldMins, jTextFieldSecs;
	JButton jButtonSaveCLog;
	
	public CardioLogJFrame() {
		super("Store Cardio Log");
		initiateComponents();
		this.add(jPanel1);
		this.setBounds(0, 0, 600, 550);
		this.setVisible(true);
		this.pack();
		this.setClosable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.out.println("CardioLogJFrame initialized");
	}
	
	private void initiateComponents() {
		
		jPanel1 = new JPanel();
		jLabelMins = new JLabel();
		jTextFieldMins = new JTextField();
		jLabelSecs = new JLabel();
		jTextFieldSecs = new JTextField();
		jButtonSaveCLog = new JButton();
		jPanel1.setName("Cardio Log Entry");
		jPanel1.setLayout(null);
		jPanel1.setBackground(new Color(200, 50, 50));
		
		jLabelMins.setText("Mins: ");
		jLabelMins.setBounds(25, 25, 100, 50);
		jTextFieldMins.setText("30");
		jTextFieldMins.setBounds(80, 40, 25, 25);
		
		
		jLabelSecs.setText("Secs: ");
		jLabelSecs.setBounds(25, 60, 100, 50);
		jTextFieldSecs.setText("30");
		jTextFieldSecs.setBounds(80, 75, 25, 25);
		
		jButtonSaveCLog.setText("Save Log");
		jButtonSaveCLog.setBounds(40, 150, 100, 25);
		jButtonSaveCLog.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jButtonSaveCLogActionPerformed(e);
		  }
		});
		
		jPanel1.add(jLabelMins);
		jPanel1.add(jTextFieldMins);
		jPanel1.add(jLabelSecs);
		jPanel1.add(jTextFieldSecs);
		jPanel1.add(jButtonSaveCLog);
		jPanel1.setBounds(5, 5, 500, 550);

	}

	private void jButtonSaveCLogActionPerformed(ActionEvent e) {
		CardioLogJFrameController CLJFrameC = new CardioLogJFrameController(this);
		CLJFrameC.actionPerformed(e);
		this.dispose();
	}
	
	//This sifts through the entries to validate correct data was input
	//then creates a new CardioLog object
	public CardioLog getSelectedData() {
		CardioLog cLog = null;
		try {
			cLog = new CardioLog(Integer.parseInt(jTextFieldMins.getText()),
								 Integer.parseInt(jTextFieldSecs.getText()));
		} catch (NumberFormatException nfm) {
			System.out.println("Numbers formatted incorrectly. Please review entries");
		} finally {
			if (cLog == null) {
				System.out.println("Error: Cardio Log must be completely filled out");
			}
		}
		
		return cLog;
	}
	
	public JButton getStoreCLogButton() {
		return jButtonSaveCLog;
		
	}
	
}
