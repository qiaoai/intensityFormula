package com.xxdProject.jpadata.repository;

import antlr.collections.List;
import com.xxdProject.jpadata.entity.Course;
import com.xxdProject.jpadata.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

@SpringBootTest
class TeacherResporityTest {

    @Autowired
    private TeacherRespority teacherRespority;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("xx")
                .lastName("dd")
//                .courses(Arrays.asList(course, courseJava))
                .build();

        teacherRespority.save(teacher);
    }


}