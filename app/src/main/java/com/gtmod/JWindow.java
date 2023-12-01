package com.gtmod;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.*;
import java.awt.*;

public class JWindow extends JFrame implements ActionListener, ItemListener{

    File GTCFrameLogo = new File("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\images\\gtcframelogo.png");

    JWindow(String Wtitle) throws IOException{
    
    super(Wtitle);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setDefaultLookAndFeelDecorated(true);
    setIconImage(new ImageIcon("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\images\\gtcframeicon.jpg").getImage());
    setResizable(false);
    setBounds(900, 40, 400, 650);
    //main panel initialization
    JPanel StatScreen = new JPanel();
    StatScreen.setBackground(new java.awt.Color(255,132,132));
    add(StatScreen);
    //title label
    JLabel title = new JLabel("GTCMOD");
    StatScreen.add(title);
    title.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
    title.setFont(new java.awt.Font(null,Font.PLAIN,20));
    //main menubar
    JMenuBar catalogue = new JMenuBar();
    catalogue.getAccessibleContext().setAccessibleDescription(
    "The only menu in this program that has menu items");
    catalogue.setVisible(true);
    catalogue.setBackground(new java.awt.Color(91,85,255));
    StatScreen.add(catalogue);
    //main menu
    JMenu mMenu = new JMenu("Menu");
    mMenu.setMnemonic(KeyEvent.VK_A);
    catalogue.add(mMenu);
    //test menu item
    JMenuItem process = new JMenuItem("Process", KeyEvent.VK_D);
    process.addActionListener(this);
    mMenu.add(process);
    System.out.println("DONE");
    //last initialize
    setJMenuBar(catalogue);
    }

    @Override
    public void itemStateChanged(ItemEvent arg0){
        
    }

    @Override
    public void actionPerformed(ActionEvent process) {
        System.out.println("worked");
    }
}
