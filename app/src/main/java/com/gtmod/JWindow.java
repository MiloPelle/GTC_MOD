package com.gtmod;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JWindow extends JFrame{


    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd HH:mm:ss");
    static LocalDateTime t = LocalDateTime.now();

    static File logger = new File("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\Docs\\Logs\\"+t+".txt");


    JWindow(String Wtitle) throws IOException{
    super(Wtitle);
    //panel init
    final JPanel StatScreen;
    //JLable init
    final JLabel title;
    //menuBar init
    final JMenuBar catalogue;
    //JMenu init
    final JMenu mMenu;
    final JMenu process;
    //process items
    final JMenuItem endProcesses;
    final JMenuItem pauseProcesses;
    final JMenuItem resumeProcesses = new JMenuItem("Resume Processes");
    //text fields
    final JTextField  uMMR = new JTextField("Updated MMR");
    uMMR.setLocation(50,20);
    //
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setDefaultLookAndFeelDecorated(true);
    setIconImage(new ImageIcon("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\images\\gtcframelogo.png").getImage());
    setResizable(false);
    setBounds(900, 40, 400, 650);
    //summary panel initialization
    StatScreen = new JPanel();
    StatScreen.setBackground(new java.awt.Color(255,132,132));
    add(StatScreen);
    //title label
    title = new JLabel("GTCMOD");
    StatScreen.add(title);
    title.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
    title.setFont(new java.awt.Font(null,Font.PLAIN,20));
    //main menubar
    catalogue = new JMenuBar();
    catalogue.getAccessibleContext().setAccessibleDescription(
    "The only menu in this program that has menu items");
    catalogue.setVisible(true);
    catalogue.setBackground(new java.awt.Color(91,85,255));
    StatScreen.add(catalogue);
    //main menu
    mMenu = new JMenu("Menu");
    mMenu.setMnemonic(KeyEvent.VK_A);
    mMenu.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, 1);
    catalogue.add(mMenu);
    //process submenu
    process = new JMenu("Process");
    process.setMnemonic(KeyEvent.VK_S);
    mMenu.add(process);
    //process item endProcess
    endProcesses = new JMenuItem("End Processes");
    endProcesses.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
    endProcesses.addActionListener(e -> {
        System.out.println("[INFO] process/endProcesses action complete");
        dispose();
        Session.end=true;
    });
    process.add(endProcesses);
    //process item pauseProcesses
    pauseProcesses = new JMenuItem("Pause Processes");
    pauseProcesses.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
    pauseProcesses.setVisible(true);
    pauseProcesses.addActionListener(e -> {
        pauseProcesses.setVisible(false);
        resumeProcesses.setVisible(true);
        System.out.println("[INFO] process/pauseProcesses complete");
    });
    process.add(pauseProcesses);
    //process item resume
    resumeProcesses.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
    resumeProcesses.setVisible(false);
    resumeProcesses.addActionListener(e -> {
        resumeProcesses.setVisible(false);
        pauseProcesses.setVisible(true);
        System.out.println("[INFO] process/resumeProcesses action complete");
    });
    process.add(resumeProcesses);
    //chart initializaiton button
    JMenuItem chartInitialization = new JMenuItem("Chart Display");
    chartInitialization.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
    //statscreen JPanel
    StatScreen.add(uMMR);
    uMMR.setFont(new java.awt.Font(null,Font.PLAIN,10));
    uMMR.setBackground(new java.awt.Color(91,85,255));
    //last initialize
    setJMenuBar(catalogue);
    }
    public static void pushStats(Double fMMR, Double oMMR, Double nMMR, int fRT,int oRT,int nRT,int fTC, int oTC, int nTC, Double q13, Double q23,int d46, int d56, int d79, int d89) throws IOException{

        System.out.println(t);
        System.out.println("First MMR:"+fMMR);
        System.out.println("Old MMR:"+oMMR);
        System.out.println("New MMR:"+nMMR);
        System.out.println("First Runtime:"+fRT);
        System.out.println("Old Runtime:"+oRT);
        System.out.println("New Runtime:"+nRT);
        System.out.println("First Tag Count:"+fTC);
        System.out.println("Old Tag Count:"+oTC);
        System.out.println("New Tag Count:"+nTC);
        System.out.println("q13:"+q13);
        System.out.println("q23:"+q23);
        System.out.println("d46:"+d46);
        System.out.println("d56:"+d56);
        System.out.println("d79:"+d79);
        System.out.println("d89:"+d89);



    }
}
