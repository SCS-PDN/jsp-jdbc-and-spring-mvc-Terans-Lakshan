package com.university.registration.controller;

import com.university.registration.dao.StudentDAO;
import com.university.registration.model.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns login.jsp
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Student student = studentDAO.validateStudent(email, password);
        if (student != null) {
            session.setAttribute("loggedInStudent", student);
            return "redirect:/courses";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
