package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Chapter;
import project.entity.ChapterID;

import java.util.List;
import java.util.Optional;

@Repository("chapterRepository")
public interface ChapterRepository extends JpaRepository<Chapter, ChapterID> {
    Optional<Chapter> findById(ChapterID id);
    List<Chapter> findById_StoryId(int storyId);
}