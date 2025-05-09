package com.university.registration.controller;

import com.university.registration.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String listCourses(Model model) {
        List<Course> courses = fetchCoursesFromDB();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, HttpSession session) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student != null) {
            registerStudentForCourse(student.getStudentId(), courseId);
            return "redirect:/success";
        }
        return "redirect:/login";
    }

    private List<Course> fetchCoursesFromDB() {
        // Fetch courses logic
        return List.of(new Course(1, "Software Engineering", "Dr. Smith", 3),
                new Course(2, "Database Management", "Prof. Johnson", 4));
    }

    private void registerStudentForCourse(int studentId, int courseId) {
        // Registration logic
    }
}
