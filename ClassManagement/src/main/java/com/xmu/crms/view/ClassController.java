package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

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
import com.xmu.crms.entity.Group;
import com.xmu.crms.entity.Proportions;
import com.xmu.crms.entity.School;
import com.xmu.crms.entity.Student;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.CourseClass;
/**
 * class controller
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @GetMapping
    public Object selectClasses() {
    	
    	/*School school = new School(50789, "北京大学", "北京市", "北京市");
    	
    	Teacher teacher1 = new Teacher(112, "教师", "30220152200778", "王美红", "15759271302", "342637445@qq.com", "male", school, "member", "xxxxxx", "15759271301", "/aveter/xxx.png");
    	
    	Teacher teacher2 = new Teacher(111, "教师", "30220152200779", "邱明", "15759271301", "342637442@qq.com", "female", school, "captain","xxxxxxx", "15759271301", "/aveter/xxx.png");
    	*/
        return new CourseClass[]{

                new CourseClass(23, "周三1-2节", 60, "周三一二节", "海韵201", "OOAD", "teacher1"),

                new CourseClass(24, "周三3-4节", 60, "周五一二节", "海韵201", "J2EE", "teacher2")
                
        };
    }


    @GetMapping("/{classId}")
    public Object selectClass(@PathVariable("classId") int classId) {

        Proportions proportions = new Proportions(20, 60, 20, 50, 50);

        Class classDO = new Class(23, "周三1-2节", 60, "周三一二节", "海韵201", 1, "tpl/xxx.excel", proportions);

        return classDO;

    }

    @PutMapping("/{classId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateClass(@PathVariable("classId") int classId) {

        return null;

    }


    @DeleteMapping("/{classId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteClass(@PathVariable("classId") int classId) {
    	
        return null;

    }

    @GetMapping("/{classId}/student")
    public Object getStudentList() {
    	
    	School school1 = new School(50789, "北京大学", "北京市", "北京市");
    	
    	School school2 = new School(30258, "厦门大学", "福建省", "厦门市");
    	
        return new Student[]{

                new Student(111, "学生", "30220152200779", "邱明", "15759271301", "342637442@qq.com", "female", school1, "captain","xxxxxxx", "15759271301", "/aveter/xxx.png"),

                new Student(112, "学生", "30220152200778", "王美红", "15759271302", "342637445@qq.com", "male", school2, "member", "xxxxxx", "15759271301", "/aveter/xxx.png")
                
        };
    }    

    @PostMapping("/{classId}/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Object enroll(@PathVariable("classId") int classId) {

        return new Object() {

            public int id = 123;
            
            public String name = "周三1-2节";
            
            public String number = "20150102";
            
            public String url = "/avater/class";

        };

    }


    @DeleteMapping("/{classId}/student/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object dropClass(@PathVariable("classId") int classId, @PathVariable("studentId") int studentId) {

        return null;

    }



    @GetMapping("/{classId}/attendance")
    public String selectAttendance(@PathVariable("classId") int classId) {

        return "";

    }


    @GetMapping("/{classId}/classgroup")
    public Object selectClassGroup(@PathVariable("classId") int classId) {


    	
    	User leader = new User(1234,"30220152200779","何炅");

        List<User> members = new ArrayList<>();

        members.add(new User(5678,"30220152200778", "海涛"));

        members.add(new User(2222,"30220152200777","谢娜"));
        
    	Group group = new Group(20, leader, members);

        return group;

    }


    @PutMapping("/{classId}/classgroup/resign")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String groupLeaderResign(@PathVariable("classId") int classId) {

    	return null;

    }



    @PutMapping("/{classId}/classgroup/assign")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String groupMemberAssign(@PathVariable("classId") int classId) {
    	
        return null;

    }


    @PutMapping("/{classId}/classgroup/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String addGroupMember(@PathVariable("classId") int classId) {
    	
        return null;

    }

    @PutMapping("/{classId}/classgroup/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String removeGroupMember(@PathVariable("classId") int classId) {

        return null;

    }

}