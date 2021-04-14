package enjie.service.impl;

import enjie.entity.Student;
import enjie.mapper.StudentMapper;
import enjie.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper mapper;
    @Override
    public int add(Student student) {
        return mapper.add(student);
    }
}
