package com.example.demo.springboot.controller;

import com.example.demo.springboot.model.LapTop;
import com.example.demo.springboot.service.laptop.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LapTopController {
    @Autowired
    private IService service;

//    @GetMapping()
//    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView("listlaptop");
//        modelAndView.addObject("laptops", service.findAll());
//        return modelAndView;
//    }

    //    @GetMapping("/findAll")
//    public ResponseEntity<Iterable<LapTop>> findAll(){
//        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<LapTop> editStudent(@PathVariable Long id, @RequestBody LapTop lapTop){
//        Optional<LapTop> optionalStudent = service.findById(id);
//        lapTop.setId(id);
//        if (optionalStudent.isPresent()) return new ResponseEntity<>(service.save(lapTop), HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
    @GetMapping("/laptops")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("listlaptop");
        modelAndView.addObject("laptops", service.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createShow() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("laptop", new LapTop());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("laptop") LapTop lapTop) {
        service.save(lapTop);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("laptop", new LapTop());
        modelAndView.addObject("message", "Tao moi thanh cong");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editShow(@PathVariable Long id) {
        Object lapTop = service.findById(id);
        if (lapTop != null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("laptop" , lapTop);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("loi");
        return modelAndView;

    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("laptop") LapTop lapTop) {
        service.save(lapTop);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("laptops", lapTop);
        modelAndView.addObject("message","sua doi thanh cong");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteShow(@PathVariable Long id){
       Optional<LapTop> lapTop = service.findById(id);
           ModelAndView modelAndView = new ModelAndView("delete");
           modelAndView.addObject("laptop" , lapTop);
           return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("laptop") LapTop lapTop) {
        service.remove(lapTop.getId());
        ModelAndView modelAndView =  new ModelAndView("delete");
        modelAndView.addObject("laptop",lapTop);
        return modelAndView;
    }



}
