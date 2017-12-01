package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class AccessView implements View{
    int typeaccess;
    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {
        System.out.println("-----HOME-PAGE----");
        System.out.println("1-----ACCEDI------");
        System.out.println("2----REGISTRATI---");
        typeaccess=Integer.parseInt(getInput());
    }

    @Override
    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        //Request request = new Request();

        if((typeaccess<1) || (typeaccess>2)){
            MainDispatcher.getInstance().callView("Access",null);
        }else if (typeaccess==1){
            MainDispatcher.getInstance().callView("Login", null);
        }else if (typeaccess==2) {
            MainDispatcher.getInstance().callView("User", null);
        }
    }
}
