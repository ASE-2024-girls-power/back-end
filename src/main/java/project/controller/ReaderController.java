package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.entity.Reader;
import project.service.ReaderService;


/**
 * Reader Controller
 * This class is responsible for handling all REST request that are related to
 * the reader.
 * The controller will receive the request and delegate the execution to the
 * ReaderService and finally return the result.
 */

@RestController
@RequestMapping("/api/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerReader(@RequestBody Reader reader){
        // Handle registration logic, return appropriate response
        Reader savedReader = readerService.createReader(reader);
        return ResponseEntity.ok(savedReader); // Simplified, consider security implications
    }



    // Add a login endpoint if you're not using Spring Security's built-in mechanisms
}
