package ru.almukanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.almukanov.entity.Rating;
import ru.almukanov.entity.Students;
import ru.almukanov.service.CalculateRate;
import ru.almukanov.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private StudentService studetnService;

    @GetMapping("/student")
public List<Rating> showAllStudentRate(){
        List<Rating> ratings = studetnService.findAll();
        return ratings;
    }
    @GetMapping("/student/{id}")
    public List<Rating> showAllStudentRate(@PathVariable("id") Long id){
        List<Rating> ratings = studetnService.findAllByGrade(id);
        return ratings;
    }
    @PostMapping("/student")
    public Students addStudent(@RequestBody Students students){
        studetnService.saveStudent(students);
        return students;
    }
    @PostMapping("/rating/{id}")
    public void calculate(@PathVariable("id") int id, @RequestBody CalculateRate calculateRate){


     double rating =   studetnService.calculatingRate(calculateRate.getAnswerActivity(),calculateRate.getSelfActivity(),calculateRate.getQuestionActivity());
    studetnService.saveRating(rating, id);

    }

}
