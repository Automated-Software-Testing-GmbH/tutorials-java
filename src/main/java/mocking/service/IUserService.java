package mocking.service;

import models.User;
import mocking.repository.ISimpleAddUserRepository;

public interface IUserService {
    boolean validateUser(String name, String age);
    User simpleAddUser(String name, String age) throws Exception;
}
