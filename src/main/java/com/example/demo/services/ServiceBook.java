package com.example.demo.services;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repositories.RepositoryAuthor;
import com.example.demo.repositories.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceBook {

    @Autowired
    private RepositoryBook repositoryBook;

    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public List<Book> getBooks(){

        return repositoryBook.findAll();
    }

    public Book findById(String id) {

        Optional<Book> optionalBook = repositoryBook.findById( id );

        return optionalBook.isPresent() ? optionalBook.get() : null;
    }

    public Book save(Book book,Long id) {

        Optional<Author> opt = repositoryAuthor.findById(id);

        Author author = opt.isPresent() ? opt.get() : null;
        if( author != null){
            book.setAuthor( author );
            author.addBook( book );

            return repositoryBook.save( book );
        }

        return null;
    }

    public Book delete( String id ){

        Book book = findById( id );

        if( book != null ){
            repositoryBook.delete( book );

            return book;
        }

        return null;
    }
}
