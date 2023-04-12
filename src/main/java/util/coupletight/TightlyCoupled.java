package util.coupletight;

public class TightlyCoupled {
    public static void userController(String userId) {
        UserService userService = new UserService();
        System.out.println("User is called : " + userService.getUser(userId));
    }
}

class UserService {
    public String getUser(String userId) {
        UserDB userDb = new UserDB();
        return userDb.getUserFromDB(userId);
    }
}

class UserDB {
    public String getUserFromDB(String id) {
        return "John Brook";
    }
}

