package blog.blogProject.service;

import blog.blogProject.entity.Board;
import blog.blogProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //게시글 작성 처리
    public void write(Board board, MultipartFile file) throws Exception {
        //프로젝트 경로 변수 저장
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        //랜덤으로 이름 생성
        UUID uuid = UUID.randomUUID();
        //랜덤과 원래 파일이름 합쳐서 저장
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        board.setFilename(fileName);
        board.setFilepath("/files/" + fileName);
        board.setWriteDate(LocalDateTime.now());
        boardRepository.save(board);
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    //게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    //검색한 키워드 리스트 불러오기
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable) {
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }
    //특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }

    //게시글 업로드 처리
    public void update(Board board) {
        boardRepository.save(board);
    }
}
