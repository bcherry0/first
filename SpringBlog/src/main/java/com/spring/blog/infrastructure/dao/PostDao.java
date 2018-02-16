package com.spring.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.blog.domain.model.Entity.Post;

public interface PostDao extends JpaRepository<Post, Integer> {
}
