package com.university.registration.dao;

import com.university.registration.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student validateStudent(String email, String password) {
        try {
            String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), email, password);
        } catch (Exception e) {
            return null;
        }
    }
}
