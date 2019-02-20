package employeemanagementSystem;

import java.util.InputMismatchException;

/**
 *
 * @author Mostafa
 */
public class EmployeeManagementDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int employeeNum = 0;
        int employeeType = 1;
        int employeeId = 0;
        int reportType = 0;
        boolean flag = true;
        //loop for try_catch 
        while (flag == true) {
            try {
                java.util.Scanner input = new java.util.Scanner(System.in);
                System.out.print("How many employee to create? ");
                employeeNum = input.nextInt();
                flag = false;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer");
            }
        }
        Employee[] employeeList = new Employee[employeeNum];
        for (int i = 0; i < employeeNum; i++) {
            do {
                try {
                    java.util.Scanner input = new java.util.Scanner(System.in);
                    System.out.printf("Employee data for " + (i + 1) + " of " + employeeNum
                            + "%nchoose type of employee to add.%n1. Salaried%n2. Hourly%n3. Commission: ");
                    employeeType = input.nextInt();
                    if (employeeType == 1 || employeeType == 2 || employeeType == 3) {
                        flag = true;
                    } else {
                        System.out.println("Please choose between choices");
                        flag = false;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter a valid number");
                }
            } while (flag == false);
            java.util.Scanner input3 = new java.util.Scanner(System.in);
            switch (employeeType) {
                case 1:
                    do {
                        employeeId = idChecker(employeeList);
                    } while (employeeId == -1);
                    String employeeFirstName = firstNameCreator();
                    String employeeLastName = lastNameCreator();
                    System.out.println("Salary: ");
                    double employeeSalary = (double) input3.nextDouble();
                    employeeList[i] = new SalaryEmployee(employeeSalary, employeeId, employeeFirstName, employeeLastName);
                    break;
                case 2:
                    do {
                        employeeId = idChecker(employeeList);
                    } while (employeeId == -1);
                    employeeFirstName = firstNameCreator();
                    employeeLastName = lastNameCreator();
                    System.out.print("Hours Worked: ");
                    int employeeHours = (int) input3.nextInt();
                    System.out.print("Hourly Rate: ");
                    double employeeHourRate = (double) input3.nextDouble();
                    employeeList[i] = new HourlyEmployee(employeeHours, employeeHourRate, employeeId, employeeFirstName, employeeLastName);
                    break;
                case 3:
                    do {
                        employeeId = idChecker(employeeList);
                    } while (employeeId == -1);
                    employeeFirstName = firstNameCreator();
                    employeeLastName = lastNameCreator();
                    System.out.print("Commision Rate: ");
                    int employeeCommissionRate = input3.nextInt();
                    System.out.print("Sales: ");
                    double employeeSales = (double) input3.nextDouble();
                    employeeList[i] = new CommissionEmployee(employeeCommissionRate, employeeSales, employeeId, employeeFirstName, employeeLastName);
                    break;
            }
        }
        do {
            do {
                try {
                    java.util.Scanner input2 = new java.util.Scanner(System.in);
                    System.out.printf("Please choose a Report.%n1. Employee listing%n2. payroll listing%n3. Exit: ");
                    reportType = input2.nextInt();
                    if (employeeType == 1 || employeeType == 2 || employeeType == 3) {
                        flag = true;
                    } else {
                        System.out.println("Please choose between choices");
                        flag = false;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter a valid number");
                }

            } while (flag == false);
            switch (reportType) {
                case 1:
                    displayEmployeeInfo(employeeList);
                    break;
                case 2:
                    displayEmployeeRole(employeeList);
                    break;
            }
        } while (reportType != 3);

    }

    public static int idChecker(Employee[] List) {
        boolean flag = true;
        int employeeId = 0;

        while (flag == true) {
            try {
                java.util.Scanner input = new java.util.Scanner(System.in);
                System.out.print("Employee ID: ");
                employeeId = input.nextInt();
                flag = false;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number");
            }
        }

        while (flag == false) {
            if (List[0] == null) {
                flag = true;
                return employeeId;
            } else {
                for (int i = 0; i < List.length; i++) {
                    if (employeeId == List[i].getId()) {
                        System.out.println("The entered id is already existed");
                        employeeId = -1;
                        return employeeId;
                    } else {
                        flag = true;
                    }
                    return employeeId;
                }
            }
        }
        return employeeId;
    }

    public static String firstNameCreator() {
        boolean flag = false;
        String firstName = null;
        while (flag == false) {
            try {
                java.util.Scanner input = new java.util.Scanner(System.in);
                System.out.print("First name: ");
                firstName = input.nextLine();
                flag = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid first name");
            }
        }
        return firstName;
    }

    public static String lastNameCreator() {
        boolean flag = false;
        String lastName = null;
        while (flag == false) {
            try {
                java.util.Scanner input = new java.util.Scanner(System.in);
                System.out.print("Last name: ");
                lastName = input.nextLine();
                flag = true;
            } catch (InputMismatchException ex) {
                System.out.print("Please enter a valid last name");
            }
        }
        return lastName;
    }

    public static void displayEmployeeInfo(Employee[] employeeList) {
        for (int i = 0; i < employeeList.length; i++) {
            System.out.print(employeeList[i].toString());

        }

    }

    public static void displayEmployeeRole(Employee[] employeeList) {
        for (int i = 0; i < employeeList.length; i++) {
            System.out.print("Weekly pay for " + employeeList[i].getLastName()
                    + ", " + employeeList[i].getFirstName() + "employee id "
                    + employeeList[i].getId() + " is " + employeeList[i].calculatePay() + "\n");
        }
    }

}
