package com.example.demo.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentEnitity;

public interface StudentRepo extends JpaRepository<StudentEnitity, Integer>{

}
