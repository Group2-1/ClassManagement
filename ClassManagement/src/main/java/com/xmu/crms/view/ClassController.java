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
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.ClassVO;
import com.xmu.crms.view.vo.CourseClassVO;
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

        return new ClassVO[]{

                new ClassVO(23, "周一1-2节", "邱明", "学生公寓405", new CourseClassVO(1, "OOAD", 6)),

                new ClassVO(42, "周三3-4节", "邱明", "海韵教学楼202", new CourseClassVO(5, "J2EE", 2))
                
        };
    }


    @GetMapping("/{classId}")
    public Object selectClass(@PathVariable("classId") int classId) {

        Proportions proportions = new Proportions(20, 60, 20, 50, 50);

        Class classDO = new Class(23, "周三1-2节", "周三一二节", "海韵201", proportions);

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


    @PostMapping("/{classId}/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Object enroll(@PathVariable("classId") int classId) {

        return new Object() {

            public int id = 123;

        };

    }


    @DeleteMapping("/{classId}/student")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object dropClass(@PathVariable("classId") int classId) {

        return null;

    }



    @GetMapping("/{classId}/attendance")
    public String selectAttendance(@PathVariable("classId") int classId) {

        return "";/*????????????*/

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