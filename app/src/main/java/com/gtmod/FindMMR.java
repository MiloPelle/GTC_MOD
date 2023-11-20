package com.gtmod;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FindMMR {

    static Scanner QFind = new Scanner(System.in);
    static String choice;

    public static void QuickFind() throws IOException{

        System.out.printf("----------------------------%n");
        System.out.printf("Enter Link ID:%n");
        System.out.printf("----------------------------%n");
        choice = QFind.next();

    }
    public static void Qfounded() throws IOException{

        Document tData;
        String tURL = "https://gorillatagcomp.com/leaderboard/0/"+choice;
        tData = Jsoup.connect(tURL).get();
        Elements tMMR = tData.getElementsByClass("LeaderCardMMR");
        Elements tName = tData.getElementsByClass("LeaderCardName");
        System.out.println("----------------------------");
        for(Element Etmmr : tMMR){
            System.out.println("Discord Name: "+Etmmr);
        }
        for(Element EtName : tName){
            System.out.println("Rating: "+EtName);
        }
        System.out.println("----------------------------");
        System.out.println("          1. Home           ");
        System.out.println("       2. Reload Stats      ");
        System.out.println("        3. New Search       ");
        System.out.println("----------------------------");
        QFind.reset();
        choice = QFind.next();
        if(choice.equals("1")){
            Main.home();
        }else if(choice.equals("2")){
            Qfounded();
        }else if(choice.equals("3")){
            QuickFind();
        }else{
            System.out.println(ColorTextIndication.ANSI_RED+"INVALID RESPONSE"+ColorTextIndication.ANSI_RESET);
            Qfounded();;
        }
    }
}
