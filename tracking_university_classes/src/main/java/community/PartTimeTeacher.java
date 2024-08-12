package community;

public class PartTimeTeacher extends Teacher{
    private int totalHoursPerMonth = 0;
    private double salaryPerWeek;
    public PartTimeTeacher(){}

    public int getTotalHoursPerMonth() {
        return totalHoursPerMonth;
    }

    public void setTotalHoursPerMonth(int totalHoursPerMonth) {
        this.totalHoursPerMonth = totalHoursPerMonth;
    }

    public double getSalaryPerWeek() {
        return salaryPerWeek;
    }

    public void setSalaryPerWeek(double salaryPerWeek) {
        this.salaryPerWeek = salaryPerWeek;
    }

    public void calculateWeeklySalary(int hoursPerWeek){
        setSalaryPerWeek((hoursPerWeek * hoursPerWeek));
        setTotalHoursPerMonth(totalHoursPerMonth+hoursPerWeek);
    }
    @Override
    public void calculateTotalSalary() {
        setTotalSalary(getSalaryPerHour()*getTotalHoursPerMonth());
    }
}
