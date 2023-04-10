package util.trivialissimo;

import models.User;

public class Trivialissimo {

//    public static int parsePositiveIntString(String value) throws Exception {
//        // Refactored code to fix the "0" test case is commented out below
//        return Integer.parseInt(value);
//    }

    // Refactored code to fix the "0" test case
    public static int parsePositiveIntString(String value) throws Exception {
        int convertedValue = Integer.parseInt(value);
        if(convertedValue == 0) throw new Exception("0 cannot be accepted");
        return convertedValue;
    }

    public static int playMethod(String value) {
        return 1;
    }

}
