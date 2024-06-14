package com.hibernate.materJpa;


import com.hibernate.materJpa.entities.Course;
import com.hibernate.materJpa.entities.Student;
import com.hibernate.materJpa.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.gen5.api.Assertions.assertEquals;



//@SpringBootTest(classes = MaterJpaApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
public class CourseRepositoryTest {
 
    @Autowired
    CourseRepository courseRepository;

    Course course;
    Student student;

    @BeforeEach
    public void init() {

        course = new Course(1L, "Math");
        courseRepository.save(course);

    }

    @Test
    void testFindCourseById_existingCourse() {
        // Testing for an existing course ID
        Long courseId = 1L;
        String expectedCourse = "Math";
        String result = courseRepository.findCourseById(courseId).getName();
        assertEquals(expectedCourse, result);
    }

   @Transactional
   @Test
    void testIfElementIsDeleted() {
        // Testing for an existing course ID
        Long courseId = 1L;

        courseRepository.deleteCourseById(courseId);
        Course result = courseRepository.findCourseById(courseId);
        assertEquals(null, result);
    }

}
