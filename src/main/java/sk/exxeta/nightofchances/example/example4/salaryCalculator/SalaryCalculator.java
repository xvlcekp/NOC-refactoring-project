package sk.exxeta.nightofchances.example.example4.salaryCalculator;

import sk.exxeta.nightofchances.example.example4.Employee;
import java.time.LocalDate;

public interface SalaryCalculator {
    double calculateSalary(Employee employee, LocalDate month);

    /**
     * determines the number of days in a month, when the employee worked regular hours
     */
    default int calculateDaysWorkedPerMonth(LocalDate monthOfYear) {
        return (monthOfYear.getMonth().maxLength() * 5) / 7;
    }
}
