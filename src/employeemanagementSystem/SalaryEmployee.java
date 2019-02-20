package employeemanagementSystem;

/**
 *
 * @author Mostafa
 */
public class SalaryEmployee extends Employee {

    private double salary;

    //constructor
    public SalaryEmployee(double salary, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.salary = salary;
        setId(id);
    }

    //getter for salary 
    public double getSalary() {
        return salary;
    }

    @Override
    public double calculatePay() {
        return salary / 52;
    }

    @Override
    public String toString() {
        return "employee " + getId() + ": " + getLastName() + ", " + getFirstName() + "\n" + "Salary: " + getSalary() + "\n";
    }

}
