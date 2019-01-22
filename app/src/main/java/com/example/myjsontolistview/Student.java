package com.example.myjsontolistview;

public class Student {

    private String idno, lastname, firstname, course, level;

    public Student(String idno, String lastname, String firstname, String course, String level) {
        this.idno = idno;
        this.lastname = lastname;
        this.firstname = firstname;
        this.course = course;
        this.level = level;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
