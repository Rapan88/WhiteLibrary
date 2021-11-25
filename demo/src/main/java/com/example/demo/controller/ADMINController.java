package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.models.EngVideo;
import com.example.demo.models.User;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

@Controller
public class ADMINController {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    VideoRepo videoRepo;

    @Lob
    String string;

    @GetMapping("/admin")
    public String admin(Model model,User user) {
        return "admin";
    }
    @PostMapping("/loadbook")
    public String addBook(Model model,
                          @RequestParam String name,
                          @RequestParam String text,
                          @RequestParam String test_role,
                          @RequestParam MultipartFile engText,
                          @RequestParam MultipartFile ukrText,
                          @RequestParam MultipartFile image) throws IOException {
        Book book= new Book(name,text);
        book.setTest_role(test_role);
        book.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        string = Base64.getEncoder().encodeToString(engText.getBytes());
        byte[] bytes = Base64.getDecoder().decode(string);
        String strr = new String(bytes,Charset.defaultCharset());
        String[] arrStr = strr.split("\\.");
        book.setEngText(arrStr);


        string = Base64.getEncoder().encodeToString(ukrText.getBytes());
        bytes = Base64.getDecoder().decode(string);
        strr = new String(bytes,Charset.defaultCharset());
        arrStr = strr.split("\\.");
        book.setUkrText(arrStr);


        bookRepo.save(book);

        return "redirect:/start_page";
    }

    @PostMapping("/loadVideo")
    public String addVideo(Model model,
                           @RequestParam String videoName,
                           @RequestParam MultipartFile engVideo,
                           @RequestParam MultipartFile videoImg) throws IOException{
        EngVideo video = new EngVideo();
        video.setVideoName(videoName);
        video.setVideoContent(Base64.getEncoder().encodeToString(engVideo.getBytes()));
        video.setVideoImg(Base64.getEncoder().encodeToString(videoImg.getBytes()));
        videoRepo.save(video);
        return "redirect:/start_page";
    }


}






