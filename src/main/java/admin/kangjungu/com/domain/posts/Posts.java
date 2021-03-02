package admin.kangjungu.com.domain.posts;

import admin.kangjungu.com.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) // title 컬럼 제작
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // content 컬럼 제작
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
