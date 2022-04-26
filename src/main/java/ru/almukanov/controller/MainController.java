package ru.almukanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.almukanov.entity.Grade;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;
import ru.almukanov.service.StudetnService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private StudetnService studetnService;


    @GetMapping("/")
    public String allStudents(Model model){
     List<Students> allStudents =  studetnService.findAll();
     model.addAttribute("allStudents", allStudents);
        return "index";
    }
    @GetMapping("/add-new-student")
    public String addNewStudent(Model model){
        Students student = new Students();
        model.addAttribute("student", student);
        List<Grade> grades = studetnService.findGrade();
        model.addAttribute("grade",grades);
        return "StudentInfo";
    }


    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Students student){
        studetnService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/get-all-ratings")
    public String getAllRatings(Model model){
        List<Rating> ratings = studetnService.findRating();
        model.addAttribute("ratings", ratings);
        return "GetAllRatings";
    }
}
