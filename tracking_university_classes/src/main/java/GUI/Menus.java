package GUI;

import community.Student;
import institution.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menus {

    public void setUniversity(University university) {
        this.university = university;
    }

    University university;


    public Menus(University university) {
        setUniversity(university);
    }

    public void principalMenu(University university) {
        Scanner input = new Scanner(System.in);
        System.out.println("----*** Welcome to " + university.getName() + " ***---- \n" +
                "Enter 1 for administrative menu. \n" +
                "Enter 2 for teachers menu. \n" +
                "Enter 3 for students menu. \n" +
                "Enter 0 to exit.");
        int choice = getValidNumberInput(input);
        switch (choice) {
            case 1:
                administrativeMenu(university, input);
                break;
            case 2:
                teacherMenu(university, input);
                principalMenu(university);
                break;
            case 3:
                studentMenu(university, input);
                principalMenu(university);
                break;
            case 0:
                System.exit(0);
        }

    }

    public void administrativeMenu(University university, Scanner input) {
        int option;
        do {
            System.out.println("Welcome back to " + university.getName() + " University \n" +
                    "Enter 1 for list menu. \n" +
                    "Enter 2 for edit menu");
            option = getValidNumberInput(input);
            switch (option) {
                case 1:
                    listMenu(university);
                    break;
                case 2:
                    editMenu(university);
                    break;
            }
        } while (option != 0);
    }

    public void listMenu(University university) {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("Enter 1 to list available classes. \n" +
                "Enter 2 to list available teachers. \n" +
                "Enter 3 to list enrolled students. \n" +
                "Enter 4 to list classes by student's name. \n" +
                "Enter 5 to list students' lists \n" +
                "Enter 0 to return to the previous menu.");
        option = getValidNumberInput(input);
        switch (option) {
            case 1:
                System.out.println(university.listClasses() + "\n");
                System.out.println("Do you want to know more about one specific class? (Y/N) ");
                String choice = input.nextLine().toLowerCase();
                if (choice.equals("y")) {
                    System.out.println("Enter the name of the class. ");
                    String cName = input.nextLine();
                    System.out.println(university.getClassInfoByName(cName) + "\n");
                } else if (choice.equals("n")) {
                    System.out.println("Do yo want to do anything else. ");
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
                listMenu(university);
                break;
            case 2:
                System.out.println(university.listTeachers());
                listMenu(university);
                break;
            case 3:
                System.out.println(university.listStudents());
                listMenu(university);
                break;
            case 4:
                System.out.println("Enter the name of the student: ");
                String name = input.nextLine();
                System.out.println(university.listClassesByStudent(name));
                listMenu(university);
                break;
            case 5:
                System.out.println(university.listStudentLists());
                listMenu(university);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void editMenu(University university) {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("Enter 1 to add a class. \n" +
                "Enter 2 to add a teacher. \n" +
                "Enter 3 to add an student. \n" +
                "Enter 4 to add an student list. \n" +
                "Enter 5 to add a teacher to a class. \n" +
                "Enter 6 to add an student to a class \n" +
                "Enter 7 to add o modify the classroom for a class. \n" +
                "Enter 0 to go back to the principal menu");
        option = getValidNumberInput(input);
        switch (option) {
            case 1:
                addClass(university, input);
                editMenu(university);
                break;
            case 2:
                addTeacher(university, input);
                editMenu(university);
                break;
            case 3:
                addStudent(university, input);
                editMenu(university);
                break;
            case 4:
                addListOfStudents(university, input);
                editMenu(university);
                break;
            case 5:
                addTeacherToClass(university, input);
                editMenu(university);
                break;
            case 6:
                System.out.println("Enter the name of the class: ");
                String cName = input.nextLine();
                System.out.println("Enter the name of the student");
                String studentName = input.nextLine();
                System.out.println(university.addStudentToClass(cName, studentName));
                editMenu(university);
                break;
            case 7:
                System.out.println("Enter the name of the class");
                String className = input.nextLine();
                System.out.println("Enter the new classroom");
                String newClassroom = input.nextLine();
                System.out.println(university.modifyClass(className, newClassroom));
                editMenu(university);
                break;
            case 0:
                System.out.println("Returning to the principal menu.");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public void addTeacherToClass(University university, Scanner input) {
        System.out.println("Enter the name of the teacher: ");
        String name = input.nextLine();
        System.out.println("Enter the name of the class: ");
        String className = input.nextLine();
        System.out.println(university.assignTeacher(name, className));
    }

    public void addStudent(University university, Scanner input) {
        System.out.println("Enter the name of the student: ");
        String name = input.next();
        System.out.println("Enter the age of the student: ");
        int age = getValidNumberInput(input);
        university.addStudent(name, age);
    }

    public void addTeacher(University university, Scanner input) {
        System.out.println("Enter the type of teacher: \n" +
                "Enter 1 to add a full-time teacher: \n" +
                "Enter 2 to add a part-time teacher \n" +
                "Enter 0 to go back to the principal menu");
        int optionT = getValidNumberInput(input);
        switch (optionT) {
            case 1:
                System.out.println("Enter the name of the full-time teacher. ");
                String teacherName = input.nextLine();
                System.out.println("Enter the base salary per hour.");
                double baseSalary = input.nextDouble();
                System.out.println("Enter the experience years.");
                int experienceYears = getValidNumberInput(input);
                university.addTeacher(teacherName, experienceYears, baseSalary);
                break;
            case 2:
                System.out.println("Enter the name of the part-time teacher. ");
                String partTimeName = input.nextLine();
                System.out.println("Enter the base salary per hour.");
                double salaryPerHour = input.nextDouble();
                System.out.println("Enter the initial hours per week");
                int initialHours = getValidNumberInput(input);
                university.addTeacher(partTimeName, salaryPerHour, initialHours);
            default:
                System.out.println("Enter a valid option");
                break;
        }

    }

    public void addClass(University university, Scanner input) {
        System.out.println("Enter the name of the class: ");
        String className = input.nextLine();
        System.out.println("Do you want to add all the others parameters to the class? (Y/N): \n");
        String option2 = input.next().trim().toLowerCase();
        switch (option2) {
            case "y":
                System.out.println("Enter the name of the classroom: ");
                String classroom = input.nextLine();
                System.out.println("Enter the name of the teacher: ");
                String teacher = input.nextLine();
                System.out.println("Enter the name of the list of students: ");
                String listName = input.nextLine();
                university.addClass(className, classroom, teacher, listName);
                break;
            case "n":
                System.out.println("Enter the name of the teacher: ");
                String teacherOnly = input.nextLine();
                university.addClass(className, teacherOnly);
                break;
            default:
                System.out.println("Enter a valid option");
                break;

        }

    }

    public void teacherMenu(University university, Scanner input) {
        System.out.println("Please enter your name to see all your information: ");
        String tName = input.nextLine();
        System.out.println(university.getTeacherInfoByName(tName));
    }

    public void studentMenu(University university, Scanner input) {
        System.out.println("Please enter your name to see all your information: ");
        String sName = input.nextLine();
        System.out.println(university.getStudentInfoByName(sName) + "\n" +
                university.listClassesByStudent(sName) + "\n");
        System.out.println("Do you want to enroll in a course? (Y/N): ");
        String option = input.nextLine().trim().toLowerCase();
        if (option.equals("y")) {
            System.out.println("Enter the name of the class: ");
            String className = input.nextLine();
            System.out.println(university.addStudentToClass(sName, className));
        } else if (option.equals("n")) {
            System.out.println("Returning to the previous menu \n");
        } else {
            System.out.println("Enter a valid option \n" +
                    "Returning to the previous menu \n");
        }
    }

    private void addListOfStudents(University university, Scanner input) {
        System.out.println("Enter the id of the list of students: ");
        String listID = input.nextLine();
        System.out.println("Enter the size of the list you want to add: ");
        int size = input.nextInt();
        input.nextLine();
        List<Student> newStudents = createNewListOfStudents(size, input);
        university.addStudentList(listID, newStudents);
    }

    public List<Student> createNewListOfStudents(int size, Scanner input) {
        int counter = 0;
        List<Student> newListStudents = new ArrayList<>();
        while (counter < size) {
            System.out.println("Enter the name of the student" + (counter + 1) + ": ");
            String name = input.nextLine();
            System.out.println("Enter the age of the student" + (counter + 1) + ": ");
            int age = input.nextInt();
            input.nextLine();
            newListStudents.add(new Student(name, age));
            counter++;
        }
        return newListStudents;
    }

    static int getValidNumberInput(Scanner sc) {
        int number;
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                break;
            } else {
                System.out.println("Please, enter a valid option.");
                sc.nextInt();
            }
        }
        sc.nextLine();
        return number;
    }

}
