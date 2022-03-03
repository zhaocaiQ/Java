package blog.blogProject.repository;

import blog.blogProject.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    //입력받은 검색어 게시글 찾기
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
