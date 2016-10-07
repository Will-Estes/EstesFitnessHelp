package com.estesfitnesshelp.view.mainjframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.estesfitnesshelp.view.weightlogjframe.StoreWeightLogJFrame;

public class MainJFrame extends JFrame {

	/**
	 * This creates the main display when the program is run. It creates the 
	 * JFrame and corresponding buttons and is linked to the MainJFrameController
	 * for processing button or menu requests
	 */
	private static final long serialVersionUID = 2377310559170663631L;
	Container cPane;
	JDesktopPane desktopPane = new JDesktopPane();
	JPanel deskPanel;
	JButton jButtonCreateWLog, jButtonCreateCLog;


	//Main method to initiate program
	public static void main(String args[]) {
		MainJFrame w = new MainJFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int maxX = screenSize.width - 100;
		int maxY = screenSize.height - 200;
		w.setPreferredSize(new Dimension(maxX, maxY));
		w.setSize(maxX, maxY);
		w.setTitle("Estes Fitness Help");
		w.setVisible(true);
	}
	
	//Creating the main content area
	public MainJFrame() {
		super("Estes Fitness Help");
		getContentPane().add(desktopPane);
		cPane = getContentPane();
		cPane.setLayout(null);
		initiateComponents();
		initiateMenuBar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//initiates the menu bar
	private void initiateMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitOpt = new JMenuItem("Exit");
		exitOpt.setMnemonic('X');
		exitOpt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		fileMenu.add(exitOpt);
		menuBar.add(fileMenu);
		
		JMenu actionMenu = new JMenu("Action");
		JMenuItem createWLogOpt = new JMenuItem("Create Weight Log");
		createWLogOpt.setMnemonic('Q');
		createWLogOpt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jButtonCreateWLogActionPerformed(e);
			}
		});
		actionMenu.add(createWLogOpt);
		
		JMenuItem createCLogOpt = new JMenuItem("Create Cardio Log");
		createCLogOpt.setMnemonic('Z');
		createCLogOpt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jButtonCreateCLogActionPerformed(e);
			}
		});
		actionMenu.add(createCLogOpt);
		
		menuBar.add(actionMenu);
	}

	//instantiates the components of the screen in the main
	private void initiateComponents(){
		
		//Set size to match desktop size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int maxX = screenSize.width - 100;
		int maxY = screenSize.height - 200;
		
		//Create panel inside desktop
		deskPanel = new JPanel();
		deskPanel.setName("Weight Log Entry");
		deskPanel.setLayout(null);
		deskPanel.setBackground(new Color(200, 50, 50));
		
		//button for creating a weight log
		jButtonCreateWLog = new JButton();
		jButtonCreateWLog.setText("Create Weight Log");
		jButtonCreateWLog.setBounds(80, 120, 150, 25);
		jButtonCreateWLog.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jButtonCreateWLogActionPerformed(e);
		  }
		});
		
		//button for creating a cardio log
		jButtonCreateCLog = new JButton();
		jButtonCreateCLog.setText("Create Cardio Log");
		jButtonCreateCLog.setBounds(250, 120, 150, 25);
		jButtonCreateCLog.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			jButtonCreateCLogActionPerformed(e);
		  }
		});
		
		//add components to deskPanel
		deskPanel.add(jButtonCreateWLog);
		deskPanel.add(jButtonCreateCLog);
		deskPanel.setSize(maxX, maxY);
		cPane.add(deskPanel);
		
		pack();
		setVisible(true);
		
	}
	
	//Action performed for Weight Log button
	private void jButtonCreateWLogActionPerformed(ActionEvent e){
		MainJFrameController desktopPaneC = new MainJFrameController(this);
		desktopPaneC.actionPerformed(e);
		
	}
	
	//Action peformed for Cardio Log button
	private void jButtonCreateCLogActionPerformed(ActionEvent e) {
		MainJFrameController desktopPaneC = new MainJFrameController(this);
		desktopPaneC.actionPerformed(e);
	}
	public JButton getCreateWLogButton(){
		return jButtonCreateWLog;
	}
	
	public JButton getCreateCLogButton(){
		return jButtonCreateCLog;
	}
}
