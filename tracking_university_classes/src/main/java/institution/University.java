package institution;

import community.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class University {
    private String name;
    private HashMap<String, List<Student>> listStudentsList = new HashMap<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<UniversityClass> universityClassList = new ArrayList<>();

    public University(String name, List<Teacher> teacherList, String nameOfStudentList,List<Student> studentList, List<UniversityClass> universityClassList) {
        setName(name);
        setTeacherList(teacherList);
        setStudentList(studentList);
        addStudentList(nameOfStudentList,studentList);
        setClassList(universityClassList);
    }
    public University(String name){
        setName(name);
        setTeacherList(Collections.emptyList());
        addStudentList("-",Collections.emptyList());
        setClassList(Collections.emptyList());
    }

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

    public void addStudentList(String idOfTheStudentsGroup, List<Student> studentList) {
        getStudentList().addAll(studentList);
        this.listStudentsList.put(idOfTheStudentsGroup, studentList);
    }
    public List<UniversityClass> getClasses() {
        return universityClassList;
    }
    public void setClassList(List<UniversityClass> universityClassList) {
        this.universityClassList = universityClassList;
    }
    private Optional<UniversityClass> getClassByName(String className) {
        String cName = className.trim().toLowerCase();
        return getClasses().stream().filter(c -> c.getClassName().trim().toLowerCase()
                .equals(cName)).findFirst();
    }
    private Optional<Student> getStudentByName(String studentName) {
        String s = studentName.trim().toLowerCase();
        return getStudentList().stream().filter(p -> p.getName().trim().toLowerCase().
                equals(s)).findFirst();
    }
    private Optional<Teacher> getTeacherByName(String teacherName) {
        String teacherSelected = teacherName.trim().toLowerCase();
        return getTeacherList().stream().filter(t -> t.getName().trim()
                .toLowerCase().equals(teacherSelected)).findFirst();
    }
    public String getClassInfoByName(String className){
        Optional<UniversityClass> optionalClass = getClassByName(className);
        if(optionalClass.isPresent()){
            UniversityClass c = optionalClass.get();
            return c.toString();
        }else return "Class not found";
    }
    public String getTeacherInfoByName(String teacherName){
        Optional<Teacher> optionalTeacher = getTeacherByName(teacherName);
        if(optionalTeacher.isPresent()){
            Teacher t = optionalTeacher.get();
            return t.toString();
        }else return "Teacher not found";
    }
    public String getStudentInfoByName(String studentName){
        Optional<Student> optionalStudent = getStudentByName(studentName);
        if(optionalStudent.isPresent()){
            Student s = optionalStudent.get();
            return s.toString();
        }else return "Student not found";
    }
    private List<Student> getStudentListById(String  idList){
        List<Student> optionalStudentList = listStudentsList.get(idList);
        if(optionalStudentList == null || optionalStudentList.isEmpty()){
            return Collections.emptyList();
        }else return optionalStudentList;
    }

    public String modifyClass(String className, String newClassroom){
        Optional<UniversityClass> c = getClassByName(className);
        if (c.isPresent()) {
            c.get().setAssignedClassroom(newClassroom);
            return "Class "  + c.get().getClassName() + " has been modified";
        }else{
            return "Class "  + className + " doesn't exist";
        }
    }

    public void addClass(String className, String classroomName, String teacherName, String idOfTheStudentList) {
        Optional<Teacher> teacherAssigned = getTeacherByName(teacherName);
        List<Student> listOfStudentAssign = getStudentListById(idOfTheStudentList);
        if (teacherAssigned.isPresent() && !listOfStudentAssign.isEmpty() ) {
            Teacher teacher = teacherAssigned.get();
            universityClassList.add(new UniversityClass(className,classroomName,teacher, listOfStudentAssign));
        } else if(teacherAssigned.isPresent()){
            Teacher teacher = teacherAssigned.get();
            universityClassList.add(new UniversityClass(className,classroomName, teacher));
        }else {
            System.out.println("Teacher not found");
        }
    }public void addClass(String className, String teacherName) {
        Optional<Teacher> teacherAssigned = getTeacherByName(teacherName);
        if (teacherAssigned.isPresent()) {
            Teacher teacher = teacherAssigned.get();
            universityClassList.add(new UniversityClass(className,teacher));
        } else {
            System.out.println("Teacher not found");
        }
    }
    /*
    Add a full-time teacher to the list of the teachers available
     */
    public void addTeacher(String name, int experienceYears, double salaryPerHour) {
        teacherList.add(new FullTimeTeacher(name, salaryPerHour, experienceYears));
    }

    /*
    Add a part-time teacher to the list of the teachers available
     */
    public void addTeacher(String name, double salaryPerHour, int initialHours) {
        teacherList.add(new PartTimeTeacher(name, salaryPerHour, initialHours));
    }

    public void addStudent(String name, int age) {
        studentList.add(new Student(name, age));
    }
    public String assignTeacher(String teacherName, String className) {
        String message;
        Optional<Teacher> optionalTeacher = getTeacherByName(teacherName);
        Optional<UniversityClass> optionalUniversityClass = getClassByName(className);
        if(optionalTeacher.isPresent() && optionalUniversityClass.isPresent()) {
            Teacher t = optionalTeacher.get();
            UniversityClass c = optionalUniversityClass.get();
            if(t.getSubject().isEmpty()){
                t.setSubject(className);
                c.setTeacher(t);
                message = String.format("Teacher %s has been assigned to %s", teacherName, className);
            }else {
                message = "The teacher: " + t.getName() + " already has an subject assigned  ";
            }
        }else if (!optionalTeacher.isPresent()) {
            message = "The teacher " + teacherName + " does not exist";
        }else {
            message = "The class " + className + " does not exist";
        }
        return message;
    }

    public String listClasses() {
        return universityClassList.stream().map(UniversityClass::toString)
                .collect(Collectors.joining("\n"));
    }
    public String listTeachers() {
        return teacherList.stream().map(Teacher::toString)
                .collect(Collectors.joining("\n"));
    }
    public String listStudents() {
        return studentList.stream().map(Student::toString)
                .collect(Collectors.joining("\n"));
    }
    public String listClassesByStudent(String student) {
        Optional<Student> optionalStudent = getStudentByName(student);
        StringBuilder result = new StringBuilder();
        if (optionalStudent.isPresent()) {
            Student selectedStudent = optionalStudent.get();
            result.append("The classes enrolled for the student ").
                    append(selectedStudent.getName()).append(" are as follows:\n");

            List<UniversityClass> enrolledUniversityClasses = universityClassList.stream()
                    .filter(c -> getStudentList().contains(selectedStudent))
                    .collect(Collectors.toList());

            enrolledUniversityClasses.forEach(c -> result.append("Class Name: ").append(c.getClassName())
                    .append(" classroom: ").append(c.getAssignedClassroom())
                    .append(" Teacher assigned: ").append(c.getTeacher().getName()).append("\n"));

            return result.toString();
        } else {
            return "Student not found";
        }
    }
    public String listStudentLists(){
        StringBuilder listOfAvailableStudentsList = new StringBuilder();
        listOfAvailableStudentsList.append("Available Students List:\n");
        for(String listName : listStudentsList.keySet()){
            listOfAvailableStudentsList.append("The list ").append(listName).append("\n");
        }
        return listOfAvailableStudentsList.toString();
    }

    public String addStudentToClass(String cName, String studentName) {
        Optional<Student> student = getStudentByName(studentName);
        Optional<UniversityClass> optionalClass = getClassByName(cName);
        boolean studentAlreadyAdded;

        if (optionalClass.isPresent() && student.isPresent()) {
            UniversityClass c = optionalClass.get();
            Student s = student.get();
            Predicate<Student> isStudentAlreadyAdded = p -> p.getId() == s.getId();
            studentAlreadyAdded = c.getStudents().stream().anyMatch(isStudentAlreadyAdded);

            if (!studentAlreadyAdded) {
                c.addStudent(s);
                return ("Student " + s.getName() + " added to the class");
            } else {
                return("The student is already in the class");
            }
        } else if (!student.isPresent()) {
            return("Student not found");
        } else {
            return("Class not found");
        }
    }

}
