package institution;

import community.Student;
import community.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<Class> classList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }
    public void addStudent(String name, int age, int id) {
        studentList.add(new Student(name, age, id));
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    public University(String name, List<Teacher> teacherList, List<Student> studentList, List<Class> classList) {}
}
