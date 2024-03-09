package project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import project.entity.Chapter;
import project.entity.ChapterID;
import project.entity.Paragraph;
import project.entity.Story;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class StoryRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StoryRepository storyRepository;
    @Test
    public void findById_success() {
        // given
        Story story = new Story();
        story.setWriterId(12);
        story.setTitle("new story");
        story.setSummary("new summary");
        story.setTotalChapterNum(0);

        entityManager.persist(story);
        entityManager.flush();

        // when
        Optional<Story> found = storyRepository.findById(story.getId());

        // then
        assertEquals(found.get().getWriterId(), story.getWriterId());
        assertEquals(found.get().getTitle(), story.getTitle());
        assertEquals(found.get().getSummary(), story.getSummary());
        assertEquals(found.get().getTotalChapterNum(), story.getTotalChapterNum());
    }
    @Test
    public void findByWriterId_success() {
        // given
        Story story_1 = new Story();
        story_1.setWriterId(12);
        story_1.setTitle("new story1");
        story_1.setSummary("new summary");
        story_1.setTotalChapterNum(0);

        entityManager.persist(story_1);

        Story story_2 = new Story();
        story_2.setWriterId(12);
        story_2.setTitle("new story2");
        story_2.setSummary("new summary");
        story_2.setTotalChapterNum(0);

        entityManager.persist(story_2);

        entityManager.flush();

        // when
        List<Story> found = storyRepository.findByWriterIdOrderByIdDesc(12);

        // then
        assertEquals(found.size(), 2);
        assertEquals(found.get(0).getTitle(), story_2.getTitle());
        assertEquals(found.get(1).getTitle(), story_1.getTitle());
    }
}
