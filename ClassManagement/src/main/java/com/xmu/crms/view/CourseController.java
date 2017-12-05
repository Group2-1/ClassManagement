package com.xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Course;
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.view.vo.CourseClass;
/**
 * 
 * @author lingyun
 *
 */

@RestController

@RequestMapping("/course")

public class CourseController {



    @GetMapping

    public Object selectCourses() {

        return new Course[]{

                new Course(1, "OOAD", 3, 60, "2017-09-01", "2018-01-01"),

                new Course(2, "J2EE", 1, 60, "2017-09-01", "2018-01-01")

        };

    }



    private String selectCoursesForTeacher() {



        return "";

    }



    private String selectCoursesForStudent() {


        return "";

    }



    @PostMapping

    @ResponseStatus(value = HttpStatus.CREATED)

    public Object createCourse() {

        return new Object() {

            public int id = 5;

        };

    }



    @GetMapping("/{courseId}")

    public Object selectCourse(@PathVariable("courseId") int courseId) {

        return new Course(courseId, "OOAD", 3, 60, "2017-09-01", "2018-01-01");

    }



    @PutMapping("/{courseId}")

    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public void updateCourse(@PathVariable("courseId") int courseId) {

        return;

    }



    @DeleteMapping("/{courseId}")

    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    public String deleteCourse(@PathVariable("courseId") int courseId) {

        return null;

    }



    @GetMapping("/{courseId}/class")

    public Object selectClassesByCourse(@PathVariable("courseId") int courseId) {
    	
        return new CourseClass[]{

                new CourseClass(45, "周三1-2节"),

                new CourseClass(48, "周三3-4节")

        };

    }

    @PostMapping("/{courseId}/class")

    @ResponseStatus(HttpStatus.CREATED)

    public Object createClassForCourse(@PathVariable("courseId") int courseId) {

        return new Object() {

            public int id = 5;

        };

    }



    @GetMapping("/{courseId}/seminar")

    @ResponseStatus(HttpStatus.OK)

    public Object selectSeminarsByCourse(@PathVariable("courseId") int courseId) {

        return new Seminar[]{

                new Seminar(29, "需求分析", "系统需求说明", "fixed", "2017-09-25", "2017-10-09"),

                new Seminar(32, "界面原型设计", "界面原型", "random", "2017-10-10", "2017-10-24"),

        };

    }



    @PostMapping("/{courseId}/seminar")

    @ResponseStatus(HttpStatus.CREATED)

    public Object createSeminarForCourse(@PathVariable("courseId") int courseId) {

        return new Object() {

            public int id = 2;

        };

    }

}
