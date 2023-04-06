package services.user;

import models.User;
import repositories.user.ISimpleAddUserRepository;

public interface IUserService {
    User simpleAddUser(ISimpleAddUserRepository simpleAddRepository, String name, String age);
}
