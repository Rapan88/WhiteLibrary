package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public void saveBook(Book book){
        bookRepo.save(book);
    }

    public List<Book> getAllActiveBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return  bookRepo.findById(id);
    }



}
