package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StartPageController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping("/start_page")
    public String start_page(Model model){
        List<Book> books = bookRepo.findAll();
        model.addAttribute("books",books);
        return "start_page2";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/start_page";
    }
}
