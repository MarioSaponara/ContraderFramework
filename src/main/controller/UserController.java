package main.controller;

import main.MainDispatcher;

public class UserController implements Controller{

    @Override
    public void doControl(Request request) {
        request.put("mode","insert");
        MainDispatcher.getInstance().callView("User", request);

    }
}
