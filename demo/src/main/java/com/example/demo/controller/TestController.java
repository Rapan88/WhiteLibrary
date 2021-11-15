package com.example.demo.controller;

import com.example.demo.models.Test_role;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    private int count = 1;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/test")
    public String testAnswer(Model model){
        return "test";
    }
    @PostMapping("/test_answer")
    public String testStart(@RequestParam String answer1,
                            @RequestParam String answer2,
                            @RequestParam String answer3,
            @RequestParam String answer4,
            @RequestParam String answer5,
            @RequestParam String answer6,
            @RequestParam String answer7,
            @RequestParam String answer8,
            @RequestParam String answer9,
            @RequestParam String answer10,
            @RequestParam String answer11,
            @RequestParam String answer12,
            @RequestParam String answer13,
            @RequestParam String answer14,
            @RequestParam String answer15,
            @RequestParam String answer16,
            @RequestParam String answer17,
            @RequestParam String answer18,
            @RequestParam String answer19,@AuthenticationPrincipal User user){

        if(answer1.equals("bad"))
            count++;

        if(answer2.equals("cold"))
            count++;

        if(answer3.equals("small"))
            count++;

        if(answer4.equals("open"))
            count++;

        if(answer5.equals("happy"))
            count++;

        if(answer6.equals("eyes"))
            count++;

        if(answer7.equals("legs"))
            count++;

        if(answer8.equals("orange"))
            count++;

        if(answer9.equals("milk")){
            count++;
        }
        if(answer10.equals("vegetables")){
            count++;
        }
        if(answer11.equals("aunt")){
            count++;
        }
        if(answer12.equals("nephew")){
            count++;
        }
        if(answer13.equals("boring")){
            count++;
        }
        if(answer14.equals("wrong")){
            count++;
        }
        if(answer15.equals("umbrella")){
            count++;
        }
        if(answer16.equals("washed")){
            count++;
        }
        if(answer17.equals("wrote")){
            count++;
        }
        if(answer18.equals("cook")){
            count++;
        }
        if(answer19.equals("well")){
            count++;
        }
        user.setTest_role(null);
        if(count<5){
            user.setTest_role(Test_role.Starter.name());
            userRepo.save(user);
        }
        if(count>5&&count<10){
            user.setTest_role(Test_role.Elementary.name());
            userRepo.save(user);
        }
        if(count>10&&count<15){
            user.setTest_role(Test_role.Intermediate.name());
            userRepo.save(user);
        }
        if(count>15){
            user.setTest_role(Test_role.Advanced.name());
            userRepo.save(user);
        }



        return "redirect:/end_test";
    }
    @GetMapping("/end_test")
    public String end_test( Model model,@AuthenticationPrincipal User user){

        model.addAttribute("user",user);
        return "end_test";
    }

}
