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

import com.xmu.crms.entity.Class;
import com.xmu.crms.entity.Course;
import com.xmu.crms.entity.Proportions;
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.view.vo.CourseClass;
import com.xmu.crms.view.vo.CourseDetail;
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
    public Object selectCourses() {

        return new Course[]{

                new Course(1, "OOAD", 3, 60, "2017-09-01", "2018-01-01"),

                new Course(2, "J2EE", 1, 60, "2017-09-01", "2018-01-01")

        };

    }
/*
    private String selectCoursesForTeacher() {

        return "";

    }


    private String selectCoursesForStudent() {

        return "";

    }
*/


    @PostMapping

    @ResponseStatus(value = HttpStatus.CREATED)

    public Object createCourse() {

        return new Object() {

            public int id = 5;

        };

    }


    @GetMapping("/{courseId}")
    public Object selectCourse(@PathVariable("courseId") int courseId) {

        return new CourseDetail(courseId, "OOAD", "OOAD 1班 ", "邱明", "342637442@qq.com");

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

                new CourseClass(45, "周一1-2节"),

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

    
    @GetMapping("/{courseId}/seminar/current")
    @ResponseStatus(HttpStatus.OK)
    public Object selectCurrentSeminar(@PathVariable("courseId") int courseId) {
    	
    	Proportions proportions = new Proportions(20, 60, 20, 50, 50);
/*
        List<Class> classes = new ArrayList<>();
		
    	Class one = new Class(201548, "周一三四节",60, "周一1-2节", "海韵教学楼306", 1, "xxxx", proportions);
    			
    	Class two = new Class(3, "周三1-2节", 60, "周三一二节", "海韵201", 1, "tpl/xxx.excel", proportions);
    	
    	classes.add(one);
    	classes.add(two);*/
    	Class[] classes = new Class[]{
    			new Class(201548, "周一三四节",60, "周一1-2节", "海韵教学楼306", 1, "xxxx", proportions),
    			new Class(3, "周三1-2节", 60, "周三一二节", "海韵201", 1, "tpl/xxx.excel", proportions)
    	};
    	
    	return new SeminarClasses(courseId, "周三1-2节", "random", "2017-10-01", "2017-10-31", classes); 
        
    }    
    
    @PostMapping("/{courseId}/seminar")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createSeminarForCourse(@PathVariable("courseId") int courseId) {

        return new Object() {

            public int id = 2;

        };

    }
    
    @GetMapping("/{courseId}/grade")
    @ResponseStatus(HttpStatus.OK)
    public Object getGradeForCourse(@PathVariable("courseId") int courseId) {

        return new SeminarGradeDetail[] {
        	
        	new SeminarGradeDetail("讨论课3", "1-A-2", "洪帅", 5, 4, 4), 
        	
        	new SeminarGradeDetail("讨论课2", "1-A-3", "露露", 5, 3, 4),
        	
        	new SeminarGradeDetail("讨论课4", "1-B-2", "陆磊", 5, 5, 3),
            
        };

    }

}
