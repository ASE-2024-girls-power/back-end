package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Writer;

import java.util.Optional;
@Repository("writerRepository")
public interface WriterRepository extends JpaRepository<Writer, Integer> {
    Optional<Writer> findById(int id);
    Optional<Writer> findByPenName(String penName);
}
