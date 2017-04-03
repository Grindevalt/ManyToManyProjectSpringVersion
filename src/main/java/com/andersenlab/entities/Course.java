package com.andersenlab.entities;

import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity "course" for database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class Course {
    private Long courseId;
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<Student>();

    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter for courseId parameter
     *
     * @return needed id of needed course
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * Setter for courseId parameter
     *
     * @param courseId is key parameter
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter for courseName parameter
     *
     * @return name of searching course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter for courseName parameter
     *
     * @param courseName is key parameter
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter for list of courses
     *
     * @return list of all courses
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Setter for list of courses
     *
     * @param students is input list of courses
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    /** Method for visual display of course object
     * @return
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", students=" + students +
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

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        return students != null ? students.equals(course.students) : course.students == null;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        return result;
    }
}
