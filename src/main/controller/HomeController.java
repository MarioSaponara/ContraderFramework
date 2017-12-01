package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

import java.util.ArrayList;
import java.util.List;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if ((request != null) && ((request.get("role")==null))) {//inserito negazione
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            //String role=loginService.login(nomeUtente, password);
            List<String> data= loginService.login(nomeUtente, password);
            if (!data.isEmpty()) {
                String nome=data.get(0);
                request.put("nome", nome);
                String role=data.get(1);
                request.put("role", role);
                MainDispatcher.getInstance().callView("Home", request);
            }
            else
                MainDispatcher.getInstance().callAction("Login", "doControl", null);//inserito null

        }
        else //MainDispatcher.getInstance().callView("Home", request);
           // MainDispatcher.getInstance().callAction("Login", "doControl", null);
            MainDispatcher.getInstance().callView("Login", null);

    }
}
