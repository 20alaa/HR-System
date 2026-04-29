package lap6;

public class Employee extends person {
	protected int id;
    protected double basicSalary;
    protected double bonus;

    public Employee(String name, int age, int id, double basicSalary) {
        super(name, age); 
        this.id = id;
        this.basicSalary = basicSalary;
        this.bonus = 0;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    // Setters 
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public double calculateTotalSalary() {
        return this.basicSalary + this.bonus;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", " + super.toString() + 
               ", Total Salary=" + calculateTotalSalary() + "]";
    }
}
