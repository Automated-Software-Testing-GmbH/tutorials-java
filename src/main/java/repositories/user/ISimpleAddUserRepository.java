package repositories.user;

import models.User;

public interface ISimpleAddUserRepository {

    User execute(User user);
}
