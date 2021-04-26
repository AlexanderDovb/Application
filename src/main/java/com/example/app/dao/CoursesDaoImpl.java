package com.example.app.dao;

import com.example.app.dao.row_maper.CoursesRowMapper;
import com.example.app.model.Courses;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CoursesDaoImpl implements CoursesDAO{

  private JdbcTemplate jdbcTemplate;

  public CoursesDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<Courses> coursesList(int id){

    String sql = "select " +
            "sc.idcs, " +
            "cs.namecs, " +
            "cs.durationcs, " +
            "cs.freeplacescs " +
            "from " +
            "students st, courses cs, studentscourses sc " +
            "where " +
            "st.idst= ? " +
            "and " +
            "st.idst=sc.idst " +
            "and " +
            "cs.idcs=sc.idcs";
    List<Courses> coursesList = jdbcTemplate.query(sql, new Object[]{id}, (rs,  rowNum) -> {

      Courses courses = new Courses();
      courses.setCourseId(rs.getInt("idcs"));
      courses.setCourseName(rs.getString("namecs"));
      courses.setDuration(rs.getString("durationcs"));
      courses.setFreePlaces(rs.getInt("freeplacescs"));

      return courses;
    });
    return coursesList;
  }

  @Override
  public List<Courses> list(){
    String sql = "SELECT * FROM courses";
    List<Courses> list = jdbcTemplate.query(sql, (rs, rowNum) -> {

      Courses course = new Courses();
      course.setCourseId(rs.getInt("idcs"));
      course.setCourseName(rs.getString("namecs"));
      course.setDuration(rs.getString("durationcs"));
      course.setFreePlaces(rs.getInt("freeplacescs"));

      return course;
    });
    return list;
  }

  @Override
  public void addCoursesToStudent(int studentId, int coursesId){
    String sql = "INSERT INTO studentscourses (idst, idcs) values('?','?')";
    jdbcTemplate.update(sql, studentId, coursesId);
    }

  @Override
  public void removeCoursesFromStudent(int studentId, int courseId){
    String sql = "DELETE FROM studentscourses WHERE idcs=? and idst=?";
    jdbcTemplate.update(sql, courseId, studentId);
  }

  @Override
  public Courses getCourse(int id) {
    String sql = "SELECT * FROM courses WHERE idcs=?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CoursesRowMapper());
  }

}
