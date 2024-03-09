package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "PARAGRAPH")
public class Paragraph {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private ChapterID chapterId;

    @Lob
    @Column(nullable = false)
    private String text;

    public ChapterID getChapterId() {
        return chapterId;
    }

    public void setChapterId(ChapterID chapterId) {
        this.chapterId = chapterId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
