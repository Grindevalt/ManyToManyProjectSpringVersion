package com.andersenlab.mapper;

import com.andersenlab.entities.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Class for creating connection with course table in database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class CourseMapper implements RowMapper<Course> {

    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getLong("id"));
        course.setCourseName(rs.getString("name"));
        return course;
    }
}
