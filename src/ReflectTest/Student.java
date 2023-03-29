package ReflectTest;

/**
 * 反射属性Field
 */
public class Student {
    //Field翻译为字段，就是属性/成员
    //4个Field,分别采用不同的访问控制符修饰
    public int studentId;
    protected String name;
    char sex;
    private int age;

    public static final double PI=3.1415926;

    public Student() {
    }

    public Student(int studentId, String name, char sex, int age) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(int studentId, String name, char sex) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
    }

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Student(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
