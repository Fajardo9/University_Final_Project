package community;

public abstract class Teacher {
    protected String name = "";
    private double salaryPerHour;
    private double totalSalary;
    private String subject = "";
    public  String getName(){
        return name;
    }

    public  void setName(String name){
        this.name = name;
    };

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public abstract double calculateTotalSalary();

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    @Override
    public String toString() {
        return "Teacher: " + name + " of the subject: " + subject;
    }
}