package GUI;

import institution.University;

import java.util.Scanner;

public class Menus {

    public void setUniversity(University university) {
        this.university = university;
    }

    University university;


    public Menus(University university) {
        setUniversity(university);
    }

    public void administrativeMenu(University university) {
        Scanner input = new Scanner(System.in);
        int option;
        do {
            System.out.println("Welcome to " + university.getName() + " University \n" +
                    "Enter 1 for list menu. \n" +
                    "Enter 2 for edit menu");
            option = input.nextInt();
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
                "Enter 0 to exit");
        option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                System.out.println(university.listClasses() + "\n");
                System.out.println("Do you want to know more about one specific class? (Y/N) ");
                String choice = input.nextLine().toLowerCase();
                if (choice.equals("y")) {
                    System.out.println("Enter the name of the class. ");
                    String cName = input.nextLine();
                    System.out.println(university.getInfoClassByName(cName) + "\n");
                } else if (choice.equals("n")) {
                    System.out.println("Do yo want to do anything else. ");
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
                listMenu(university);
                break;
            case 2:
                System.out.println(university.listTeachers());
                break;
            case 3:
                System.out.println(university.listStudents());
                break;
            case 4:
                System.out.println("Enter the name of the student: ");
                String name = input.nextLine();
                System.out.println(university.listClassByStudent(name));
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
                "Enter 3 to add an student \n" +
                "Enter 4 to add a teacher to a class. \n" +
                "Enter 5 to add an student to a class \n" +
                "Enter 6 to add o modify the classroom for a class. \n" +
                "Enter 0 to go back to the principal menu");
        option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                addClass(university, input);
                break;
            case 2:
                addTeacher(university, input);
                break;
            case 3:
                addStudent(university, input);
                break;
            case 4:
                addTeacherToClass(university, input);
                break;
            case 5:
                System.out.println("Enter the name of the class: ");
                String cName = input.nextLine();
                System.out.println("Enter the name of the student");
                String studentName = input.nextLine();
                System.out.println(university.addStudentToClass(cName, studentName));
                break;
            case 6:
                System.out.println("Enter the name of the class");
                String className = input.nextLine();
                System.out.println("Enter the new classroom");
                String newClassroom = input.nextLine();
                System.out.println(university.modifyClass(className, newClassroom));
                break;
            default:
                System.out.println("Invalid option");
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
        int age = input.nextInt();
        university.addStudent(name, age);
    }

    public void addTeacher(University university, Scanner input) {
        System.out.println("Enter the type of teacher: \n" +
                "Enter 1 to add a full-time teacher: \n" +
                "Enter 2 to add a part-time teacher \n" +
                "Enter 0 to go back to the principal menu");
        int optionT = input.nextInt();
        switch (optionT) {
            case 1:
                System.out.println("Enter the name of the full-time teacher. ");
                String teacherName = input.nextLine();
                System.out.println("Enter the base salary per hour.");
                double baseSalary = input.nextDouble();
                System.out.println("Enter the experience years.");
                int experienceYears = input.nextInt();
                university.addTeacher(teacherName, experienceYears, baseSalary);
                break;
            case 2:
                System.out.println("Enter the name of the part-time teacher. ");
                String partTimeName = input.nextLine();
                System.out.println("Enter the base salary per hour.");
                double salaryPerHour = input.nextDouble();
                System.out.println("Enter the initial hours per week");
                int initialHours = input.nextInt();
                university.addTeacher(partTimeName, salaryPerHour, initialHours);
            default:
                System.out.println("Enter a valid option");
                break;
        }

    }

    public void addClass(University university, Scanner input) {
        System.out.println("Enter the name of the class: ");
        String className = input.nextLine();
        input.next();
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
}
