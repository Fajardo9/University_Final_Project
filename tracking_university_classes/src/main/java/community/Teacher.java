package community;

public abstract class Teacher {
    private String name;
    private double salary;
    private String subject;

    public abstract String getName();

    public abstract void setName(String name);

    public double getSalary() {
        return salary;
    }

    public abstract void calculateSalary(int hours, double salaryPerHour);

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}