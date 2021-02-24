package admin.kangjungu.com.web.dto;

import admin.kangjungu.com.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponceDto
{
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponceDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
