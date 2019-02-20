package employeemanagementSystem;

/**
 *
 * @author Mostafa
 */
public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;

    //one three-arg cinstructor
    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //setter for id
    public void setId(int id) {
        this.id = id;
    }

    //setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter for id
    public int getId() {
        return id;
    }

    //getter for firstName
    public String getFirstName() {
        return firstName;
    }

    //getter for lastName
    public String getLastName() {
        return lastName;
    }

    //abstract calculatePay method
    public abstract double calculatePay();

    //toString method
    public abstract String toString();
}
