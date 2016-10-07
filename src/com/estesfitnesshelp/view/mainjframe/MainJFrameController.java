package com.estesfitnesshelp.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.estesfitnesshelp.view.cardiologjframe.CardioLogJFrame;
import com.estesfitnesshelp.view.weightlogjframe.StoreWeightLogJFrame;

/*
 * This provides the controller logic for the MainJFrame. This will direct requests
 * to the appropriate JFrames for further processing.
 * */

public class MainJFrameController implements ActionListener{

	private MainJFrame desktopFrame;
	
	public MainJFrameController(){
		
	}
	
	//Add action listener to buttons
	public MainJFrameController(MainJFrame desktopFrame){
		this.desktopFrame = desktopFrame;	
		desktopFrame.getCreateWLogButton().addActionListener(this);
		desktopFrame.getCreateCLogButton().addActionListener(this);
	}

	//Check the action performed
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equalsIgnoreCase("Create Weight Log")){
			getCreateWLogButton_actionPerformed(e);
		} else if (action.equalsIgnoreCase("Create Cardio Log")){
			getCreateCLogButton_actionPerformed(e);
		}
	}

	//Call the CardioLogJFrame
	private void getCreateCLogButton_actionPerformed(ActionEvent e) {
		CardioLogJFrame CLJFrame = new CardioLogJFrame();
		CLJFrame.pack();
		CLJFrame.setVisible(true);
		desktopFrame.add(CLJFrame);
	}

	//Call the StoreWeightLogJFrame
	private void getCreateWLogButton_actionPerformed(ActionEvent e) {
		StoreWeightLogJFrame SWLJFrame = new StoreWeightLogJFrame();
		SWLJFrame.pack();
		SWLJFrame.setVisible(true);
		desktopFrame.add(SWLJFrame);

	}
}
