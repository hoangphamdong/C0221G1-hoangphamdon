package com.example.create_app_blog.model.repository;

import com.example.create_app_blog.model.entity.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository  extends PagingAndSortingRepository<Blog,Integer> {
}
