package community;

public class Student {
    private String name;
    private int age;
    private final int ID;
    private static int idAux = 0;

    public Student(String name, int age) {
        this.ID = generateID();
        setName(name);
        setAge(age);
    }

    private synchronized int generateID() {
        return idAux++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Student [ID= " + getId()  + ", name= " + getName() + ", age=" + getAge() + "]";
    }

}
