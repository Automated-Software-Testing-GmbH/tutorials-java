package org.example;

import mocking.controller.UserController;
import io.javalin.Javalin;
import mocking.repository.ISimpleAddUserRepository;
import mocking.repository.SimpleAddUserRepository;
import mocking.service.IUserService;
import mocking.service.UserService;

public class DevMate {
    public static void main(String[] args) {

        // Initialise Javalin Web Server
        Javalin javalin = Javalin.create();
        javalin.start(7070);

        // Initialise Controllers
        ISimpleAddUserRepository simpleAddUserRepository = new SimpleAddUserRepository();
        IUserService userService = new UserService(simpleAddUserRepository);
        new UserController(javalin, userService);

        System.out.println("DeMate server started successfully");
    }
}