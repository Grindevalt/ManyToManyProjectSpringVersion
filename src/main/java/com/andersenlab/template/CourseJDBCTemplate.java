package com.andersenlab.template;

import com.andersenlab.dao.CourseDao;
import com.andersenlab.entities.Course;
import com.andersenlab.entities.Student;
import com.andersenlab.mapper.CourseMapper;
import com.andersenlab.mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Class for working with database
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class CourseJDBCTemplate implements CourseDao {
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
     * Method for creating new course
     *
     * @param name is key parameter
     */

    public void create(String name) {
        String SQL = "insert into Course (name) values (?)";
        jdbcTemplateObject.update(SQL, name);
        System.out.println("Created Record Name = " + name);
        return;
    }

    /**
     * Method for finding course by id
     *
     * @param id is key parameter for searching
     * @return found course from database
     */

    public Course getCourse(Long id) {
        String SQL = "select * from Course where id = ?";
        Course course = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new CourseMapper());
        return course;
    }

    /**
     * Method for showing list of  all courses
     *
     * @return list of all courses
     */

    public List<Course> listCourses() {
        String SQL = "select * from course";
        List<Course> courses = jdbcTemplateObject.query(SQL, new CourseMapper());
        return courses;
    }

    /**
     * Method for removing course from database by id
     *
     * @param id is key parameter for searching
     */
    public void delete(Long id) {
        String SQL = "delete from course where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    /**
     * Method for updating data in database
     *
     * @param id   is key parameter for searching
     * @param name is updating element
     */

    public void update(Long id, String name) {
        String SQL = "update Course set name = ? where id = ?";
        jdbcTemplateObject.update(SQL, name, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}
