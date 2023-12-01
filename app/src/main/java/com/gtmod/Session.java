package com.gtmod;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.crypto.KeyAgreement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.jsoup.nodes.Document;

public class Session {

    Logger sLogger = Logger.getLogger("dStatLogger");
    FileHandler rL;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime C = LocalDateTime.now();
    static Scanner in = new Scanner(System.in);
    static String choice;

    public static void GTCS() throws IOException{

        System.out.println("Do you want to start a GTC session? (y/n)");
        choice = in.next();
        if(choice.equals("y")){
            JWindow dW = new JWindow("GTC Session");
            dW.setVisible(true);
        }else if(choice.equals("n")){
            Main.home();
        }else{
            System.out.print("\033[H\033[2J");
            System.out.println(ColorTextIndication.ANSI_RED+"INVALID RESPONSE TRY AGAIN"+ColorTextIndication.ANSI_RESET);
            GTCS();
        }
    }
    public static void sLoop() throws IOException{

        

    }
    String report() throws SecurityException, IOException{

        rL = new FileHandler("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\Docs\\Logs\\"+C.format(dtf));
        Document Stats;
        return report();
        
    }
}