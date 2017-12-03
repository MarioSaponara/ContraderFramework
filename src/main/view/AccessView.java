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
        boolean flag;
        do {
            flag=false;
            try{
            typeaccess = Integer.parseInt(getInput());
            }
            catch (NumberFormatException e){
                flag=true;
                MainDispatcher.getInstance().callView("Access",null);
            }
        }while(flag);
    }

    @Override
    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        if((typeaccess<1) || (typeaccess>2)){
            MainDispatcher.getInstance().callView("Access",null);
        }else if (typeaccess==1){
            request.put("choice",typeaccess);
            request.put("role",null);
            MainDispatcher.getInstance().callAction("User", "doControl", request);
        }else if (typeaccess==2) {
            request.put("choice",typeaccess);
            request.put("role",null);
            MainDispatcher.getInstance().callAction("User", "doControl", request);
        }
    }
}
