package sk.exxeta.nightofchances.example.example4.salaryCalculator;

import sk.exxeta.nightofchances.example.example4.Employee;

public class SalaryCalculatorFactory {
    public SalaryCalculator getInstance(Employee employee) {
        return switch (employee.type()) {
            case REGULAR -> new RegularSalaryCalculator();
            default -> throw new RuntimeException(
                    "Unsupported employee type provided: " + employee.type());
        };
    }
}
