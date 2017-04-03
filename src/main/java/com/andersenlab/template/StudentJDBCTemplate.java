package com.andersenlab.template;

import com.andersenlab.dao.StudentDao;
import com.andersenlab.entities.Course;
import com.andersenlab.entities.Student;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

import com.andersenlab.mapper.CourseMapper;
import com.andersenlab.mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Class for working with database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class StudentJDBCTemplate implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * Method for setting dataSource
     *
     * @param dataSource
     */

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * Method for adding course to student
     *
     * @param studentId is key parameter for searching needed student
     * @param courseId  is key parameter for searching needed course
     */


    public void addCourseToStudent(long studentId, long courseId) {
        String SQL = "insert into student_course(student_id, course_id) values (?,?)";
        jdbcTemplateObject.update(SQL, studentId, courseId);
        System.out.println("Course id successfully added to student");
    }

    /**
     * Method for creating new course
     *
     * @param name is main parameter of existing database
     */

    public void create(String name) {
        String SQL = "insert into Student (name) values (?)";
        jdbcTemplateObject.update(SQL, name);
        System.out.println("Created Record Name = " + name);
    }

    /**
     * Method for finding student by id
     *
     * @param id is key parameter for searching needed student
     * @return needed student object
     */

    public Student getStudent(Long id) {
        String SQL = "select * from Student where id = ?";
        Student student = (Student) jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    /**
     * Method for showing list of  all students
     *
     * @return list of all students
     */

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    /**
     * Method for removing student from database by id
     *
     * @param id is key parameter for searching needed student
     */


    public void delete(Long id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    /**
     * Method for updating data in database
     *
     * @param id   is key parameter for searching needed student
     * @param name is updating element
     */

    public void update(Long id, String name) {
        String SQL = "update Student set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}
