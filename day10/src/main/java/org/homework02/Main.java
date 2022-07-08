package org.homework02;

import org.homework02.entity.Student;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    private Student[] A;
    private Student[] B;


    public static void main(String[] args) {
        Student stu01 = new Student("stu01","male",11);
        Student stu02 = new Student("stu02","male",13);
        Student stu03 = new Student("stu02","male",13);
        Student stu04 = new Student("stu04","male",15);

        Student[] stuA = new Student[3];
        stuA[0] = stu01;
        stuA[1] = stu02;
        stuA[2] = stu03;

        Student[] stuB = new Student[3];
        stuB[0] = stu01;
        stuB[1] = stu03;
        stuB[2] = stu04;

        System.out.println( Arrays.toString(stuA));
        System.out.println(Arrays.toString(stuB));
        System.out.println(Arrays.toString(mergeStudent(stuA, stuB)));

    }

    public static Student[] mergeStudent(Student[] stuA,Student[] stuB){
        if (stuA == null ) return stuB;
        if (stuB == null ) return stuA;

        HashSet<Student> set = new HashSet<>();

        for (int i = 0; i < stuA.length; i++) {
            set.add(stuA[i]);
        }

        for (int i = 0; i < stuB.length; i++) {
            set.add(stuB[i]);
        }

        Student[] stu = new Student[set.size()];
        set.toArray(stu);
        return stu;
    }
}
