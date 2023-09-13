package com.example.demo.controllers;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.responses.ResponseHandler;
import com.example.demo.services.ServiceAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class ControllerAuthor {
    @Autowired
    private ServiceAuthor serviceAuthor;

    @GetMapping
    public ResponseEntity<Object> findAll() {

        try {
            List<Author> result = serviceAuthor.findAll();

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Author author){
        try{
            Author author1 = serviceAuthor.save( author );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, author1);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            Author author = serviceAuthor.findById( id );

            return new ResponseHandler().generateResponse("Success", HttpStatus.OK, author);
        }catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
