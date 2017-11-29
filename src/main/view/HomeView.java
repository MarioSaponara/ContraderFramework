package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    private String nomeUtente;
    private String password;

    public void showResults(Request request) {
        if (request!=null) {
            role = (String) request.get("role");
            nomeUtente = (String) request.get("nomeUtente");
            password = (String) request.get("password");
        }
    }

    public void showOptions() {

        switch(role)
        {
            case "admin":
                System.out.println("Benvenuto in ContraderFramework");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU ADMIN-------");
                System.out.println("");
                System.out.println("1) Inserisci gomma");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("3) ");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
            case "user":
                System.out.println("Benvenuto in ContraderFramework");
                System.out.println("");
                System.out.println("");
                System.out.println("-------MENU USER-------");
                System.out.println("");
                System.out.println("1) Inserisci gomma");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("3) Visualizza brand gomme per tipologia di veicolo");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
        }

    }

    public void submit() {

        if (choice < 1 || choice > 4) {
            Request request = new Request();
            request.put("nomeUtente",nomeUtente);
            request.put("password",password);
            request.put("role", role);
            MainDispatcher.getInstance().callAction("Home", "doControl", request);
        }
        else if (choice == 4)
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            request.put("nomeUtente",nomeUtente);
            request.put("password",password);
            request.put("role", role);
            MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
        }

    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
