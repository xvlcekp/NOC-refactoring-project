package sk.exxeta.nightofchances.example.example4;

import sk.exxeta.nightofchances.example.example4.salaryCalculator.SalaryCalculatorFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *  MY TASK:
 *  1. Rewrite the implementation to make the Employee management SRP compliant, while supporting the operations:
 *  - 'persistence' - create & delete Employee,  list all employees and find a specific employee by name
 *  - report hours for the HR department
 *  - send payment to the user
 *  - print employee properties
 */
public class EmployeeManager {
    private static EmployeeManager employeeManagerInstance;
    private final List<Employee> employeesList;
    private static final Logger logger = Logger.getLogger(EmployeeManager.class.getName());
    private final SalaryCalculatorFactory salaryCalculatorFactory = new SalaryCalculatorFactory();
    private final Sender sender = new SalarySender();

    private EmployeeManager() {
        employeesList = new ArrayList<>();
    }

    public static EmployeeManager getInstance() {
        if (employeeManagerInstance == null) {
            employeeManagerInstance = new EmployeeManager();
        }
        return employeeManagerInstance;
    }

    public double calculatePay(Employee employee, LocalDate monthOfYear) {
        logger.info("Calculating employee's payment.");
        return salaryCalculatorFactory.getInstance(employee).calculateSalary(employee, monthOfYear);
    }

    public void displayEmployeeDetails(Employee employee){
        logger.info("Displaying employee details.");
        LocalDate month = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        sb.append("Employee: ").append(employee.name()).append("\n")
                .append("Bank account: ").append(employee.bankAccount()).append("\n")
                .append("Salary: ").append(calculatePay(employee, month)).append("\n");
        logger.info(sb.toString());
    }

    public void sendPayment(Employee employee, LocalDate monthOfYear) {
        logger.info("Sending employee's payment.");
        double amount = calculatePay(employee, monthOfYear);
        sender.sendPayment(employee, monthOfYear, amount);
    }

    public Employee getEmployeeByName(String employeeName) {
        return employeesList.stream().filter(e -> e.name().equals(employeeName)).findFirst().orElse(null);
    }

    public void save(Employee employee) {
        logger.info("Saving employee: " + employee);
        employeesList.add(employee);
    }

    public List<Employee> getAll() { return employeesList; }

    public void delete(String name) {
        logger.info("Trying to delete an employee with name: " + name);
        employeesList.removeIf(e -> e.name().equals(name));
    }

}


