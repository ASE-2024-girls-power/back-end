package project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import project.entity.ChapterID;
import project.entity.Paragraph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class ParagraphRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Test
    public void findByChapterId_success() {
        // given
        ChapterID chapterID = new ChapterID();
        chapterID.setStoryId(3);
        chapterID.setChapterNum(4);

        Paragraph paragraph_1 = new Paragraph();
        paragraph_1.setChapterId(chapterID);
        paragraph_1.setText("This is paragraph 1.");

        entityManager.persist(paragraph_1);

        Paragraph paragraph_2 = new Paragraph();
        paragraph_2.setChapterId(chapterID);
        paragraph_2.setText("This is paragraph 2.");

        entityManager.persist(paragraph_2);

        Paragraph paragraph_3 = new Paragraph();
        paragraph_3.setChapterId(chapterID);
        paragraph_3.setText("This is paragraph 3.");

        entityManager.persist(paragraph_3);
        entityManager.flush();

        // when
        List<Paragraph> found = paragraphRepository.findByChapterIdOrderByIdAsc(chapterID);

        // then
        assertEquals(found.size(), 3);
        assertEquals(found.get(0).getText(), paragraph_1.getText());
        assertEquals(found.get(1).getText(), paragraph_2.getText());
        assertEquals(found.get(2).getText(), paragraph_3.getText());
    }
}
