package com.gtmod;

import java.io.IOException;
import java.util.Scanner;

public class Building {

    public static void BFailer() throws IOException{

        System.out.println("-------------------------------------");
        System.out.println(" "+ColorTextIndication.ANSI_RED+"BUILD FAILURE"+ColorTextIndication.ANSI_RESET);
        System.out.println(" REASON: REPORTED ABOVE");
        System.out.println(" Press Any Key To Go Home");
        System.out.println("-------------------------------------");

        try(Scanner BuildFailure = new Scanner(System.in)){

            String aProblem = BuildFailure.next();
            Main.home();

        }
    }
}
