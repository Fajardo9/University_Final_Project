package community;

public class Student {
    private String name;
    private int age;
    private int id;
public Student(String name, int age, int id) {
    setName(name);
    setAge(age);
    setId(id);
}
    public String getName(){
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
