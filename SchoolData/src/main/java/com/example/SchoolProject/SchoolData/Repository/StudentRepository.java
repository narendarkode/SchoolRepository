package com.example.SchoolProject.SchoolData.Repository;

import com.example.SchoolProject.SchoolData.Model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository< StudentModel, String> {

}
