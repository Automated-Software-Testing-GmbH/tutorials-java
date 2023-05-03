package util.alltogether;

import org.joda.time.DateTime;
import org.joda.time.Period;


public class AllTogether {
    private final String name;
    private final int age;

    public AllTogether(DateTime dob, String name) {
        DateTime now = new DateTime();
        Period period = new Period(dob, now);
        this.age = period.getYears();
        this.name = name;
    }

    public void validateUser() throws Exception {
        // Check basic properties
        if(name.length()<2) {
            throw new Exception("Invalid name");
        }
        if(age<=0) {
            throw new Exception("Invalid age");
        }
        // Check not too young
        if(this.age < 18) {
            throw new Exception("Too young");
        }
    }

    public CreditReturnStatus checkCredit(int creditSought, int duration) {
        CreditReturnStatus response = new CreditReturnStatus();
        response.approved = false;

        if (age < 26) {
            if(creditSought > 1000) {
                response.message = "We only offer up to 1000 of credit between 18 and 25";
                return response;
            }
            if(duration > 24) {
                response.message = "We offer max 24 months of credit between 18 and 25";
                return response;
            }
        }
        else {
            if(creditSought > 10000) {
                response.message = "We only offer up to 10000 of credit";
                return response;
            }
            if(duration > 48) {
                response.message = "We offer max 48 months of credit";
                return response;
            }
        }
        response.approved = true;
        response.message = this.name + " : your credit has been approved";
        return response;
    }

}

class CreditReturnStatus {
    public boolean approved;
    public String message;
}
