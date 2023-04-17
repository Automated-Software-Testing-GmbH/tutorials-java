package mocking.repository;

import models.User;

public class SimpleAddUserRepository implements ISimpleAddUserRepository {

    @Override
    public User execute(User user) {
        // No, we're not doing anything meaningful here
        return user;
    }

}
