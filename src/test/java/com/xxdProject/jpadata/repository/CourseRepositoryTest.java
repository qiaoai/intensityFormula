package com.xxdProject.jpadata.repository;

import com.xxdProject.jpadata.entity.Course;
import com.xxdProject.jpadata.entity.Student;
import com.xxdProject.jpadata.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.print.attribute.standard.PageRanges;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> courses = repository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("join")
                .lastName("hhaha")
                .build();

        Course course = Course.builder().title("python").credit(6).teacher(teacher).build();

        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        List<Course> courses = repository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = repository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPage= repository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("courses = " + courses);

    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,2, Sort.by("title")
        );

        Pageable sortByCreaditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by(("credit"))));

        List<Course> courses = repository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

//    @Test
//    public void printfindByTitleContaining(){
//        Pageable firstPageTenRecords =
//                PageRequest.of(0,10);
//        List<Course> courses = repository.findByTitleContaining("j", firstPageTenRecords);
//        System.out.println("courses ="+ courses);
//    }
    @Test
    public void savaCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("lazy")
                .lastName("Morgan")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        Student student = Student.builder()
                .lastName("jjj")
                .firstName("pppp")
                .emailId("343@qq.com")
                .build();

        course.addStudents(student);
        repository.save(course);

    }
}