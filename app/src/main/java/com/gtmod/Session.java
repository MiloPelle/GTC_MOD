package com.gtmod;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;

public class Session {

    FileHandler rL;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime C = LocalDateTime.now();
    static Scanner in = new Scanner(System.in);
    static String choice;
    static int l = 0;
    static Boolean end = false;
    static Boolean pause = false;

    public static void GTCS() throws IOException{

        System.out.println("Do you want to start a GTC session? (y/n)");
        choice = in.next();
        if(choice.equals("y")){
            JWindow dW = new JWindow("GTC Session");
            dW.setVisible(true);
            //sLoop();
        }else if(choice.equals("n")){
            Main.home();
        }else{
            System.out.print("\033[H\033[2J");
            System.out.println(ColorTextIndication.ANSI_RED+"INVALID RESPONSE TRY AGAIN"+ColorTextIndication.ANSI_RESET);
            GTCS();
        }
    }
    public static void sLoop() throws IOException, InterruptedException{
        while(pause=true){
            System.out.wait();
        }
        if(end=true){

        }else{sLoop();}
    }
}