package community;

public class EmptyTeacher extends Teacher {
    public EmptyTeacher() {
        setName("Teacher not Assigned");
        setSalaryPerHour(0);
        setTotalSalary(calculateTotalSalary());
    }

    @Override
    public double calculateTotalSalary() {
        return 0;
    }
}
