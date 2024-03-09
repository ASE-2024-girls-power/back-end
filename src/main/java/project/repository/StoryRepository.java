package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Story;

@Repository("storyRepository")
public interface StoryRepository extends JpaRepository<Story, Long> {
}
