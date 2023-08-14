package com.example.practice01.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //test가 끝날때마다 수행되는 메소드, 테스트용 데이터 삭제
    public  void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void  게시글저장_불러오기(){
        String title = "테스트게시글";
        String content = "테스트 본문";
        //테이블에 insert/update 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.con")
                .build());

        //테이블 posts에 있는 모든 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
