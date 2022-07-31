package com.xxdProject.jpadata.repository;

import com.xxdProject.jpadata.entity.Guardian;
import com.xxdProject.jpadata.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest  {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("xxd@qq.com")
                .firstName("xxd")
                .lastName("noah")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("xxx")
                .email("123@dd")
                .mobile("123232323232")
                .build();

        Student student = Student.builder()
                .emailId("ccc@qq.com")
                .firstName("cfdfd")
                .lastName("fdfd")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentlist = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("d");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("xxx");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        String name = studentRepository.getStudentFistNameByEmailAddress("xxd@qq.com");
        System.out.println("Student = " + name);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student students = studentRepository.getStudentByEmailAddressNative("xxd@qq.com");
        System.out.println("Student = " + students);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student students = studentRepository.getStudentByEmailAddressNativeNamedParam("xxd@qq.com");
        System.out.println("Student = " + students);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("clj","ccc@qq.com");
    }

}