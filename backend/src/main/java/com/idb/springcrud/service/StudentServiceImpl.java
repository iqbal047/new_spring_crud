package com.idb.springcrud.service;

import com.idb.springcrud.dao.StudentRepository;
import lombok.RequiredArgsConstructor;
import model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;



    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }
}
