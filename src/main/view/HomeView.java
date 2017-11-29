package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;


    public void showResults(Request request) {
        if (request!=null) {
            role = (String) request.get("role");
        }
    }

    public void showOptions() {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println("");
        switch(role)
        {
            case "admin":
                System.out.println("");
                System.out.println("-------MENU ADMIN-------");
                System.out.println("");
                System.out.println("1) Inserisci nuova gomma");
                System.out.println("2) Visualizza tutte le gomme");
                System.out.println("3) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
            case "user":
                System.out.println("");
                System.out.println("-------MENU USER-------");
                System.out.println("");
                System.out.println("1) Visualizza tutte le gomme");
                System.out.println("2) Visualizza gomma per brand");
                System.out.println("3) Logout");
                this.choice = Integer.parseInt(getInput());
        }

    }

    public void submit() {
        switch(role)
        {
            case "admin":
                if (choice < 1 || choice > 3) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else if (choice == 3)
                    MainDispatcher.getInstance().callAction("Login", "doControl", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
                break;
            case "user":
                if (choice < 1 || choice > 3) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                }
                else if (choice == 3)
                    MainDispatcher.getInstance().callAction("Login", "doControl", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
        }

    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
