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

import com.xmu.crms.entity.Group;
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.Attendance;
import com.xmu.crms.view.vo.Message;
import com.xmu.crms.view.vo.SeminarDetail;
import com.xmu.crms.view.vo.SiteVO;
import com.xmu.crms.view.vo.Status;
import com.xmu.crms.view.vo.StudentSeminar;

/**

 * @author lingyun

 */
@RestController
@RequestMapping("/seminar")
public class SeminarController {

    @GetMapping("/{seminarId}")
    public Seminar getSeminar(@PathVariable("seminarId") int seminarId) {
    	
        return new Seminar(29, "讨论课1", "需求分析", "fixed", "2017-10-01", "2017-10-07");
        
    }

    @PutMapping("/{seminarId}")
    public Message updateSeminar(@PathVariable("seminarId") int seminarId, @RequestBody Seminar seminar, HttpServletResponse response) {

    	response.setStatus(200);
        return null;

    }

    @DeleteMapping("/{seminarId}")
    public Message deleteSeminar(@PathVariable("seminarId") int seminarId, HttpServletResponse response) {
    	
    	response.setStatus(204);
        return null;

    }
    
	@GetMapping("/{seminarId}/my")
    public StudentSeminar selectMySeminar(@PathVariable("seminarId") int seminarId) {
        
		StudentSeminar seminar = new StudentSeminar();
        seminar.setId(seminarId);
        seminar.setName("概要设计");
        seminar.setGroupingMethod("random");
        seminar.setCourseName("OOAD");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,9,11);
        seminar.setStartTime(calendar.getTime());
        calendar.set(2017,9,24);
        seminar.setEndTime(calendar.getTime());
        seminar.setClassCalling(-1);
        seminar.setIsLeader(true);
        seminar.setAreTopicsSelected(true);
        return seminar;       
    	/*return new StudentSeminar(seminarId, "概要设计", "random", "面向对象分析与设计", new Date(2017,9,11), new Date(2017,9,24), -1, true, true);*/

    }

/*
    @DeleteMapping("/{seminarId}/my")
    public Object myInfoForSeminar(@PathVariable("seminarId") int seminarId) {
		
    	StudentSeminar seminar = new StudentSeminar();
        seminar.setId(seminarId);
        seminar.setName("概要设计");
        seminar.setGroupingMethod("random");
        seminar.setCourseName("OOAD");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,9,11);
        seminar.setStartTime(calendar.getTime());
        calendar.set(2017,9,24);
        seminar.setEndTime(calendar.getTime());
        seminar.setClassCalling(-1);
        seminar.setIsLeader(true);
        seminar.setAreTopicsSelected(true);
        return seminar; 

    }*/
	
    @GetMapping("/{seminarId}/detail")
    public SeminarDetail getSeminarDetail(@PathVariable("seminarId") int seminarId) {

        SeminarDetail seminarDetail = new SeminarDetail();
        seminarDetail.setId(32);
        seminarDetail.setName("概要设计");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,9,10);
        seminarDetail.setStartTime(calendar.getTime());
        calendar.set(2017,9,24);
        seminarDetail.setEndTime(calendar.getTime());
        seminarDetail.setSite("海韵201");
        seminarDetail.setTeacherName("邱明");
        seminarDetail.setTeacherEmail("mingqiu@xmu.edu.cn");
        return seminarDetail;

    } 
    
    
    @GetMapping("/{seminarId}/topic")
    public List<Topic> getTopics(@PathVariable("seminarId") int seminarId, @RequestBody Topic topic, HttpServletResponse response) {

        List<Topic> topics = new ArrayList<>();
        Topic topic1 = new Topic();
        topic1.setId(11);
        topic1.setName("概要设计");
        topic1.setDescription("领域模型与模块划分");
        topic1.setGroupLeft(2);
        topic1.setGroupLimit(5);
        topic1.setGroupMemberLimit(6);

        Topic topic2 = new Topic();
        topic2.setId(11);
        topic2.setName("详细设计");
        topic2.setDescription("类的设计");
        topic2.setGroupLeft(2);
        topic2.setGroupLimit(5);
        topic2.setGroupMemberLimit(6);
        
        topics.add(topic1);
        topics.add(topic2);
        response.setStatus(200);
        return topics;

    }

    @PostMapping("/{seminarId}/topic")
    public 	Topic createTopic(@PathVariable("seminarId") int seminarId, @RequestBody Topic topic, HttpServletResponse response) {

        Topic topic1 = new Topic();
        topic1.setId(11);
        topic1.setSerial("B");
        topic1.setDescription("模块划分");
        response.setStatus(204);
        return topic1;

    }

    @GetMapping("/{seminarId}/group")
    public List<Group> selectGroups(@PathVariable("seminarId") int seminarId) {
    	
    	List<Group> groups = new ArrayList<>();
    	Group group1 = new Group();
    	group1.setId(28);
    	group1.setName("1A1");
    	
    	List<Topic> topics = new ArrayList<>();
    	Topic topic1 = new Topic();
    	topic1.setId(11);
    	topic1.setName("模块划分");
    	topics.add(topic1);
    	Topic topic2 = new Topic();
    	topic2.setId(12);
    	topic2.setName("详细设计");
    	topics.add(topic2);
    	
    	group1.setTopics(topics);
    	groups.add(group1);
    	return groups;

    }


    @GetMapping("/{seminarId}/group/my")
    public Object selectMyGroup(@PathVariable("seminarId") int seminarId) {

        Group group = new Group();
        group.setId(11);
        group.setName("3A1");
        User leader = new User();
        leader.setId(123);
        leader.setName("大张伟");
        group.setLeader(leader);
        
        List<User> members = new ArrayList<>();
        User member1 = new User();
        member1.setId(779);
        member1.setName("杨幂");
        User member2 = new User();
        member2.setId(778);
        member2.setName("易烊千玺");
        members.add(member1);
        members.add(member2);
        group.setMembers(members);
        
        List<Topic> topics = new ArrayList<>();
        Topic topic = new Topic();
        topic.setId(12);
        topic.setName("领域模型与模块划分");
        topics.add(topic);
        group.setTopics(topics);
        return group;
        
    }

    
    @GetMapping("/{seminarId}/class/{classId}/attendance")
    public Attendance selectGroupLate(@PathVariable("seminarId") int seminarId, @PathVariable("classId") int classId) {
        
    	Attendance attendance = new Attendance();	
        attendance.setNumPresent(40);
        attendance.setNumStudent(60);
        attendance.setGroup("grouping");
        attendance.setStatus("calling");
        return attendance;

    }    
    
   
    @GetMapping("/{seminarId}/class/{classId}/attendence/present")
    public List<User> selectGroupLateList(@PathVariable("seminarId") int seminarId, @PathVariable("classId") int classId) {

        List<User> present = new ArrayList<>();
        User student1 = new User();
        student1.setId(779);
        student1.setName("杨幂");
        present.add(student1);
        User student2 = new User();
        student2.setId(778);
        student2.setName("易烊千玺");
        present.add(student2);
        return present;

    }
    
    
    @GetMapping("/{seminarId}/class/{classId}/attendance/late")
    public List<User> selectAttendanceLate(@PathVariable("seminarId") int seminarId, @PathVariable("classId") int classId) {
        
    	List<User> late = new ArrayList<>();
        User student1 = new User();
        student1.setId(779);
        student1.setName("杨幂");
        late.add(student1);
        User student2 = new User();
        student2.setId(778);
        student2.setName("易烊千玺");
        late.add(student2);
        return late;

    }
    
    @GetMapping("/{seminarId}/class/{classId}/attendance/absent")
    public List<User> getAbsent(@PathVariable("seminarId") int seminarId, @PathVariable("classId") int classId) {

        List<User> absent = new ArrayList<>();
        User student1 = new User();
        student1.setId(34);
        student1.setName("张六");
        absent.add(student1);
        return absent;

    }         
 
    @PutMapping("/seminar/{seminarId}/class/{classId}/attendance/{studentId}")
    public Status signIn(@PathVariable("seminarId") int seminarId, @PathVariable("classId") int classId, @PathVariable("studentId") int studentId, @RequestBody SiteVO site, HttpServletResponse response) {
        
    	response.setStatus(200);
        Status status = new Status();
        status.setStatus("late");
        return status;
    }

}