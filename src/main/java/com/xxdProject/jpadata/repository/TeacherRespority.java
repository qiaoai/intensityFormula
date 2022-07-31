package com.xxdProject.jpadata.repository;

import com.xxdProject.jpadata.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRespority extends JpaRepository<Teacher,Long> {
}
