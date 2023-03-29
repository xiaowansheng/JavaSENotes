package HashMapTest;

import java.util.Objects;

public class Grade {
    private int grade;

    public Grade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return grade == grade1.grade;
    }


    @Override
    public String toString() {
        return "Grade" +
                "=" + grade +
                ' ';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
