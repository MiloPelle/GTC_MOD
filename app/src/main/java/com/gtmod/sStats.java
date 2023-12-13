package com.gtmod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sStats {
    
    Double fMMRf;
    Double oMMRf;
    Double nMMRf;
    int fRTf;
    int oRTf;
    int nRTf;
    int fTCf;
    int oTCf;
    int nTCf;
    Double q13f;
    Double q23f;
    int d46f;
    int d56f;
    int d79f;
    int d89f;

    DateTimeFormatter dailyLog = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    Document cS;
    static File ID = new File("C:\\Users\\milop\\OneDrive\\Documents\\Personal Github Repositories\\GTC_MOD-1\\app\\Docs\\ID\\ID.txt");
    static File tLog = new File("");

    public void createStatsMMR() throws IOException{

        BufferedReader IDCheck = new BufferedReader(new FileReader(ID));
        String sID = IDCheck.readLine();
        cS = Jsoup.connect("https://gorillatagcomp.com/leaderboard/0/"+sID).get();

        
        fMMR();
        fTC();
        fRT();



        Session.l++;

        JWindow.pushStats(fMMRf,oMMRf,nMMRf,fRTf,oRTf,nRTf,fTCf,oTCf,nTCf,q13f,q23f,d46f,d56f,d79f,d89f);
        
    }
    private void fMMR(){

        if(Session.l==0){oMMRf=null;}else{oMMRf=nMMRf;}
        oMMRf = fMMRf;
        Elements cMMR = cS.getElementsByClass("LeaderCardMMR");
        Element eMMR = cMMR.first();
        String sMMR = eMMR.text();
        if(Session.l==0){fMMRf = Double.parseDouble(sMMR);}
        nMMRf=Double.parseDouble(sMMR);
        q13f=fMMRf/nMMRf;
        q23f=oMMRf/nMMRf;

    }

    private void fTC(){

        if(Session.l==0){oTCf=0;}else{oTCf=nTCf;}
        Elements cTC = cS.getElementsByClass("NumberOfNameLeader");
        Element eTC = cTC.first();
        String sTC = eTC.text();
        if(Session.l==0){fTCf = Integer.parseInt(sTC);}
        nTCf=Integer.parseInt(sTC);
        d46f=nTCf-fTCf;
        d56f=nTCf-oTCf;

    }

    private void fRT(){

        if(Session.l==0){oRTf=0;}else{oRTf=nRTf;}
        Elements cRT = cS.getElementsByClass("NumberOfNameLeader");
        Element eRT = cRT.get(2);
        String sRT = eRT.text();
        if(Session.l==0){fRTf = Integer.parseInt(sRT);}
        nRTf=Integer.parseInt(sRT);
        d79f=nRTf-fRTf;
        d89f=nRTf-oRTf;

    }
    public static void pushLogs(){

        

    }
}
