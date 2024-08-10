package community;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Class {
    private String name;
    private String assignedClassroom;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private LocalTime startTime;

    public abstract String getClassName();

    public void setClassName(String name) {
        this.name = name;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public abstract void setAssignedClassroom(String assignedClassroom);

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public abstract void setStudents(List<Student> students);

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
