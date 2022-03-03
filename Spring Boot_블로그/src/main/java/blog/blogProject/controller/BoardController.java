package blog.blogProject.controller;

import blog.blogProject.entity.Board;
import blog.blogProject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시글 쓰기 페이지
    @GetMapping("/board/write")
    public String boardWrite() {
        return "boardwrite";
    }

    //게시글 저장하기
    @PostMapping("/board/published")
    public String published(Board board, MultipartFile file) throws  Exception{
        boardService.write(board, file);
        return "redirect:/";
    }

    //게시글 리스트 페이지
    @GetMapping("/")
    public String boardList(Model model,
                            @PageableDefault(page = 0, size=9, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                            String searchKeyword) {

        Page<Board> list = null;
        if(searchKeyword != null) {
            list = boardService.boardSearchList(searchKeyword, pageable);
        } else {
            list = boardService.boardList(pageable);
        }

        //현재페이지 가져오기(0부터시작하기 때문에 +1 해줌)
        int nowPage = list.getPageable().getPageNumber() + 1;

        int startPage = 1;
        int totalPage = list.getTotalPages();
        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("totalPage", totalPage);
        return "boardlist";
    }

    //특정 게시글 보기 페이지
    @GetMapping("/board/view")
    public  String boardview(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    //게시글 삭제하기
    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        return "redirect:/";
    }

    //게시글 수정 페이지
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }

    //게시글 수정하기
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, String title, String content, String filename, String filepath) {

        Board boardTemp = boardService.boardView(id);
        boardTemp.update(title, content, filename, filepath);
        boardService.update(boardTemp);
        return "redirect:/board/view?id={id}";
    }
}
