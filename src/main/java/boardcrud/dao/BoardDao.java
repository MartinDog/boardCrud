package boardcrud.dao;

import boardcrud.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardDao extends JpaRepository<Board,Long> {
    //게시판 조회
    Optional<Board> findById(Long id);

    //게시글 삭제
    void deleteById(Long id);

    //보드 id생성을 위한 갯수 조회 로직
    Long countBy();

}
