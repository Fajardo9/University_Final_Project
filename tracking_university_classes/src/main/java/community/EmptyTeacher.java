package community;

public class EmptyTeacher extends Teacher {
    public EmptyTeacher() {
        setName("Teacher not Asigned");
        setSalaryPerHour(0);
        setTotalSalary(calculateTotalSalary());
    }

    @Override
    public double calculateTotalSalary() {
        return 0;
    }
}
