package community;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Class {
    private String name = "";
    private String assignedClassroom = "";
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private LocalTime startTime;

    public Class(String name) {
        setClassName(name);
        setTeacher(new EmptyTeacher());
        setAssignedClassroom("Classroom not assigned");
    }
    public Class(String name, String assignedClassroom, Teacher teacher, List<Student> students) {
        setClassName(name);
        setAssignedClassroom(assignedClassroom);
        setTeacher(teacher);
        setStudents(students);
        setStartTime(LocalTime.now());
    }

    public  String getClassName(){
        return name;
    }

    public void setClassName(String name) {
        this.name = name;
    }

    public String getAssignedClassroom() {
        return assignedClassroom;
    }

    public void setAssignedClassroom(String assignedClassroom){
        this.assignedClassroom = assignedClassroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
    public String listStudents(){
        return students.stream().map(Student::toString).
                collect(Collectors.joining("\n"));
    }

    public  void setStudents(List<Student> students){
        this.students = students;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}
