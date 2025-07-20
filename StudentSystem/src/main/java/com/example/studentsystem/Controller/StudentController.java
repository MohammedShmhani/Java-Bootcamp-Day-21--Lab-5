package com.example.studentsystem.Controller;

import com.example.studentsystem.Api.ApiResponse;
import com.example.studentsystem.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();


    @GetMapping("/get/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PutMapping("/update/student/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Update applied", "200");
    }

    @PostMapping("/add/student")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Added applied", "200");
    }

    @DeleteMapping("/delete/student/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Deleted applied", "200");
    }

    @GetMapping("/get/honor/student/{index}")
    public ApiResponse studentHonorsCatigorieze(@PathVariable int index) {
        double gpa = students.get(index).getGpa();
        if (gpa >= 4.75 && gpa <= 5)
            return new ApiResponse("First class honor", "200");
        else if (gpa >= 4.5 && gpa < 4.75)
            return new ApiResponse("Second class honor", "200");
        else
            return new ApiResponse("No honor", "200");


    }

    //The method return a group of students whose GPA is greater than the average

    @GetMapping("/get/students/gpa/avg")
    public ArrayList<Student> getStudent() {
        ArrayList<Student> studentsHonors = new ArrayList<>();
        double avgGpa = 0;
        for (Student s : students)
            avgGpa += s.getGpa();
        avgGpa = avgGpa / students.size();
        for (Student s : students) {
            if (s.getGpa() >= avgGpa)
                studentsHonors.add(s);
        }
        return studentsHonors;

    }


}
