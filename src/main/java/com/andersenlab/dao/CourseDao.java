package com.andersenlab.dao;

import com.andersenlab.entities.Course;

import javax.sql.DataSource;
import java.util.List;

/**
 * Interface for creating data access object for course entity
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public interface CourseDao {
    /**
     * Method for setting dataSource
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource);

    /**
     * Method for creating new course
     *
     * @param name is key parameter
     */
    public void create(String name);

    /**
     * Method for finding course by id
     *
     * @param id is key parameter for searching
     * @return found course from database
     */
    public Course getCourse(Long id);

    /**
     * Method for showing list of  all courses
     *
     * @return list of all courses
     */
    public List<Course> listCourses();

    /**
     * Method for removing course from database by id
     *
     * @param id is key parameter for searching
     */
    public void delete(Long id);

    /**
     * Method for updating data in database
     *
     * @param id   is key parameter for searching
     * @param name is updating element
     */
    public void update(Long id, String name);
}
