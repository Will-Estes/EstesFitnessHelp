package com.estesfitnesshelp.view.weightlogjframe;

import com.estesfitnesshelp.model.domain.WeightLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estesfitnesshelp.model.business.manager.EstesFitnessHelpManager;

public class StoreWeightLogJFrameController implements ActionListener{

	private StoreWeightLogJFrame SWLJFrame;
	
	public StoreWeightLogJFrameController(){
		
	}
	
	public StoreWeightLogJFrameController(StoreWeightLogJFrame SWLJFrame){
		this.SWLJFrame = SWLJFrame;
		SWLJFrame.getSaveWLogButton().addActionListener(this);
		SWLJFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equalsIgnoreCase("Save Log")){
			getSaveWLogButton_actionPerformed(e);
		}
		
	}

	private void getSaveWLogButton_actionPerformed(ActionEvent e){
		WeightLog weightLog = SWLJFrame.getSelectedData();
		EstesFitnessHelpManager EHelpM = EstesFitnessHelpManager.getInstance();
		if (EHelpM != null) {
			boolean action = EHelpM.performWeightLogAction("LogWorkout", weightLog);
			if (action) {
				SWLJFrame.setVisible(false);
				SWLJFrame.dispose();
			}
		}
	}
}
