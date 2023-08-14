package com.example.practice01.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//entity와 함께있어야하는 jpa repository 인터페이스
// extends JpaRepository<Posts, Long>-> crud 메소드가 자동으로 생성됨
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
