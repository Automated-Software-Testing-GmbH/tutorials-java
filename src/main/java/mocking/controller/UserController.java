package mocking.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.User;
import mocking.repository.ISimpleAddUserRepository;
import mocking.repository.SimpleAddUserRepository;
import mocking.service.IUserService;

import static io.javalin.apibuilder.ApiBuilder.*;

public class UserController implements IUserController {

    private final IUserService userService;
    private final ISimpleAddUserRepository simpleAddUserRepository;

    public UserController(Javalin javalin, IUserService userService) {
        // Configure all routes for this Controller
        javalin.routes(() -> path("user", () -> {
            path("validate", () -> get(this::validateUser));
            path("simple-add", () -> get(this::simpleAddUser));
        }));
        this.simpleAddUserRepository = new SimpleAddUserRepository();
        this.userService = userService;
    }

    public void validateUser(Context ctx) {
        String name = ctx.queryParamAsClass("name", String.class).get();
        String age = ctx.queryParamAsClass("age", String.class).get();
        boolean result = userService.validateUser(name, age);
        ctx.json(result);
    }

    public void simpleAddUser(Context ctx) throws Exception {
        String name = ctx.queryParamAsClass("name", String.class).get();
        String age = ctx.queryParamAsClass("age", String.class).get();
        User result = userService.simpleAddUser(simpleAddUserRepository, name, age);
        ctx.json(result);
    }
}
