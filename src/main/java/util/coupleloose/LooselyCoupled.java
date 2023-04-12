package util.coupleloose;

public class LooselyCoupled {
    private static UserService userService;
    public LooselyCoupled() {
        UserDB userDb = new UserDB();
        userService = new UserService(userDb);
    }
    public static void userController(String userId) {
        System.out.println("User is called : " + userService.getUser(userId));
    }
}

class UserService {
    private final UserDB userDb;
    public UserService(UserDB userDb) {
        this.userDb = userDb;
    }
    public String getUser(String userId) {
        return userDb.getUserFromDB(userId);
    }
}

class UserDB {
    public String getUserFromDB(String id) {
        return "John Brook";
    }
}


