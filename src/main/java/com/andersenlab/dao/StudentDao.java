package com.andersenlab.dao;

import com.andersenlab.entities.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * Interface for creating data access object for student entity
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public interface StudentDao {
    /**
     * Method for setting dataSource
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource);

    /**
     * Method for adding course to student
     *
     * @param studentId is key parameter for searching needed student
     * @param courseId is key parameter for searching needed course
     */
    public void addCourseToStudent(long studentId, long courseId);

    /**
     * Method for creating new course
     *
     * @param name is main parameter of existing database
     */
    public void create(String name);

    /**
     * Method for finding student by id
     *
     * @param id is key parameter for searching needed student
     * @return needed student object
     */
    public Student getStudent(Long id);

    /**
     * Method for showing list of  all students
     *
     * @return list of all students
     */
    public List<Student> listStudents();

    /**
     * Method for removing student from database by id
     *
     * @param id is key parameter for searching needed student
     */
    public void delete(Long id);

    /**
     * Method for updating data in database
     *
     * @param id is key parameter for searching needed student
     * @param name is updating element
     */
    public void update(Long id, String name);
}
