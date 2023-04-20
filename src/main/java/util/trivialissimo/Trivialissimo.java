package util.trivialissimo;

public class Trivialissimo {

    public static int parsePositiveIntString(String value) throws Exception {
        int convertedValue = Integer.parseInt(value);
        if(convertedValue == 0) throw new Exception("0 cannot be accepted");

        return convertedValue;
    }

//    // Refactored code to fix the "0" test case
//    public static int parsePositiveIntString(String value) throws Exception {
//        int convertedValue = Integer.parseInt(value);
//        if(convertedValue == 0) throw new Exception("0 cannot be accepted");
//        return convertedValue;
//    }

}