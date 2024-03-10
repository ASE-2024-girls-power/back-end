package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "CHAPTER")
public class Chapter implements Serializable {

    @EmbeddedId
    private ChapterID id;

    @Column(nullable = false, unique = true)
    private String title;

    public ChapterID getId() {
        return id;
    }

    public void setId(ChapterID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
