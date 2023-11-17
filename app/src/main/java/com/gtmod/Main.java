package com.gtmod;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException{
        home();
    }
    public static void home() throws IOException{
        System.out.println("\033[H\033[2J");
        System.out.printf("|-------------------------------|%n");
        System.out.printf("|            GTC_MOD            |%n");
        System.out.printf("|            By: Lofi           |%n");
        System.out.printf("|-------------------------------|%n");
        System.out.printf("|        Choose a Option:       |%n");
        System.out.printf("|        1. Change LinkID       |%n");
        System.out.printf("|        2. Start Session       |%n");
        System.out.printf("|        3. Stat Logs           |%n");
        System.out.printf("|-------------------------------|%n");

        try (Scanner HomeOp = new Scanner(System.in)){
            String HomeOpt = HomeOp.next();
            if(HomeOpt.equals("1")){
                LinkID.LinkID();
            }else if(HomeOpt.equals("2")){

            }else if(HomeOpt.equals("3")){
                
            }
            HomeOp.close();
        }
    }
}