package com.example.SchoolProject.SchoolData.Controller;

import com.example.SchoolProject.SchoolData.Model.StudentModel;
import com.example.SchoolProject.SchoolData.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/all")
    private List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping("/add")

    public ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel studentModel){
        StudentModel addStudent = studentService.saveStudent(studentModel);
                return ResponseEntity.ok(addStudent);
    }
    @PutMapping("/{id}")

    public  ResponseEntity<StudentModel> updateStudent(@PathVariable String id, @RequestBody StudentModel studentModel)  {
        Optional<StudentModel> existingStudent = studentService.getStudentById(id);
        if(existingStudent.isPresent()){
            studentModel.setId(id);
            StudentModel updateStudent = studentService.saveStudent(studentModel);
            return new ResponseEntity<>(updateStudent,HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentModel> deleteStudent(@PathVariable String id){
        Optional<StudentModel> existingStudent = studentService.getStudentById(id);

        if(existingStudent.isPresent()){
            studentService.deleteStudentById(id);
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}