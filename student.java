package lap6;

public class student extends Employee {
	public student(String name, int age, int id) {
        super(name, age, id, 0.0); 
    }

  
    @Override
    public void setBonus(double bonus) {
        System.out.println("Cannot add bonus to a student.");
        super.setBonus(0); 
    }

   
    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Status: Intern (No Payment)]";
    }
}


