package com.example.Thymeleaf.controller;

import com.example.Thymeleaf.entity.User;
import com.example.Thymeleaf.repository.ThymeleafRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {
    private final ThymeleafRepo thymeleafRepo;

    public WelcomeController(ThymeleafRepo thymeleafRepo) {
        this.thymeleafRepo = thymeleafRepo;
    }

    @RequestMapping("/")
    public String hi(@RequestParam(value = "name", defaultValue = "John") String name,
                                   @RequestParam(value = "lastName" , defaultValue = "Doe") String lastName, Model model ) {
        model.addAttribute("name",name);
        model.addAttribute("lastName",lastName);
        return "Name";
    }
    //@ModelAttribute
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("list",thymeleafRepo.findAll());
        return "Hi";
    }

    @GetMapping("/name/{name}")
    public @ResponseBody User getByName(@PathVariable String name){
        return thymeleafRepo.findByName(name);
    }

}
