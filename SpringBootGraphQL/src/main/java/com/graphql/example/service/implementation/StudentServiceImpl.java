package com.graphql.example.service.implementation;

import com.graphql.example.entities.Student;
import com.graphql.example.persistence.IStudentDAO;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentDAO iStudentDAO;
    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return iStudentDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) iStudentDAO.findAll();
    }

    @Override
    @Transactional
    public void createStudent(Student student) {
        iStudentDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
            iStudentDAO.deleteById(id);
    }
}
