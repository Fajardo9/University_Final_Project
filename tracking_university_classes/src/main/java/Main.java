import GUI.Menus;
import data.Data;
import institution.University;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        University university = new University("University del Valle",
                data.teachers,
                "Electronic Engineers",
                data.students,
                data.universityClasses);
        Menus menu = new Menus(university);
        menu.principalMenu(university);
    }


}
