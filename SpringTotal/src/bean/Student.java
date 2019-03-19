package bean;

public class Student {
    private int number;
    private String img;
    private String name;
    private int age;
    private String major;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student(int number, String img, String name, int age, String major) {
        this.number = number;
        this.img = img;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Student() {
    }
}
