package com.example.demo.services;

import com.example.demo.entities.Author;
import com.example.demo.repositories.RepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAuthor {
    @Autowired
    private RepositoryAuthor repositoryAuthor;

    public List<Author> findAll(){

        return repositoryAuthor.findAll();
    }

    public Author findById( Long id ){

        Optional<Author> opt = repositoryAuthor.findById(id);

        return opt.isPresent() ? opt.get() : null;
    }

    public Author save( Author author){

        return repositoryAuthor.save( author );
    }
}
