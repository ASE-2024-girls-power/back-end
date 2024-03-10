package project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import project.entity.Chapter;
import project.entity.ChapterID;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class ChapterRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChapterRepository chapterRepository;

    @Test
    public void findById_success() {
        // given
        ChapterID id = new ChapterID();
        id.setStoryId(3);
        id.setChapterNum(4);

        Chapter chapter = new Chapter();
        chapter.setId(id);
        chapter.setTitle("chapter 4");

        entityManager.persist(chapter);
        entityManager.flush();

        // when
        ChapterID id_new = new ChapterID();
        id_new.setStoryId(3);
        id_new.setChapterNum(4);
        Optional<Chapter> found = chapterRepository.findById(id_new);

        // then
        assertEquals(found.get().getTitle(), chapter.getTitle());
    }

    @Test
    public void findByStoryId_success() {
        // given
        ChapterID id_1 = new ChapterID();
        id_1.setStoryId(3);
        id_1.setChapterNum(4);

        Chapter chapter_1 = new Chapter();
        chapter_1.setId(id_1);
        chapter_1.setTitle("chapter 4");

        entityManager.persist(chapter_1);

        ChapterID id_2 = new ChapterID();
        id_2.setStoryId(3);
        id_2.setChapterNum(5);

        Chapter chapter_2 = new Chapter();
        chapter_2.setId(id_2);
        chapter_2.setTitle("chapter 5");

        entityManager.persist(chapter_2);
        entityManager.flush();

        // when
        List<Chapter> found = chapterRepository.findById_StoryId(3);

        // then
        assertEquals(found.size(), 2);
        assertEquals(found.get(0).getTitle(), chapter_1.getTitle());
        assertEquals(found.get(1).getTitle(), chapter_2.getTitle());
    }
}
