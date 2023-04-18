package util.chaining;

public class Chain {
    public static int multiplyPositiveByTen(int input) throws Exception {
        if(input <= 0) throw new Exception("Input must be greater than or equal to 1");
        return input * 10;
    }
}


