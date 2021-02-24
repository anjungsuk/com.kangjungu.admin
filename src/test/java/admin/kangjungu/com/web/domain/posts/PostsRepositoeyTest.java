package admin.kangjungu.com.web.domain.posts;

import admin.kangjungu.com.domain.posts.PostRepository;
import admin.kangjungu.com.domain.posts.Posts;
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
public class PostsRepositoeyTest
{
    @Autowired
    PostRepository postsRepository;

    @After
    public void cleanup()
    {
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기()
    {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // posts 테이블에 insert 또는 update 쿼리문 생성
                .title(title)
                .content(content)
                .author("rusarmata@naver.com")
                .build());
        List<Posts> postsList = postsRepository.findAll(); // posts 테이블 안 DB 데이터 조회 쿼리 대체

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
