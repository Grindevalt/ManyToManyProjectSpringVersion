package com.andersenlab.mapper;

import com.andersenlab.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for creating connection with student table in database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class StudentMapper implements RowMapper {

    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getLong("id"));
        student.setStudentName(resultSet.getString("name"));

        return student;
    }
}
