package org.example;

import controllers.IUserController;
import controllers.UserController;
import io.javalin.Javalin;
import services.user.IUserService;
import services.user.UserService;

public class DevMate {
    public static void main(String[] args) {

        // Initialise Javalin Web Server
        Javalin javalin = Javalin.create();
        javalin.start(7070);

        // Initialise Controllers
        IUserService userService = new UserService();
        new UserController(javalin, userService);

        System.out.println("DeMate server started successfully");
    }
}