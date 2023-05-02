package util.alltogether;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class AllTogether {
    private String countryCode;
    private String name;
    private int age;

    public AllTogether(DateTime dob, String countryCode, String name) throws Exception {
        this.countryCode = countryCode;
        this.name = name;
        // Check date not in the future
        DateTime now = new DateTime();
        if(dob.isAfter(now)) {
            throw new Exception("Date is in the future");
        }
        // Check not too young
        Period period = new Period(dob, now);
        this.age = period.getYears();
        if(this.age < 18) {
            throw new Exception("Too young");
        }
        // Check is US user
        if(countryCode != "US") {
            throw new Exception("Must be a US customer");
        }
    }

    public CreditReturnStatus checkCredit(int creditSought, int duration) {
        CreditReturnStatus response = new CreditReturnStatus();
        response.approved = false;

        if(age < 18) {
            response.message = "You are too young";
            return response;
        } else if (age < 26) {
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
            response.approved = true;
            response.message = "Your credit has been approved";
        }
        return response;
    }

}

class CreditReturnStatus {
    public boolean approved;
    public String message;
}
