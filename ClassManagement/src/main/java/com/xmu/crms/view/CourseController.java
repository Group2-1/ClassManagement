package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Class;
import com.xmu.crms.entity.Course;
import com.xmu.crms.entity.Proportions;
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.view.vo.CourseDetailVO;
import com.xmu.crms.view.vo.Response;
import com.xmu.crms.view.vo.SeminarClasses;
import com.xmu.crms.view.vo.SeminarGradeDetail;

/**
 * 
 * @author lingyun
 *
 */

@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping
    public List<Course> getCourses(HttpServletResponse response) {
        
    	List<Course> courses = new ArrayList<Course>();
        Course course1 = new Course();
        course1.setId(11);
        course1.setName("面向对象分析与设计");
        course1.setNumClass(3);
        course1.setNumStudent(60);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,8,1);
        course1.setStartTime(calendar.getTime());
        calendar.set(2018,0,1);
        course1.setEndTime(calendar.getTime());
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(12);
        course2.setName("J2EE技术");
        course2.setNumClass(1);
        course2.setNumStudent(60);
        calendar.set(2017,8,1);
        course2.setStartTime(calendar.getTime());
        calendar.set(2018,0,1);
        course2.setEndTime(calendar.getTime());
        courses.add(course2);
        response.setStatus(200);
        return courses;
    }


    @PostMapping
    public Course createCourse(@RequestBody Course course, HttpServletResponse response) {
        
    	Course  course1 = new Course();
        course1.setId(12);
        response.setStatus(201);
        return course1;
    }


    @GetMapping("/{courseId}")
    public CourseDetailVO selectCourse(@PathVariable("courseId") int courseId, @RequestBody Course course, HttpServletResponse response) {
        
    	CourseDetailVO courseDetail = new CourseDetailVO();
        courseDetail.setId(11);
        courseDetail.setName("OOAD");
        courseDetail.setDescription("面向对象分析与设计");
        courseDetail.setTeacherName("邱明");
        courseDetail.setTeacherEmail("mingqiu@xmu.edu.cn");
        response.setStatus(200);
        return courseDetail;
        
    }

    @PutMapping("/{courseId}")
    public Response updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course course, HttpServletResponse response) {

        response.setStatus(204);
        return null;
    }

    @DeleteMapping("/{courseId}")
    public Response deleteCourse(@PathVariable("courseId") int courseId, HttpServletResponse response) {
        
    	response.setStatus(204);
        return null;
    }

    @GetMapping("/{courseId}/class")
    public List<Class> selectClassesByCourse(@PathVariable("courseId") int courseId, HttpServletResponse response) {
    	
        List<Class> classes = new ArrayList<>();
        Class class1 = new Class();
        class1.setId(11);
        class1.setName("周三1-2节");
        classes.add(class1);
        Class class2 = new Class();
        class2.setId(12);
        class2.setName("周三3-4节");
        classes.add(class2);
        return classes;

    }

    @PostMapping("/{courseId}/class")
    public Class createClassForCourse(@RequestBody Class newClass, @PathVariable("courseId") int courseId, HttpServletResponse response) {
        
    	Class class1 = new Class();
        class1.setId(11);
        response.setStatus(201);
        return class1;
    }

    @GetMapping("/{courseId}/seminar")
    public List<Seminar> selectSeminarsByCourse(@PathVariable("courseId") int courseId, @PathVariable(value = "embedGrade", required = false) Boolean embedGrade) {

       List<Seminar> seminars = new ArrayList<>();
       Seminar seminar1 = new Seminar(29, "需求分析", "系统需求说明", "fixed", "2017-09-25", "2017-10-09");
       Seminar seminar2 = new Seminar(32, "界面原型设计", "界面原型", "random", "2017-11-10", "2017-11-24");       

       /*if(null != embedGrade && embedGrade == Boolean.TRUE) { //???????embedGrade怎么用????????????s
    	   SeminarWithGrade seminarWithGrade1 = new SeminarWithGrade(seminar1, 4);
    	   SeminarWithGrade seminarWithGrade2 = new SeminarWithGrade(seminar2, 5);
    	   seminars.add(seminarWithGrade1);
           seminars.add(seminarWithGrade2);
       } else {
           seminars.add(seminar1);
           seminars.add(seminar2);
       }*/
       seminars.add(seminar1);
       seminars.add(seminar2);
       return seminars;
    }
    
    @PostMapping("/{courseId}/seminar")
    public Seminar createSeminarForCourse(@PathVariable("courseId") int courseId, @RequestBody Seminar seminar, HttpServletResponse response) {

        Seminar seminar1 = new Seminar();
        seminar1.setId(32);
        response.setStatus(201);
        return seminar1;
    	/*return new Seminar(29, "需求分析", "系统需求说明", "fixed", "2017-09-25", "2017-10-09");*/

    }
    
    @GetMapping("/{courseId}/seminar/current")
    public SeminarClasses selectCurrentSeminar(@PathVariable("courseId") int courseId,  HttpServletResponse response) {
    	
    	Proportions proportions = new Proportions(20, 60, 20, 50, 50);
    	
		List<Class> classes = new ArrayList<>();		
    	Class class1 = new Class(201548, "周一三四节",60, "周一1-2节", "海韵教学楼306", 1, "xxxx", proportions);    			
    	Class class2 = new Class(3, "周三1-2节", 60, "周三一二节", "海韵201", 1, "tpl/xxx.excel", proportions);    	
    	classes.add(class1);
    	classes.add(class2);
    	response.setStatus(200);
    	return new SeminarClasses(courseId, "周三1-2节", "random", "2017-10-01", "2017-10-31", classes); 
    	
    }    
        
    @GetMapping("/{courseId}/grade")
    public List<SeminarGradeDetail> getGradeForCourse(@PathVariable("courseId") int courseId, HttpServletResponse response) {

    	List<SeminarGradeDetail> seminarGradeDetails = new ArrayList<>();
    	SeminarGradeDetail seminarGradeDetail1 = new SeminarGradeDetail("讨论课3", "1-A-2", "洪帅", 5, 4, 4);       	
    	SeminarGradeDetail seminarGradeDetail2 = new SeminarGradeDetail("讨论课2", "1-A-3", "露露", 5, 3, 4);        	
    	SeminarGradeDetail seminarGradeDetail3 = new SeminarGradeDetail("讨论课4", "1-B-2", "陆磊", 5, 5, 3);
    	seminarGradeDetails.add(seminarGradeDetail1);
    	seminarGradeDetails.add(seminarGradeDetail2);
    	seminarGradeDetails.add(seminarGradeDetail3);
    	response.setStatus(200);
    	return seminarGradeDetails;

    }

}
