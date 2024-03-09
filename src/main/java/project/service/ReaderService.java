package project.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import project.entity.Reader;
import project.repository.ReaderRepository;

/**
 * Reader Service
 * This class is the "worker" and responsible for all functionality related to
 * the Reader
 * (e.g., it creates, modifies, deletes, finds). The result will be passed back
 * to the caller.
 */




import java.util.Optional;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public Reader createReader(Reader reader){
        // Add logic to hash password and any other setup before saving
        return readerRepository.save(reader);
    }

    public Optional<Reader> findByReaderName(String readerName){
        return readerRepository.findByReaderName(readerName);
    }
}
