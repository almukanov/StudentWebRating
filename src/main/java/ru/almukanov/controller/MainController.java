package ru.almukanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
     List<Rating> allStudents =  studetnService.findAll();
     model.addAttribute("allStudents", allStudents);
        List<Grade> grades = studetnService.findGrade();
        model.addAttribute("grade",grades);
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

    @GetMapping("get-All-By-Grade/{id}")
    public String getAllByGrade(@PathVariable Long id, Model model){
        List<Rating> students = studetnService.findAllByGrade(id);
        model.addAttribute("students", students);
        List<Grade> grades = studetnService.findGrade();
        model.addAttribute("grade",grades);

        return "getAllByGrade";
    }

    @GetMapping("profile/{id}")
    public String profile(@PathVariable("id") int id, Model model){
        Students students= studetnService.findStudentByID(id);
        model.addAttribute("profileOfStudent", students);
        return "profile";
    }
    @GetMapping("calculate-rating")
    public String calculate(@RequestParam(value= "answerActivity") double answerActivity
            ,@RequestParam(value= "selfActivity") double selfActivity
            ,@RequestParam(value= "questionfActivity") double questionfActivity
            ,@RequestParam(value = "s_id") int s_id){

        double rate = studetnService.calculatingRate(answerActivity, selfActivity, questionfActivity);
        studetnService.saveRating(rate, s_id);
           return "redirect: /";
    }


}
