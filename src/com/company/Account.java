package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Comparable<Account>{
    Scanner scanner = new Scanner(System.in);
    private int id;
    private String login;
    private String password;
    private Double cash;
    private Integer games;


    public Account(int id, String login, String password, Double cash, int games) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cash = cash;
        this.games = games;
    }

    public Account(int id, String login, String password, Double cash) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cash = cash;
        games = 0;
    }

    public void add_account(String name, int id, String password1, int games)
    {
        login = name;
        password = password1;
        cash = 100.0;
        this.id = id;
        this.games = games;
        System.out.println("Konto zostalo utworzone");
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "\nId: " + id + "\nLogin: " + login + "\nHaslo: " + password + "\nStan konta: " + cash + "\n";
    }

    @Override
    public int compareTo(Account o) {
        int result = this.cash.compareTo(o.cash);
        return result;
    }
}
