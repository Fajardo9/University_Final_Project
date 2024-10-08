package community;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;
    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void calculateBaseSalary() {
        this.baseSalary = (HOURS_PER_MONTH* getSalaryPerHour());
    }

    public final int HOURS_PER_MONTH = 160;

    public FullTimeTeacher(String name, double salaryPerHour, int experienceYears) {
        super.setName(name);
        super.setSalaryPerHour(salaryPerHour);
        setExperienceYears(experienceYears);
        calculateBaseSalary();
        super.setTotalSalary(calculateTotalSalary());
    }

    @Override
    public double calculateTotalSalary() {
        if(experienceYears > 0){
            return (getBaseSalary())*(getExperienceYears() *1.1);
        }
        else  return getBaseSalary();
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
