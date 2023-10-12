package com.idb.springcrud.controller;

import com.idb.springcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Student student){

        Student result = studentService.save(student);
        if(result.getId() != null && result.getId() > 0){
            return "Successfully stored data";
        }else{
            return "Failed to stored data";
        }
    }

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id){
         studentService.deleteById(id);
         return "Deleted successfully";

    }

}
