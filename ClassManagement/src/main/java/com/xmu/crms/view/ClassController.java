package com.xmu.crms.view;

import java.util.ArrayList;
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
import com.xmu.crms.entity.Proportions;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.ClassGroupVO;
import com.xmu.crms.view.vo.CourseClassVO;
import com.xmu.crms.view.vo.Response;
import com.xmu.crms.view.vo.SelectClassVO;
/**
 * class controller
 * @author qinlingyun
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @GetMapping
    public List<CourseClassVO> getClassList() {
        List<CourseClassVO> courseClasses = new ArrayList<>();
        CourseClassVO courseClass1 = new CourseClassVO();
        courseClass1.setId(11);
        courseClass1.setName("周三1-2节");
        courseClass1.setNumStudent(60);
        courseClass1.setTime("每周周一1-2、单周周三3-4");
        courseClass1.setSite("学生公寓405");
        courseClass1.setCourseName("面向对象分析与设计");
        courseClass1.setCourseTeacher("邱明");

        CourseClassVO courseClass2 = new CourseClassVO();
        courseClass2.setId(12);
        courseClass2.setName("一班");
        courseClass2.setNumStudent(60);
        courseClass2.setTime("每周周三1-2");
        courseClass2.setSite("海韵教学楼104");
        courseClass2.setCourseName("J2EE技术");
        courseClass2.setCourseTeacher("邱明");

        courseClasses.add(courseClass1);
        courseClasses.add(courseClass2);

        return courseClasses;
    }


    @GetMapping("/{classId}")
    public Class getClass(@PathVariable("classId") int id) {
        Class class1 = new Class();
        class1.setId(11);
        class1.setName("周三1-2节");
        class1.setNumStudent(120);
        class1.setTime("周三一二节");
        class1.setSite("海韵201");
        class1.setCalling(-1);
        class1.setRoster("/roster/周三12班.xlsx");
        Proportions proportions = new Proportions();
        proportions.setA(20);
        proportions.setB(60);
        proportions.setC(20);
        proportions.setReport(50);
        proportions.setPresentation(50);
        class1.setProportions(proportions);
        return class1;
    }
    
    @PutMapping("/{classId}")
    public Response updateClass(@PathVariable("classId") int classId,
                                HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @DeleteMapping("/{classId}")
    public Response deleteClass(@PathVariable("classId") int classId,
                                HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @GetMapping("/{classId}/student")
    public List<User> getStudentList(@PathVariable int classId) {
		List<User> students = new ArrayList<>();
        User student1 = new User();
        student1.setId(11);
        student1.setName("覃玲芸");
        student1.setNumber("30220152200779");
        students.add(student1);
        User student2 = new User();
        student2.setId(12);
        student2.setName("阿拉蕾");
        student2.setNumber("30220152200778");
        students.add(student2);
        return students;
    }

    @PostMapping("{classId}/student")
    public SelectClassVO chooseClass(@RequestBody User student, @PathVariable("classId") int classId, HttpServletResponse response) {
        SelectClassVO selectClass = new SelectClassVO();
        selectClass.setUrl("/class/3/student/11");
        response.setStatus(201);
        return selectClass;
    }

    @DeleteMapping("/{classId}/student/{studentId}")
    public Response cancelClass(@PathVariable("classId") int classId,
                                @PathVariable("studentId") int studentId,
                                HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @GetMapping("/{classId}/classgroup")
    public ClassGroupVO getClassGroup(@PathVariable("classId") int classId) {
        ClassGroupVO classGroup = new ClassGroupVO();
        User leader = new User();
        leader.setId(11);
        leader.setName("覃玲芸");
        leader.setNumber("30220152200779");
        classGroup.setLeader(leader);
        
        List<User> members = new ArrayList<>();
        User member1 = new User();       
        member1.setId(12);
        member1.setName("覃xx");
        member1.setNumber("30220152200778");
        User member2 = new User();
        member2.setId(12);
        member2.setName("李xx");
        member2.setNumber("30220152200777");
        members.add(member1);
        members.add(member2);
        classGroup.setMembers(members);
        return classGroup;
    }

    @PutMapping("/{classId}/classgroup/resign")
    public Response resignLeader(@PathVariable("classId") int classId,
                                 @RequestBody User student,
                                 HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @PutMapping("/{classId}/classgroup/assign")
    public Response assignLeader(@PathVariable("classId") int classId,
                                 @RequestBody User student,
                                 HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @PutMapping("/{classId}/classgroup/add")
    public Response addMember(@PathVariable("classId") int classId,
                              @RequestBody User student,
                              HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }

    @PutMapping("/{classId}/classgroup/remove")
    public Response removeMember(@PathVariable("classId") int classId,
                                 @RequestBody User student,
                                 HttpServletResponse response) {
        response.setStatus(204);
        return null;
    }
    /*
    @GetMapping("/{classId}/attendance")
    public String selectAttendance(@PathVariable("classId") int classId) {

        return "";

    }*/

}