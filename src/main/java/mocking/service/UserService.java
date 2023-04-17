package mocking.service;

import io.javalin.validation.ValidationException;
import mocking.repository.ISimpleAddUserRepository;
import models.User;

public class UserService implements IUserService {

    private final ISimpleAddUserRepository addUserRepository;

    public UserService(ISimpleAddUserRepository addUserRepository) {
        this.addUserRepository = addUserRepository;
    }

    public boolean validateUser(String name, String age) {
        int numAge = Integer.parseInt(age);
        if(name.length() < 4) return false;
        if(numAge < 18 || numAge > 120) return false;
        return true;
    }

    public User simpleAddUser(String name, String age) throws Exception {
        if(!validateUser(name, age)) throw new Exception("Illegal argument somewhere or other");
        User user = new User(name, Integer.parseInt(age));
        user.setBio("No bio available");
        return addUserRepository.execute(user);
    }

}
