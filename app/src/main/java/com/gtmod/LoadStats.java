package com.gtmod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoadStats {

    static Scanner choice = new Scanner(System.in);
    static String rID;
    static File ID = new File("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\Docs\\ID\\ID.txt"); 
    static String input;

    public static void check() throws IOException{

        BufferedReader IDCheck = new BufferedReader(new FileReader(ID));
        rID = IDCheck.readLine();
        if(rID.isEmpty()){
            System.out.print("\033[H\033[2J");
            System.out.println("No Configured Link ID");
            Building.BFailer();
        }else{
            statLoader();
        }

    }
    public static void statLoader() throws IOException{

        Document GTCF;
        System.out.print("\033[H\033[2J");
        

        String GTCURL = "https://gorillatagcomp.com/leaderboard/0/"+rID;

        try{

        GTCF = Jsoup.connect(GTCURL).get();
        
        Elements GTCName = GTCF.getElementsByClass("LeaderCardName");
        Elements MMR = GTCF.getElementsByClass("LeaderCardStats");

        System.out.print("\033[H\033[2J");
        System.out.println("--------------------------------------------------|");
        for(Element a : GTCName){
            System.out.println("| Discord Name: "+a.text());
        }
        for(Element b : MMR){
            String Rate = b.text();
            System.out.println("| Stats: "+Rate);
            System.out.println("|--------------------------------------------------|");
            System.out.println("|                 1. Reload Stats                  |");
            System.out.println("|                 2. Home                          |");
            System.out.println("|--------------------------------------------------|");
        }
        input = choice.next();
        if(input.equals("1")){
            statLoader();
        }else if(input.equals("2")){
            Main.home();
        }else{
            statLoader();
        }
        
        }catch (java.net.SocketException e){

            System.out.print("\033[H\033[2J");
            e.printStackTrace();
            System.out.println("Either Bad Wifi Connection Or Domain Blocked");
            Building.BFailer();

        }

    }

}
