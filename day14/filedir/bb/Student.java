package com.icis.mappg;

public class Student {
    private String stuName;
    private Integer stuAge;

    public Student(String stuName, Integer stuAge) {
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
}
