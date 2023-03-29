package sk.exxeta.nightofchances.example.example4.salaryCalculator;

import sk.exxeta.nightofchances.example.example4.Employee;
import java.time.LocalDate;

public class RegularSalaryCalculator implements SalaryCalculator {
    private final int bonusDayCriteria = 20;
    private final double bonusRate = 1.5;

    /**
     * Request from the accounting to calculate the daily rate
     * after the 20th day in a month with an additional bonus of 50%
     */
    @Override
    public double calculateSalary(Employee employee, LocalDate month) {
        double daysWorkedInMonth = calculateDaysWorkedPerMonth(month);
        // base salary in case we don't exceed bonusDayCriteria (number of working days if less than 20, or 20)
        double baseSalary = employee.dailyWage() * Math.min(daysWorkedInMonth, bonusDayCriteria);
        // bonus salary in case we exceed bonusDayCriteria (0 or bonus)
        double bonus = Math.max(0, (daysWorkedInMonth - bonusDayCriteria) * employee.dailyWage() * bonusRate);
        return baseSalary + bonus;
    }
}
