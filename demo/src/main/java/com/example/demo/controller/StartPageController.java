package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.EngVideo;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class StartPageController {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    VideoRepo videoRepo;

    @GetMapping("/start_page")
    public String start_page(Model model){
        List<Book> books = bookRepo.findAll();
        model.addAttribute("books",books);
        return "start_page2";
    }

    @GetMapping("/starter")
    public String starter(Model model){
        List<Book> bookss = bookRepo.findAll();
        List<Book> books = new ArrayList<>();
        for (int i=0;i<bookss.size();i++){
            if(Objects.equals(bookss.get(i).getTest_role(), "Starter")){
                books.add(bookss.get(i));
            }
        }
        model.addAttribute("books",books);
        return "start_page2";
    }
    @GetMapping("/Elementary")
    public String elementary(Model model){
        List<Book> bookss = bookRepo.findAll();
        List<Book> books = new ArrayList<>();
        for (int i=0;i<bookss.size();i++){
            if(Objects.equals(bookss.get(i).getTest_role(), "Elementary")){
                books.add(bookss.get(i));
            }
        }
        model.addAttribute("books",books);
        return "start_page2";
    }

    @GetMapping("/Intermediate")
    public String intermediate(Model model){
        List<Book> bookss = bookRepo.findAll();
        List<Book> books = new ArrayList<>();
        for (int i=0;i<bookss.size();i++){
            if(Objects.equals(bookss.get(i).getTest_role(), "Intermediate")){
                books.add(bookss.get(i));
            }
        }
        model.addAttribute("books",books);
        return "start_page2";
    }

    @GetMapping("/Advanced")
    public String advanced(Model model){
        List<Book> bookss = bookRepo.findAll();
        List<Book> books = new ArrayList<>();
        for (int i=0;i<bookss.size();i++){
            if(Objects.equals(bookss.get(i).getTest_role(), "Advanced")){
                books.add(bookss.get(i));
            }
        }
        model.addAttribute("books",books);
        return "start_page2";
    }


    @GetMapping("/")
    public String index(){
        return "redirect:/start_page";
    }

    @GetMapping("/start_page_video")
    public String video_page(Model model){
        List<EngVideo> videos =  videoRepo.findAll();
        model.addAttribute("videos",videos);
        return "start_page_video";
    }
}
