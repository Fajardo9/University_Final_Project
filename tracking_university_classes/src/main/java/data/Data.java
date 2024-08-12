package data;

import community.FullTimeTeacher;
import community.Student;
import community.Teacher;
import community.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Data {
    public List<Teacher> teachers = new ArrayList<>();
    public List<Student> students = new ArrayList<>();
    public List<Class>  classes = new ArrayList< >();
    public Data() {
        /*
        * Full time teachers hired
        * */
        teachers.add(new FullTimeTeacher("Pedrito Peréz",4500, 10));
        teachers.add(new FullTimeTeacher("Stephany Sanchez",5500, 11));
        teachers.add(new FullTimeTeacher("Jennifer Lopez",3500, 2));
        teachers.add(new FullTimeTeacher("María Chica",8500, 0));
        /*
        *Part-time teachers hired
        **/
        teachers.add(new FullTimeTeacher("Pedro Sanchez",5500, 10));
        teachers.add(new FullTimeTeacher("Jennifer Vinasco",5500, 8));
        teachers.add(new FullTimeTeacher("Jorge Muñoz",6500, 21));

        /*
        * Students :D
        **/
        students.add(new Student("Pedro Sanchez", 20));
        students.add(new Student("Yurleydi Veléz", 22));
        students.add(new Student("Pepito Peréz", 15));
        students.add(new Student("Valerius Mina", 25));
        /*
        * Available Classes
        **/

        classes.add(new Class("Biology","Classroom 101",
                assignTeacher("Pepito Peréz"), students ));
        classes.add(new Class("Math"));
        classes.add(new Class("Art", "Classroom 404",
                assignTeacher("Jennifer Vinasco"), students ));
    }
    private Teacher assignTeacher(String teacherName){
        Optional<Teacher> optionalTeacher = teachers.stream().
                filter(t -> t.getName().equals(teacherName)).findFirst();
        return optionalTeacher.orElse(null);
    }

}
