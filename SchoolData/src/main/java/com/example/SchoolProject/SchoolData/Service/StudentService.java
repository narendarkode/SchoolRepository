package com.example.SchoolProject.SchoolData.Service;


import com.example.SchoolProject.SchoolData.Model.StudentModel;
import com.example.SchoolProject.SchoolData.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }
    public StudentModel saveStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }

    //Delete Student by Id
    public void deleteStudentById(String id){
        studentRepository.deleteById(id);
    }
  //Find Student By Id
    public Optional<StudentModel> getStudentById(String id) {
        return studentRepository.findById(id);
    }
}
