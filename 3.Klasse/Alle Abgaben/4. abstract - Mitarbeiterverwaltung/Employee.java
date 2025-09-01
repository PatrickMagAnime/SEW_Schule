public abstract class Employee {
    // attributes
    private String name;
    private int employeeNumber;
    private String department;

    public abstract double calculateSalary();

    public String showInformation(){
        return toString();
    }
public String getName(){
        return this.name;
}
    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + name + '\'' +
                ", Total Employees=" + employeeNumber +
                ", Department='" + department + '\'' +
                '}';
    }

    public Employee(String name, int employeeNumber, String department) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.department = department;
    }

    public void workDepartment(){
        System.out.println(this.name +" works in "+ this.department);
    }

}
