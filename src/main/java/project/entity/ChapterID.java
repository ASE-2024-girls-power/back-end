package project.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChapterID implements Serializable {
    private int storyId;
    private int chapterNum;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }
}