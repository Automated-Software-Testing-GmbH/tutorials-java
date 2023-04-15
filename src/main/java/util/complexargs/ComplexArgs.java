package util.complexargs;

import models.User;

public class ComplexArgs {

    static User setDefaultBioString(User user) {
        if(user.getBio().trim().equals("")) {
            user.setBio("No bio available");
        }
        return user;
    }

    static User deleteBioString(User user) {
        user.setBio("");
        return user;
    }

}

