package com.andersenlab.main;

import com.andersenlab.entities.Course;
import com.andersenlab.entities.Student;
import com.andersenlab.template.CourseJDBCTemplate;
import com.andersenlab.template.StudentJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Main class where all functionality are implement
 *
 * @author Vlad Badilovskii
 * @version 100500
 */
public class Project {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("StudentJDBCTemplate");
        CourseJDBCTemplate courseJDBCTemplate = (CourseJDBCTemplate) context.getBean("CourseJDBCTemplate");

        studentJDBCTemplate.create("Valera Pupkin");
        studentJDBCTemplate.create("Vova Frolov");


        List<Student> students = studentJDBCTemplate.listStudents();
        System.out.println("~~~~~~~~TABLE STUDENTS~~~~~~~~~~");
        System.out.println("       id       ||     name     ");
        System.out.println("--------------------------------");

        for (Student record : students) {
            System.out.println("       " + record.getStudentId() + "            " + record.getStudentName());
        }

        System.out.println("--------------------------------");
        System.out.println();

        courseJDBCTemplate.create("Biology");
        courseJDBCTemplate.create("History");
        List<Course> courses = courseJDBCTemplate.listCourses();
        System.out.println("~~~~~~~~TABLE COURSES~~~~~~~~~~~");
        System.out.println("       id       ||     name     ");
        System.out.println("--------------------------------");
        for (Course record : courses) {
            System.out.println("       " + record.getCourseId() + "            " + record.getCourseName());

        }

        studentJDBCTemplate.addCourseToStudent(110, 72);


    }
}
