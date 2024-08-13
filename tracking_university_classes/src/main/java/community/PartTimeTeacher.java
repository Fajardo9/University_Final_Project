package community;

public class PartTimeTeacher extends Teacher{
    private int totalHoursPerMonth = 0;
    private double salaryPerWeek;
    public PartTimeTeacher(String name,double salaryPerHour,int initialHours ){
        super.setName(name);
        super.setSalaryPerHour(salaryPerHour);
        setTotalHoursPerMonth(initialHours);
    }

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
    public double calculateTotalSalary() {
        setTotalSalary(getSalaryPerHour()*getTotalHoursPerMonth());
        return 0;
    }
}
