import java.util.Scanner;

class Employee_Detail {
    int employee_ID;
    String name;
    String designation;
    int salary;
    public Employee_Detail(int employee_ID, String name, String designation, int salary) {
        this.employee_ID = employee_ID;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    public void display() {
        System.out.println("Employee ID: " + employee_ID);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }
}
public class Lab6_34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();
        Employee_Detail[] emp = new Employee_Detail[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter the employee details for employee "+(i+1)+": ");
            System.out.println("Enter the employee ID: ");
            int employee_ID = sc.nextInt();
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the designation: ");
            String designation = scanner.nextLine();
            System.out.println("Enter the salary: ");
            int salary = sc.nextInt();
            emp[i] = new Employee_Detail(employee_ID, name, designation, salary);
        }
        for(int i=0; i<n; i++) {
            System.out.println("Details of employee "+(i+1)+": ");
            emp[i].display();
        }
        sc.close();
        scanner.close();
    }
}
