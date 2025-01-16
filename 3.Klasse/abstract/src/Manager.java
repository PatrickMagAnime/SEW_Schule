public class Manager extends Employee{
    // attributes
    private double salary;
    private double bonus;
    private int teamSize;

    @Override
    public double calculateSalary(){
// the total salary is the sum of the base salary and the bonus
        return bonus + salary;
    }

    public Manager(double salary, double bonus, int teamSize, String name, int employeeNumber, String department){
        super(name,employeeNumber,department);
        this.bonus=bonus;
        this.salary=salary;
        this.teamSize=teamSize;
    }

    public void conductMeeting(){
        System.out.println(super.getName()+" has a meeting with their team of "+this.teamSize+" employees");
    }
}
