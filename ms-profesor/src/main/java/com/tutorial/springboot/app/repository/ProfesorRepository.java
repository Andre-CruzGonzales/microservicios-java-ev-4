package com.tutorial.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springboot.app.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

}
