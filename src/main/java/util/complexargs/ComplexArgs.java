package util.complexargs;

import models.User;

public class ComplexArgs {
    static User setEmptyBioString(User user) {
        if(user.getBio().trim().equals("")) {
            user.setBio("No bio available");
        }
        return user;
    }
}

