package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.ChapterID;
import project.entity.Paragraph;

import java.util.List;

@Repository("paragraphRepository")
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
    List<Paragraph> findByChapterIdOrderByIdAsc(ChapterID chapterId);
}
