package com.example.app.dao.row_maper;

import com.example.app.model.Courses;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesRowMapper implements RowMapper<Courses> {

  @Override
  public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {

      Courses course = new Courses();
      course.setCourseId(rs.getInt("idcs"));
      course.setCourseName(rs.getString("namecs"));
      course.setDuration(rs.getString("durationcs"));
      course.setFreePlaces(rs.getInt("freeplacescs"));

      return course;
    }

}
