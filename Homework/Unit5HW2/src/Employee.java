public class Employee {

    private final String employeeName;
    private double currentSalary;

    public Employee (String employeeName, double currentSalary) {
        this.employeeName = employeeName;
        this.currentSalary = currentSalary;
    }

    public String getName() {
        return employeeName;
    }

    public double getSalary() {
        return currentSalary;
    }

    public void raiseSalary(double byPercent) {
        currentSalary *= (byPercent/100); //Convert percent to decimal
    }
}
