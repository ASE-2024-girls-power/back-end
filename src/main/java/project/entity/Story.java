package project.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "STORY")
public class Story implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int writerId;

    @Column(nullable = false)
    private int totalChapterNum;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String summary;

    @ManyToMany
    private List<Tag> tags;

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getTotalChapterNum() {
        return totalChapterNum;
    }

    public void setTotalChapterNum(int totalChapterNum) {
        this.totalChapterNum = totalChapterNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getId() {
        return id;
    }
}
