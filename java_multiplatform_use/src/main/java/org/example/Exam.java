package org.example;

public class Exam
{
    private String nameOfExam, nameOfTeacher;
    private int examGrade;

    public Exam(String nameOfExam, int examGrade, String nameOfTeacher) {
        this.nameOfExam = nameOfExam;
        this.nameOfTeacher = nameOfTeacher;
        this.examGrade = examGrade;
    }

    public String getNameOfExam() {
        return nameOfExam;
    }

    public void setNameOfExam(String nameOfExam) {
        this.nameOfExam = nameOfExam;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public int getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(int examGrade) {
        this.examGrade = examGrade;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "nameOfExam='" + nameOfExam + '\'' +
                ", nameOfTeacher='" + nameOfTeacher + '\'' +
                ", examGrade=" + examGrade +
                '}';
    }
}
