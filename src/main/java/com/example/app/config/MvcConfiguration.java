package com.example.app.config;

import com.example.app.dao.CoursesDAO;
import com.example.app.dao.CoursesDaoImpl;
import com.example.app.dao.StudentDAO;
import com.example.app.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.app")
@EnableWebMvc
public class MvcConfiguration {


  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
    dataSource.setUsername("postgres");
    dataSource.setPassword("root");

    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(){
    return new JdbcTemplate(getDataSource());
  }

  @Bean
  public StudentDAO getStudentDAO() {
    return new StudentDaoImpl(getDataSource());
  }

  @Bean
  public CoursesDAO getCoursesDAO() {
    return new CoursesDaoImpl(getDataSource());
  }
}
