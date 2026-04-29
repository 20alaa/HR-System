package lap6;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        HumanResources hr = new HumanResources();
        
        while (true) {
            System.out.println("\n--- HR System Menu ---");
            System.out.println("1. Add Person");
            System.out.println("2. Update Employee Bonus");
            System.out.println("3. Display All");
            System.out.println("4. Display Employees (Salary > 5000)"); 
            System.out.println("5. Display Employees (Age > 40 & Salary < 3000)");
            System.out.println("6. Exit"); 
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                
                System.out.print("Enter Basic Salary (Enter 0 for Student): ");
                double salary = scanner.nextDouble();

                person person;
                if (salary <= 0) {
                    person = new student(name, age, id);
                } else {
                    person = new Employee(name, age, id, salary);
                }
                hr.addPerson(person);

            } else if (choice == 2) {
                System.out.print("Enter ID to update bonus: ");
                int id = scanner.nextInt();
                System.out.print("Enter Bonus amount: ");
                double bonus = scanner.nextDouble();
                hr.updateBonus(id, bonus);

            } else if (choice == 3) {
                hr.displayAll();

            } else if (choice == 4) {
                hr.displayEmployeesSalaryGreaterThan5000(); // 

            } else if (choice == 5) {
                hr.displayEmployeesAge40Salary3000(); // 

            } else if (choice == 6) { 
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
		
}