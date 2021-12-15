package com.company;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bet> betList = new ArrayList<>();
        ArrayList<Account> accountList = new ArrayList<>();
        ArrayList<String> loginList = new ArrayList<>();
        int select, number;
        Double cash = 100.0;
        Double win = 0.0;
        String bet, name, password1, password2;

        Data data = new Data();
        Bet bets = new Bet();

        data.load_account();


        for(int i=0; i<data.getLoginList().size();i++){
            Account account = new Account(data.getIdList().get(i), data.getLoginList().get(i), data.getPasswordList().get(i), data.getCashList().get(i), data.getGamesList().get(i));
            accountList.add(account);
        }

       // System.out.println(accountList);



        System.out.println("1 - Zaloguj sie\n2 - Zaloz konto");
        select = scanner.nextInt();

        switch (select)
        {
            case 1:
                while (true){
                    System.out.print("Login: ");
                    name = scanner.next();
                    if (data.getLoginList().contains(name)) {
                        number = data.getLoginList().indexOf(name);
                        break;
                    }
                    else
                        System.out.println("Błedny login");
                }
                while(true){
                    System.out.print("Hasło: ");
                    password1 = scanner.next();
                    if (password1.equals(data.getPasswordList().get(number))) {
                        System.out.println("Hasło poprawne!");
                        break;
                    }
                    else
                        System.out.println("Błędne hasło");
                }
                break;
            case 2:
                while(true) {
                    System.out.print("Login: ");
                    name = scanner.next();
                    if (data.getLoginList().contains(name))
                        System.out.println("Login zajęty!");
                    else
                        break;
                }

                do {
                    System.out.print("Haslo: ");
                    password1 = scanner.next();
                    System.out.print("Powtorz haslo: ");
                    password2 = scanner.next();
                    if (!password1.equals(password2))
                    {
                        System.out.println("Hasla sa różne");
                    }
                }while (!password1.equals(password2));
                Account account = new Account(data.getIdList().get(data.getLoginList().size()-1)+1, name, password1, 100.0);
                data.newAccount(data.getIdList().get(data.getLoginList().size()-1)+1, name, password1);
                accountList.add(account);
                System.out.println("Konto zostało dodane");
                number = data.getLoginList().size() - 1;
                break;
            default:
                return;
        }

        System.out.println(data.getLoginList().get(number));
        System.out.println("Stan konta: " + data.getCashList().get(number));

        System.out.println("1 - Zagraj");
        System.out.println("2 - Ranking");

        select = scanner.nextInt();

        switch (select){
            case 1:

                data.upload(number, bets.play(data.getCashList().get(number)));
            //    System.out.println(data.getCashList());
                    break;
            case 2:
                System.out.println(accountList);
                break;


        }












    }


}
