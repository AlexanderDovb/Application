package com.example.app.dao;

import com.example.app.dao.row_maper.StudentRowMapper;
import com.example.app.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentDaoImpl implements StudentDAO{

  private JdbcTemplate jdbcTemplate;

  public StudentDaoImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<Student> list() {
    String sql = "SELECT * FROM students";
    List<Student> studentList = jdbcTemplate.query(sql, (rs, rowNum) -> {

      Student student = new Student();
      student.setId(rs.getInt("idst"));
      student.setName(rs.getString("namest"));
      student.setSurname(rs.getString("surnamest"));
      student.setAge(rs.getInt("agest"));

      return student;
    });
    return studentList;
  }

  @Override
  public void addStudent(Student student) {
    String sql = "INSERT INTO students(idst, namest, surnamest, agest) VALUES (?,?,?,?)";
    jdbcTemplate.update(sql, student.getId(), student.getName(),
            student.getSurname(), student.getAge());
  }

  @Override
  public void deleteStudent(int id) {
    String sql = "DELETE FROM students WHERE idst=?";
    jdbcTemplate.update(sql, id);
  }

  @Override
  public void editStudent(Student student) {
    String sql = "UPDATE students SET namest=?, surnamest=?, agest=?" +
            "WHERE idst=?";
    jdbcTemplate.update(sql, student.getName(),
            student.getSurname(), student.getAge(), student.getId());
  }


  public Student getStudent(int id) {
    String sql = "SELECT * FROM students WHERE idst=?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
  }

}
