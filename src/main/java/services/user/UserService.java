package services.user;

import models.User;
import repositories.user.ISimpleAddUserRepository;

public class UserService implements IUserService {

    public boolean validateUser(String name, String age) {
        int numAge = Integer.parseInt(age);
        if(name.length() < 4) return false;
        if(numAge < 18 || numAge > 120) return false;
        return true;
    }

    public User simpleAddUser(ISimpleAddUserRepository simpleAddRepository, String name, String age) {
        User user = new User(name, Integer.parseInt(age));
        user.setBio("No bio available");
        user.setUuid();
        simpleAddRepository.execute(user);
        return user;
    }

}
