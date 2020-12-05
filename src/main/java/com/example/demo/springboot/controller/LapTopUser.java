package com.example.demo.springboot.controller;

import com.example.demo.springboot.service.laptop.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class LapTopUser {
    @Autowired
    private IService service;
    @GetMapping("")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("listlaptopuser");
        modelAndView.addObject("laptops", service.findAll());
        return modelAndView;
    }

}
