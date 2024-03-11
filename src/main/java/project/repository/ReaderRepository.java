package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.Reader;

import java.util.Optional;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Optional<Reader> findByReaderName(String readerName);

}