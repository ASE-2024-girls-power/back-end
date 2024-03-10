package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Story;

import java.util.List;
import java.util.Optional;

@Repository("storyRepository")
public interface StoryRepository extends JpaRepository<Story, Integer> {
    Optional<Story> findById(int id);
    List<Story> findByWriterIdOrderByIdDesc(int writerId);
}
