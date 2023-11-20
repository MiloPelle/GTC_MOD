package com.gtmod;

import java.io.IOException;
import java.util.Scanner;

public class Building {

    static Scanner accept = new Scanner(System.in);
    static Boolean readF = accept.hasNext();

    public static void BFailer() throws IOException{

        System.out.println("-------------------------------------");
        System.out.println(" "+ColorTextIndication.ANSI_RED+"BUILD FAILURE"+ColorTextIndication.ANSI_RESET);
        System.out.println(" REASON: REPORTED ABOVE");
        System.out.println(" Press Any Key To Go Home");
        System.out.println("-------------------------------------");

            if(readF = true){
                accept.reset();
                Main.home();
        }
    }

    public static void BSuccess() throws IOException{
        System.out.println("-------------------------------------");
        System.out.println(" "+ColorTextIndication.ANSI_GREEN+"BUILD SUCCESS"+ColorTextIndication.ANSI_RESET);
        System.out.println(" Press Any Key To Go Home");
        System.out.println("-------------------------------------");

        if(readF = true){
            accept.reset();
            Main.home();
        }
    }
}
