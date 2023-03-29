package ObjectOutputStreamTest;

import java.io.Serializable;

public class Student implements Serializable {
    //java虚拟机看到这个类实现Serializable接口后，会自动生成序列化版本号
    //这里如果没有手写出来，java虚拟机会默认提供序列化版本号
    //建议将序列化版本号手动写出来，不建议自动生成！
    private static final long serialVersionUID=2018313869L;
    //java虚拟机识别一个类，先通过类名，如果类名相同，则是通过比较序列化版本号

    private String name;
    private char sex;
    //以后这个类的源码发生改动了
    // 源码改动后，需要重新编译，生成新的字节码文件
    //并且class在运行的时候，java虚拟机生成的序列号也会发生相应的改变

    // transient关键字，表示游离的，不参与序列化
    private transient int age;//age不参与序列化

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
