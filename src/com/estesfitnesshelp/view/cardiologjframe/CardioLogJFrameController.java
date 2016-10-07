package com.estesfitnesshelp.view.cardiologjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estesfitnesshelp.model.business.manager.EstesFitnessHelpManager;
import com.estesfitnesshelp.model.domain.CardioLog;

public class CardioLogJFrameController implements ActionListener{

	private CardioLogJFrame CLJFrame;
	
	public CardioLogJFrameController() {
	}
	
	//Implement the CardioLog JFrame
	public CardioLogJFrameController(CardioLogJFrame CLJFrame) {
		this.CLJFrame = CLJFrame;
		CLJFrame.getStoreCLogButton().addActionListener(this);
		CLJFrame.setVisible(true);
	}
	
	//Check action
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equalsIgnoreCase("Save Log")){
			getSaveCLogButton_actionPerformed(e);
		}
	}
	
	//Perform the action for saving a cardio log
	private void getSaveCLogButton_actionPerformed(ActionEvent e) {
		CardioLog cardioLog = CLJFrame.getSelectedData();
		EstesFitnessHelpManager EHelpM = EstesFitnessHelpManager.getInstance();
		if (EHelpM != null){
			boolean action = EHelpM.performCardioLogAction("SaveCLog", cardioLog);
			if (action){
				CLJFrame.setVisible(false);
				CLJFrame.dispose();
			}
		}
	}
}
