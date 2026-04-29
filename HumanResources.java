package lap6;

import java.util.stream.Stream; 
import java.util.Objects;      
import java.util.Comparator;    

public final class HumanResources {
	private Employee emp1;
    private Employee emp2;
    private student stu1;
    private student stu2;

 
    public void addPerson(person person) {
        
        if (person instanceof student) {
           
            if (stu1 == null) {
                stu1 = (student) person;
                System.out.println("Student added.");
            } else if (stu2 == null) {
                stu2 = (student) person;
                System.out.println("Student added.");
            } else {
                System.out.println("Student capacity is full.");
            }
            
        } else if (person instanceof Employee) {
            if (emp1 == null) {
                emp1 = (Employee) person;
                System.out.println("Employee added.");
            } else if (emp2 == null) {
                emp2 = (Employee) person;
                System.out.println("Employee added.");
            } else {
                System.out.println("Employee capacity is full.");
            }
        }
    }

    public void updateBonus(int id, double bonus) {
        if (emp1 != null && emp1.getId() == id) {
            emp1.setBonus(bonus);
            System.out.println("Bonus updated for " + emp1.getName());
            return;
        }
        if (emp2 != null && emp2.getId() == id) {
            emp2.setBonus(bonus);
            System.out.println("Bonus updated for " + emp2.getName());
            return;
        }

        if ((stu1 != null && stu1.getId() == id) || (stu2 != null && stu2.getId() == id)) {
            System.out.println("Trying to update bonus for student ID " + id + "...");
            if(stu1 != null && stu1.getId() == id) stu1.setBonus(bonus);
            if(stu2 != null && stu2.getId() == id) stu2.setBonus(bonus);
            return;
        }
        
        System.out.println("Person with ID " + id + " not found.");
    }

    public void displayAll() {
        System.out.println("\n--- Employees ---");
        if (emp1 != null) System.out.println(emp1);
        if (emp2 != null) System.out.println(emp2);

        System.out.println("\n--- Students (Interns) ---");
        if (stu1 != null) System.out.println(stu1);
        if (stu2 != null) System.out.println(stu2);
       
    }

    
    public void displayEmployeesSalaryGreaterThan5000() {
        System.out.println("\n--- [LAB 11] Employees with Salary > 5000 (Descending) ---");
        
        
        Stream.of(emp1, emp2)
            .filter(Objects::nonNull) 
            .filter(e -> e.calculateTotalSalary() > 5000) 
            .sorted(Comparator.comparingDouble(Employee::calculateTotalSalary).reversed())  
            .forEach(System.out::println); 
            
    }

   
    public void displayEmployeesAge40Salary3000() {
        System.out.println("\n--- [LAB 11] Employees (Age > 40 AND Salary < 3000) ---");
        
        Stream.of(emp1, emp2)
            .filter(Objects::nonNull) 
            .filter(e -> e.getAge() > 40 && e.calculateTotalSalary() < 3000)  
            .forEach(System.out::println); 

        
    }
}