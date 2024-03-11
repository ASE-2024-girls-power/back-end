package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.entity.Reader;
import project.rest.dto.ReaderLoginDTO;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerReader(@RequestBody Reader reader){
        // Handle registration logic, return appropriate response
        Reader savedReader = readerService.createReader(reader);
        return ResponseEntity.ok(savedReader); // Simplified, consider security implications
    }

    // Add a login endpoint if you're not using Spring Security's built-in mechanisms
    @PostMapping("/login")
    public String login(@RequestBody ReaderLoginDTO loginDTO){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getReaderName(), loginDTO.getPassword());


       Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Login successful";
    }

}