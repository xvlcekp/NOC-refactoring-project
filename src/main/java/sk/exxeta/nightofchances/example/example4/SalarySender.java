package sk.exxeta.nightofchances.example.example4;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.logging.Logger;

public class SalarySender implements Sender{
    private static final Logger logger = Logger.getLogger(SalarySender.class.getName());
    public void sendPayment(Employee employee, LocalDate monthOfYear, double amount) {
        logger.info("Sending payment for user '" + employee.name() +
                "' in ammount '" + amount +
                "' to '" + employee.bankAccount() +
                "' for month: " + monthOfYear.getMonth()
        );
    }
}
