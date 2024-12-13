package com.example.SchoolProject.SchoolData.Model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(collection = "Student_Details")
public class StudentModel {
    @Id
    private String id;
    private String studentName;
    private String classTeacherName;
    private String principalName;
    private String Grade;
    private Boolean feeDetails;
}
