package blog.blogProject.repository;

import blog.blogProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}
