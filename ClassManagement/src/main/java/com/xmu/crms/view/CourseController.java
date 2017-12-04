package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Course;
import com.xmu.crms.service.CourseService;

/**
 * Course Controller
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	@Qualifier("CourseService")
	private CourseService courseService;
	
	/*search ？teacher= && course= */
	@GetMapping
	public List<Course> index(@RequestParam("teacher") String teacherName, @RequestParam("course") Integer courseId, Model model) {
		return new ArrayList<Course>();
	}
	
	

}
