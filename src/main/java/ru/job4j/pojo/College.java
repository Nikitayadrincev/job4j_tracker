package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nikita Yadrincev");
        student.setGroup("MDM-24-03");
        student.setAdmission(new Date());

        System.out.println(student.getName() + " admission " + student.getGroup()
                + ": " + student.getAdmission());
    }
}
