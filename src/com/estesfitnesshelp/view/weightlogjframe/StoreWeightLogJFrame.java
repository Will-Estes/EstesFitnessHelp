package com.estesfitnesshelp.view.weightlogjframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.estesfitnesshelp.model.domain.WeightLog;

public class StoreWeightLogJFrame extends JInternalFrame{

	private static final long serialVersionUID = 7750452209025354283L;

	JPanel jPanel1;
	JLabel jLabelSets, jLabelReps, jLabelWeight;
	JTextField jTextFieldSets, jTextFieldReps, jTextFieldWeight;
	JButton jButtonSaveWLog;
	
	public StoreWeightLogJFrame() {
		super("Store Weight Log");
		initiateComponents();
		this.add(jPanel1);
		this.setBounds(0, 0, 505, 505);
		this.setVisible(true);
		this.pack();
		this.setClosable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.out.println("StoreWeightLogJFrame initialized");
	}
	private void initiateComponents(){
		
		jPanel1 = new JPanel();
		jLabelSets = new JLabel();
		jTextFieldSets = new JTextField();
		jLabelReps = new JLabel();
		jTextFieldReps = new JTextField();
		jLabelWeight = new JLabel();
		jTextFieldWeight = new JTextField();
		jButtonSaveWLog = new JButton();
		jPanel1.setName("Weight Log Entry");
		jPanel1.setLayout(null);
		jPanel1.setBackground(new Color(255, 50, 50));
		
		jLabelSets.setText("Sets: ");
		jLabelSets.setBounds(25, 25, 100, 50);
		jTextFieldSets.setText("3");
		jTextFieldSets.setBounds(80, 40, 25, 25);
		
		
		jLabelReps.setText("Reps: ");
		jLabelReps.setBounds(25, 60, 100, 50);
		jTextFieldReps.setText("10");
		jTextFieldReps.setBounds(80, 75, 25, 25);
		
		jLabelWeight.setText("Weight: ");
		jLabelWeight.setBounds(25, 110, 50, 25);
		jTextFieldWeight.setText("225");
		jTextFieldWeight.setBounds(80, 110, 30, 25);
		
		jButtonSaveWLog.setText("Save Log");
		jButtonSaveWLog.setBounds(40, 150, 100, 25);
		jButtonSaveWLog.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jButtonSaveWLogActionPerformed(e);
		}
		});
		
		jPanel1.add(jLabelSets);
		jPanel1.add(jTextFieldSets);
		jPanel1.add(jLabelReps);
		jPanel1.add(jTextFieldReps);
		jPanel1.add(jLabelWeight);
		jPanel1.add(jTextFieldWeight);
		jPanel1.add(jButtonSaveWLog);
		jPanel1.setBounds(5, 5, 500, 550);
		
	}
	
	private void jButtonSaveWLogActionPerformed(ActionEvent e){
		StoreWeightLogJFrameController SWLJFrameC = new StoreWeightLogJFrameController(this);
		SWLJFrameC.actionPerformed(e);
		this.dispose();
	}
	
	public WeightLog getSelectedData(){
		WeightLog weightLog = null;
		try {
			weightLog = new WeightLog(Integer.parseInt(jTextFieldSets.getText()),
									  Integer.parseInt(jTextFieldReps.getText()),
								   	  Double.parseDouble(jTextFieldWeight.getText()));
		} catch (NumberFormatException nfm){
			System.out.println("Numbers formatted incorrectly. Please review entries");
		}
		finally {
			if (weightLog == null){
				System.out.println("Error: Weight Log must be completely filled in");
			}
		}
		return weightLog;
	}
	public JButton getSaveWLogButton(){
		return jButtonSaveWLog;
	}
}
