package services.user;

import models.User;
import repositories.user.ISimpleAddUserRepository;

public interface IUserService {
    boolean validateUser(String name, String age);
    User simpleAddUser(ISimpleAddUserRepository simpleAddRepository, String name, String age);
}
