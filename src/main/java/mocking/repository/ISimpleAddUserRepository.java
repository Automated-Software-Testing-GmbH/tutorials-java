package mocking.repository;

import models.User;

public interface ISimpleAddUserRepository {

    User execute(User user);
}
