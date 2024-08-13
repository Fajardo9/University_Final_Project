package community;

public class Student {
    private String name;
    private int age;
    private final int ID;
    private static int idGen = 0;

    public Student(String name, int age) {
        this.ID = generateID();
        setName(name);
        setAge(age);
    }

    private synchronized int generateID() {
        return idGen++;
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
        return "Student [ID= " + ID  + ", name= " + name + ", age=" + age + "]";
    }

}
