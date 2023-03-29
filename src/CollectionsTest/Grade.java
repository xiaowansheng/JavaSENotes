package CollectionsTest;

public class Grade implements Comparable<Grade>{
    private int studentNumber;
    private String name;
    private int grade;

    public Grade(int studentNumber, String name, int grade) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.grade = grade;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Grade o) {
        return this.studentNumber-o.studentNumber;
    }
}
