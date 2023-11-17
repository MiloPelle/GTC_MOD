package com.gtmod;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkID {
    
    static String choice;
    static Scanner in = new Scanner(System.in);
    static String ID;

    public static void LinkID() throws IOException{

        Document GTCF;
        System.out.print("\033[H\033[2J");
        System.out.println("Enter Link ID:");
        
        ID = in.next();

        String GTCURL = "https://gorillatagcomp.com/leaderboard/0/"+choice;

        try{

        GTCF = Jsoup.connect(GTCURL).get();
        
        Elements GTCName = GTCF.getElementsByClass("LeaderCardName");
        Elements MMR = GTCF.getElementsByClass("LeaderCardStats");

        System.out.print("\033[H\033[2J");
        System.out.println("Is This Your Profile?");
        System.out.println("--------------------------------------------------|");
        for(Element a : GTCName){
            System.out.println("| Discord Name: "+a.text());
        }
        for(Element b : MMR){
            String Rate = b.text();
            System.out.println("| Stats: "+Rate);
            System.out.println("--------------------------------------------------|");
            System.out.println("Save Link ID (y/n)");
        }
        in.reset();
        SID();
        
        }catch (java.net.SocketException e){

            System.out.print("\033[H\033[2J");
            e.printStackTrace();
            System.out.println("Either Bad Wifi Connection Or Domain Blocked");
            Building.BFailer();

        }
    }

    public static void SID() throws IOException{
    
            choice = in.next();
            if(choice.equals("y")){

                FileWriter WriteID = new FileWriter("ID.txt", true);
                BufferedWriter saveID = new BufferedWriter(WriteID);
                System.out.println(ColorTextIndication.ANSI_GREEN+"SAVE SUCCESS");

                saveID.write("\033[H\033[2J");
                saveID.write(ID);
                System.out.println(ColorTextIndication.ANSI_GREEN+"SAVE SUCCESS"+ColorTextIndication.ANSI_RESET);
                saveID.close();
                Main.home();

            }else if(choice.equals("n")){

                Main.home();

            }else{

                System.out.println(ColorTextIndication.ANSI_RED+"INVALID RESPONSE : TRY AGAIN");
                SID();

        }
    }
}