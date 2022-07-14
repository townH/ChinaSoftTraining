package com.icis.mappg;

import java.util.Objects;

public class Student2 {
    private String stuName;
    private Integer stuAge;

    public Student2(String stuName, Integer stuAge) {
        this.stuName = stuName;
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return Objects.equals(stuName, student2.stuName) &&
                Objects.equals(stuAge, student2.stuAge);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stuName, stuAge);
    }
}
