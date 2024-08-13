package data;

import community.*;
import institution.UniversityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Data {
    public List<Teacher> teachers = new ArrayList<>();
    public List<Student> students = new ArrayList<>();
    public List<UniversityClass> universityClasses = new ArrayList<>();

    public Data() {
        // Full time teachers hired
        teachers.add(new FullTimeTeacher("Pedrito Peréz", 4500, 10));
        teachers.add(new FullTimeTeacher("Stephany Sanchez", 5500, 11));
        teachers.add(new FullTimeTeacher("Jennifer Lopez", 3500, 2));
        teachers.add(new FullTimeTeacher("María Chica", 8500, 0));
        // Part-time teachers hired
        teachers.add(new FullTimeTeacher("Pedro Sanchez", 5500, 10));
        teachers.add(new FullTimeTeacher("Jennifer Vinasco", 5500, 8));
        teachers.add(new FullTimeTeacher("Jorge Muñoz", 6500, 21));

        // Students
        students.add(new Student("Pedro Sanchez", 20));
        students.add(new Student("Yurleydi Veléz", 22));
        students.add(new Student("Pepito Peréz", 15));
        students.add(new Student("Valerius Mina", 25));

        // Available Classes
        universityClasses.add(new UniversityClass("Biology", "Classroom 101", assignTeacher("Pedrito Peréz","Biology"), new ArrayList<>(students)));
        universityClasses.add(new UniversityClass("Math"));
        universityClasses.add(new UniversityClass("Art", "Classroom 404", assignTeacher("Jennifer Vinasco","Art"), new ArrayList<>(students)));
    }

    private Teacher assignTeacher(String teacherName, String subject) {
        Optional<Teacher> optionalTeacher = teachers.stream().filter(t -> t.getName().equals(teacherName)).findFirst();
        Teacher t =  optionalTeacher.orElse(new EmptyTeacher());
        if(!t.getClass().getSimpleName().equals("EmptyTeacher")){
            t.setSubject(subject);
        }
        return t;
    }

}