import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Programmer extends Employee{
    private double hourlyWage;
    private int workedHours;
    private ArrayList<String> programmingLanguages;
    private String project;

    @Override
    public double calculateSalary(){
        return hourlyWage * workedHours;
    }
    public void writeCode(){
        System.out.println(getName()+" works on project "+this.project);
    }
    public void showprogrammingLanguages(){
        System.out.println(getName()+" know the following progra,ming languages: "+this.programmingLanguages);
    }
    public Programmer(double hourlyWage, int workedHours, String project, String name, int employeeNumber, String department,ArrayList<String>programmingLanguages){
        super(name,employeeNumber,department);
        this.hourlyWage=hourlyWage;
        this.workedHours=workedHours;
        this.project=project;
        this.programmingLanguages=programmingLanguages;

    }
}
