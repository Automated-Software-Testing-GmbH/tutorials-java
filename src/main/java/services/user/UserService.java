package services.user;

import models.User;
import repositories.user.ISimpleAddUserRepository;

public class UserService implements IUserService {

    public User simpleAddUser(ISimpleAddUserRepository simpleAddRepository, String name, String age) {
        User user = new User(name, Integer.parseInt(age));
        user.setBio("No bio available");
        user.setUuid();
        simpleAddRepository.execute(user);
        return user;
    }

}
