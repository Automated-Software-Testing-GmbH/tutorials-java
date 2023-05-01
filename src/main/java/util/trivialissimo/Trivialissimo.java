package util.trivialissimo;

public class Trivialissimo {

    public static int parsePositiveIntString(String value) {
        return Integer.parseInt(value);
    }

}

//    // Basic method without the validation check for "0"
//    public static int parsePositiveIntString(String value) {
//        return Integer.parseInt(value);
//    }

//    // Refactored code to fix the "0" test case
//    public static int parsePositiveIntString(String value) throws Exception {
//        int convertedValue = Integer.parseInt(value);
//        if(convertedValue == 0) throw new Exception("0 cannot be accepted");
//        return convertedValue;
//    }

//    // Basic method for TDD approach
//    public static int parsePositiveIntString(String value) throws Exception {
//        return 1;
//    }
