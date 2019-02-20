package employeemanagementSystem;

/**
 *
 * @author Mostafa
 */
public class HourlyEmployee extends Employee {

    private int numHours;
    private double hourlyRate;

    public HourlyEmployee(int numHours, double hourlyRate, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.numHours = numHours;
        this.hourlyRate = hourlyRate;
        
    }

    //getter for numHour
    public int getNumHours() {
        return numHours;
    }

    //getter for hourlyRate
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculatePay() {
        return numHours * hourlyRate;
    }

    @Override
    public String toString() {
        return "employee " + getId() + ": " + getLastName() + ", " + getFirstName() + "\n"
                + "Hours: " + numHours + "\n" + "Rate: " + "$" + hourlyRate + "\n";
    }
}
