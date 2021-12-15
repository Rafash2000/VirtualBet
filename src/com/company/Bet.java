package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bet {
    Scanner scanner = new Scanner(System.in);
    private double[] a =new double[3];
    private double rate;
    private double money;
    private String match_result;
    private double win=0.0;


    public double rand_d()
    {
        double win, draw, loss=1;
        Random rand = new Random();
        return rand.nextDouble(0.18,0.33);
    }

    public double rand_w(double draw)
    {
        Random rand = new Random();
        double win, loss=1;
        loss -=draw;
        win = rand.nextDouble(loss-0.1);
        if(win<0.66)
        {
            win+=0.07;
            loss-=0.07;
        }
        return win;
    }

    public double loss(double win, double draw)
    {
        return 1.0-draw-win;
    }

    public void match()
    {
        int IntValue;
        a[1]=rand_d();
        a[0]=rand_w(a[1]);
        a[2]=loss(a[0], a[1]);
        a[0]=100/a[0];
        IntValue = (int) a[0];
        a[0] = (double) IntValue/100;
        a[1]=100/a[1];
        IntValue = (int) a[1];
        a[1] = (double) IntValue/100;
        a[2]=100/a[2];
        IntValue = (int) a[2];
        a[2] = (double) IntValue/100;

    }

    public String show_macht()
    {
        match();
        return a[0] + " - " + a[1] + " - " + a[2];

    }
    public Double result(double cash, String bet) {
        Random rand = new Random();
        Double win_match;
        int intValue;
        win_match = rand.nextDouble(1.0);
        if (win_match < 1 / a[0]) {
            match_result = "1";
            rate = a[0];
        }
        else if (win_match > 1 / a[0] && win_match < 1.0 - 1 / a[2]) {
            match_result = "X";
            rate = a[1];
        }
        else {
            match_result = "2";
            rate = a[2];
        }
        if(match_result.contains(bet))
            cash*=rate;
        else
            cash = 0;
        money = cash;
        cash*=100.0;
        intValue = (int) cash;
        cash = (double) intValue/100;
        return cash;

    }

    public double play(double money){
        String select;
        for (int i=1; i<=10; i++) {
            System.out.println("             1     X       2");
            System.out.print("Mecz " + i + ".    ");
            System.out.println(show_macht());
            System.out.print("Typ = ");
            select = scanner.next();
            System.out.println("Wygrana = " + result(money/10.0, select));
            System.out.println("Wynik meczu: " + match_result);
            win+=this.money;
        }
        System.out.println("Wygrałeś: " + win);
        return win;
    }

    public String getMatch_result() {
        return match_result;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return show_macht();
    }
}
