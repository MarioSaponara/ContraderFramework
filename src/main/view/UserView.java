package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.model.User;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private UserService userService;
    private String mode;

    public UserView(){
        this.userService = new UserService();
    }
    @Override
    public void showResults(Request request) {

    }

    @Override
    public void showOptions() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Registrati:");
                System.out.println("Username:");
                String username = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("Nome:");
                String firstname = getInput();
                System.out.println("Cognome:");
                String lastname = getInput();
                System.out.println("Data Nascita:");
                String dateofBirth = getInput();
                System.out.println("Codice Fiscale:");
                String cf = getInput();
                System.out.println("Regione Sociale:");
                String businessname = getInput();
                System.out.println("P.IVA:");
                String vat = getInput();
                System.out.println("Comune:");
                String municipality = getInput();
                System.out.println("CAP:");
                String postecode = getInput();
                System.out.println("Provincia:");
                String city = getInput();
                System.out.println("Indirizzo:");
                String address = getInput();
                System.out.println("Telefono:");
                String telephone = getInput();
                userService.insertUser(new User (null, username, password, firstname, lastname, dateofBirth, cf, businessname, vat, municipality, postecode, city, address, telephone, "user"));
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        //MainDispatcher.getInstance().callAction("Home", "doControl", request);
        MainDispatcher.getInstance().callView("Login", null);

    }
}
