package com.example.trackersystem.Controller;

import com.example.trackersystem.Api.ApiResponse;
import com.example.trackersystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {


    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get/projects")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/post/project")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Added project successfully", "200");
    }

    @DeleteMapping("/delete/project/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Deleted project successfully", "200");
    }

    @PutMapping("/update/project/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("Updated project successfully", "200");
    }

    @PutMapping("/change/status/project-by/{index}/{status}")
    public ApiResponse updateStatus(@PathVariable int index, @PathVariable String status) {
        if (status.equalsIgnoreCase("Not done")) {
            projects.get(index).setStatus(status);
            return new ApiResponse("Updated project status successfully", "200");
        }

        return new ApiResponse("Project already done", "200");
    }


    @GetMapping("/get/project-by/{title}")
    public Project getProject(@PathVariable String title) {
        for (Project project : projects)
            if (project.getTitle().equals(title))
                return project;
        return null;
    }

    @GetMapping("/get/projects-by/{companyName}")
    public ArrayList<Project> getProjectsByCompanyName(@PathVariable String companyName) {
        ArrayList<Project> projects1 = new ArrayList<>();
        for (Project project : projects)
            if (project.getCompanyName().equals(companyName))
                projects1.add(project);

        return projects1;
    }


}
