package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.repo.VideoRepo;
import com.example.demo.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    WordRepo wordRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    VideoRepo videoRepo;

    @PostMapping("/book/{id}")
    public String bookId(Model model,
                         @AuthenticationPrincipal User user,
                         @PathVariable String id){
    long bookId;
    try {
        bookId = Long.parseLong(id);
    }
    catch (NumberFormatException e){
        return "exceptionBook";
    }

    Book book = bookRepo.getById(bookId);

    String[] arrEng = book.getEngText();
    String[] arrUkr = book.getUkrText();
    model.addAttribute("arrEng",arrEng);
    model.addAttribute("arrUkr",arrUkr);
    model.addAttribute("count",new Count());

    return "book_read";
}

    @PostMapping("/video/{id}")
    public String videoId(Model model,@PathVariable String id){
        long videoId;
        try {
            videoId = Long.parseLong(id);
        }
        catch (NumberFormatException e){
            return "exceptionVideo";
        }
        EngVideo video = videoRepo.getById(videoId);
        model.addAttribute("video",video);
        return "video_watch";
    }

    @PostMapping("/deleteWord/{id}")
    public String deleteWord(Model model,
                             @PathVariable String id,@AuthenticationPrincipal User user){
        if(user!=null){
            user = userRepo.getById(user.getId());
        }
        long wordId;

        try{
            wordId = Long.parseLong(id);
        }
        catch (NumberFormatException e){
            return "exceptionWord";
        }

        Set<Word> words = user.getWords();
        Word word = wordRepo.getById(wordId);
        words.remove(word);
        user.setWords(words);
        userRepo.save(user);
        return "redirect:/dictionary";
    }


    @PostMapping("/addWord")
    public String addWord(Model model,
                          @RequestParam String engWord,
                          @RequestParam String ukrWord,
                          @RequestParam MultipartFile image,
                          @AuthenticationPrincipal User user) throws IOException {
        if(user!=null){
            user = userRepo.getById(user.getId());
        }
    Word word = new Word(engWord,ukrWord);
    word.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        user.getWords().add(word);
    userRepo.save(user);
    return "redirect:/dictionary";
    }

    @GetMapping("/dictionary")
    public String dictionary(Model model,@AuthenticationPrincipal User user){
        if(user!=null){
            user = userRepo.getById(user.getId());
        }
        Set<Word> words = user.getWords();
        model.addAttribute("words",words);
        return "dictionary";
    }




}
