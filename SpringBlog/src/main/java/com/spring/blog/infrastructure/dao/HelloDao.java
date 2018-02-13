package com.spring.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.domain.model.Entity.Hello;

public interface HelloDao extends JpaRepository <Hello, Integer> {

}