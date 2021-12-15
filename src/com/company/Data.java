package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<String> loginList = new ArrayList<>();
    private ArrayList<String> passwordList = new ArrayList<>();
    private ArrayList<Double> cashList = new ArrayList<>();
    private ArrayList<Integer> gamesList = new ArrayList<>();



    public ArrayList<Integer> getIdList() {
        return idList;
    }

    public ArrayList<String> getLoginList() {
        return loginList;
    }

    public ArrayList<String> getPasswordList() {
        return passwordList;
    }

    public ArrayList<Double> getCashList() {
        return cashList;
    }

    public ArrayList<Integer> getGamesList() {
        return gamesList;
    }

    public void load_account() throws IOException {
        File file = new File("konta.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                String splited = new String(line);
                String[] splitedArray = null;
                splitedArray = splited.split(";");
                for (int i = 0; i < splitedArray.length; i++) {
                    switch (i % 5) {
                        case 0:
                            idList.add(Integer.parseInt(splitedArray[i]));
                            break;
                        case 1:
                            loginList.add(splitedArray[i]);
                            break;
                        case 2:
                            passwordList.add(splitedArray[i]);
                            break;
                        case 3:
                            cashList.add(Double.parseDouble(splitedArray[i]));
                            break;
                        case 4:
                            gamesList.add(Integer.parseInt(splitedArray[i]));
                            break;
                        default:
                            break;
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Brak pliku");
        }
    }

    public void newAccount(int id, String login, String password)
    {
        idList.add(id);
        loginList.add(login);
        passwordList.add(password);
        cashList.add(100.0);
        gamesList.add(0);
        try {
            FileWriter fileWriter = new FileWriter("konta.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i=0;i<loginList.size(); i++)
            {
                bufferedWriter.write(idList.get(i) + ";" + loginList.get(i) + ";" + passwordList.get(i) + ";" + cashList.get(i) + ";" + gamesList.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Blad zapisu pliku!");
        }
    }

    public void upload(int number, double cash)
    {
        try {
            FileWriter fileWriter = new FileWriter("konta.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            cashList.set(number, cash);
            gamesList.set(number, gamesList.get(number) + 1);
            for (int i=0;i<loginList.size(); i++)
            {
                bufferedWriter.write(idList.get(i) + ";" + loginList.get(i) + ";" + passwordList.get(i) + ";" + cashList.get(i) + ";" + gamesList.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Blad zapisu pliku!");
        }
    }

    public void Ranking(){

    }
}
