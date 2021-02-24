package admin.kangjungu.com.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> //JpaRepositoey 상속<Entity class, PK타입을 지정한다.
{

}
