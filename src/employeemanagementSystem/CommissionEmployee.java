package employeemanagementSystem;

/**
 *
 * @author Mostafa
 */
public class CommissionEmployee extends Employee {

    private double rate;
    private double sales;

    //constructor 
    public CommissionEmployee(double rate, double sales, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.rate = rate;
        this.sales = sales;

    }

    //getter for rate
    public double getRate() {
        return rate;
    }

    //getter for sales
    public double getSales() {
        return sales;
    }

    //override calculatePay method
    @Override
    public double calculatePay() {
        return (sales * rate) / 100;
    }

    @Override
    public String toString() {
        return "employee " + getId() + ": " + getLastName() + ", " + getFirstName() + "\n"
                + "Commission Rate: " + rate + "\n" + "Sales: " + "$" + sales + "\n";
    }
}
