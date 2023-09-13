package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class ControllerBook {
    @Autowired
    private ServiceBook serviceBook;

    @GetMapping
    public List<Book> getBooks(){
        return serviceBook.getBooks();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id){

        return serviceBook.findById(id);
    }

    @PostMapping("/{id}")
    public Book save(@RequestBody Book book,@PathVariable Long id){
        if( serviceBook.findById( book.getId()) == null ){
            return serviceBook.save(book,id);
        }

        return null;
    }
}
