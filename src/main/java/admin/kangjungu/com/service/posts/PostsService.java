package admin.kangjungu.com.service.posts;

import admin.kangjungu.com.domain.posts.PostRepository;
import admin.kangjungu.com.domain.posts.Posts;
import admin.kangjungu.com.web.dto.PostsListResponseDto;
import admin.kangjungu.com.web.dto.PostsResponceDto;
import admin.kangjungu.com.web.dto.PostsSaveRequestDto;
import admin.kangjungu.com.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService
{
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    @Transactional
    public PostsResponceDto findById(Long id) {
        Posts entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponceDto(entity);
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc()
    {

        return postRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }
}
