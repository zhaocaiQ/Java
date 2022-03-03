package blog.blogProject.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data //getter?
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;

    private String filename;
    private String filepath;

    @Column(name = "c_date")
    private LocalDateTime writeDate;

    //게시글 수정 정보 받아오는 함수
    public void update(String title, String content, String filename, String filepath) {
        this.title = title;
        this.content = content;
        this.filename = filename;
        this.filepath = filepath;

    }
}
