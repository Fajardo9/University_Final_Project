package community;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;
    public final int HOURS_PER_MONTH = 160;

    public FullTimeTeacher(String name, double salaryPerHour, int experienceYears, String subject) {}
    public FullTimeTeacher(String name, double salaryPerHour, int experienceYears) {
        super.setName(name);
        super.setSalaryPerHour(salaryPerHour);
        setExperienceYears(experienceYears);
        super.setTotalSalary(salaryPerHour);
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary((HOURS_PER_MONTH * getSalaryPerHour())*(experienceYears *1.1));
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
