package com.example.app.controller;

import com.example.app.dao.CoursesDAO;
import com.example.app.dao.StudentDAO;
import com.example.app.model.Courses;
import com.example.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private StudentDAO studentDAO;
  @Autowired
  private CoursesDAO coursesDAO;

  @GetMapping(value = "/")
  public String studentList(Model model){
    List<Student> studentList = studentDAO.list();
    model.addAttribute("students", studentList);
    return "home";
  }

  @GetMapping(value = "/newStudent")
  public String newStudent(Model model){
    Student student = new Student();
    model.addAttribute("student", student);
    return "newStudent";
  }

  @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
  public ModelAndView addNewStudent(@ModelAttribute Student student) {
    studentDAO.addStudent(student);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
  public ModelAndView editStudent(@PathVariable(name = "id")int id){
    ModelAndView mav = new ModelAndView("editStudent");
    Student student = studentDAO.getStudent(id);
    mav.addObject("student", student);
    return mav;
  }

  @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
  public ModelAndView updateStudent(@ModelAttribute Student student){
    ModelAndView mav = new ModelAndView("updateStudent");
    studentDAO.editStudent(student);
    mav.addObject("student", student);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.GET)
  public String deleteStudent(@PathVariable(name = "id") int id) {
    studentDAO.deleteStudent(id);
    return "redirect:/";
  }

  @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
  public ModelAndView coursesStudent(@PathVariable(name = "id") int id){
    ModelAndView mav = new ModelAndView("courses");
    mav.addObject("studentId", id);
    List<Courses> coursesList = coursesDAO.coursesList(id);
    mav.addObject("coursesList", coursesList);
    return mav;
  }

  @RequestMapping(value = "/courses/{id}/remove-course/{course-id}", method = RequestMethod.GET)
  public ModelAndView deleteCourse(@PathVariable(name = "id") int id, @PathVariable(name = "course-id") int courseId){
    coursesDAO.removeCoursesFromStudent(courseId, id);
    return new ModelAndView("redirect:/courses/{id}");
  }

  @RequestMapping(value = "/add-course/{studentId}/{courseId}", method = RequestMethod.GET)
  public ModelAndView addCourse(@PathVariable(name = "studentId") int studentId, @PathVariable(name = "courseId") int courseId){
    coursesDAO.addCoursesToStudent(studentId, courseId);
    return new ModelAndView("redirect:/courses/{studentId}");
  }

  @GetMapping(value = "/seeCourses/{studentId}")
  public ModelAndView showListOfCourses(Model model, @PathVariable(name = "studentId") int studentId){
    ModelAndView mav = new ModelAndView("coursesList");
    mav.addObject("studentId", studentId);
    mav.addObject("courses", coursesDAO.list());
    return mav;
  }
}
