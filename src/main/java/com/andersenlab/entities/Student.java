package com.andersenlab.entities;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity "student" for database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class Student {
    private Long studentId;
    private String studentName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "student_course"
            , joinColumns = {@JoinColumn(name = "student_id")}
            , inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<Course>();


    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student() {
    }

    /**
     * Getter for studentId parameter
     *
     * @return id of needed student
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Setter for  studentId parameter
     *
     * @param studentId is key parameter
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter for studentName parameter
     *
     * @return name of needed student
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Setter for studentName parameter
     *
     * @param studentName is key parameter
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Getter for list of courses
     *
     * @return list of all courses
     */
    public Set<Course> getCourses() {
        return courses;
    }

    /**
     * Setter for list of students
     *
     * @param courses is key parameter
     */
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    /**
     * Method for visual display of student object
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courses=" + courses +
                '}';
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        return courses != null ? courses.equals(student.courses) : student.courses == null;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        return result;
    }
}
