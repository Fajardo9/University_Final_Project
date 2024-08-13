import GUI.Menus;
import community.*;
import data.Data;
import institution.University;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        University university = new University("University del Valle",
                data.teachers,
                data.students,
                data.universityClasses);
        Menus menu = new Menus(university);
        menu.administrativeMenu(university);
    }


}
