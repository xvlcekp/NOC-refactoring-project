package sk.exxeta.nightofchances.example.example4;

import java.time.LocalDate;

public interface Sender {
    void sendPayment(Employee employee, LocalDate monthOfYear, double amount);
}
