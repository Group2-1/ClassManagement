package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.GroupVO;

/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @GetMapping("/{groupId}")
    public GroupVO getGroup(@PathVariable("groupId") int groupId) {

    	 GroupVO group = new GroupVO();   	
         /*group.setId(11);
         User leader = new User();
         leader.setId(779);
         leader.setName("7A2");
         group.setLeader(leader);
         
         List<User> members = new ArrayList<>();
         User member1 = new User();
         member1.setId(11);
         member1.setName("阿拉蕾");
         User member2 = new User();
         member2.setId(12);
         member2.setName("张美丽");
         members.add(member1);
         members.add(member2);
         group.setMembers(members);
         
         List<Topic> topics = new ArrayList<>();
         Topic topic = new Topic();
         topic.setId(23);
         topic.setName("系统用例描述");
         topics.add(topic);
         group.setTopics(topics);
         group.setReport("/xxx.pdf");*/
         return group;

    }

    
    @PutMapping("/{groupId}/resign")
    public Response leaderResign(@PathVariable("groupId") int groupId, @RequestBody User leader, HttpServletResponse response) {

    	response.setStatus(204);
        return null;

    }
    
    
    @PutMapping("/{groupId}/assign")
    public Response memberAssign(@PathVariable("groupId") int groupId, @RequestBody User user, HttpServletResponse response) {

    	response.setStatus(204);
    	return null;

    }


    @PutMapping("/{groupId}/add")
    public Response addMember(@PathVariable("groupId") int groupId, @RequestBody User user, HttpServletResponse response) {

    	response.setStatus(204);
    	return null;

    }


    @PutMapping("/{groupId}/remove")
    public Response removeMember(@PathVariable("groupId") int groupId, @RequestBody User user, HttpServletResponse response) {

    	response.setStatus(204);
    	return null;

    }



    @PostMapping("/{groupId}/topic")
    public SelectTopicVO selectTopicForGroup(@PathVariable("groupId") int groupId,@RequestBody Topic topic, HttpServletResponse response) {

        SelectTopicVO selectTopic = new SelectTopicVO();
        selectTopic.setUrl("/group/27/topic/23");
        response.setStatus(201);
        return selectTopic;

    }



    @DeleteMapping("/{groupId}/topic/{topicId}")
    public Response cancelTopicSelection(@PathVariable("groupId") int groupId, @PathVariable("topicId") int topicId,  HttpServletResponse response) {

        response.setStatus(204);
        return null;
    }



    @GetMapping("/{groupId}/grade")
    public SeminarGrade getGroupGrade(@PathVariable("groupId") int groupId) {

        SeminarGrade grade = new SeminarGrade();
        grade.setReportGrade(3);
        grade.setGrade(4);
        
        List<PresentationGrade> presentationGrade = new ArrayList<>();
        PresentationGrade presentationGrade1 = new PresentationGrade();
        presentationGrade1.setTopicId(257);
        presentationGrade1.setGrade(4);
        presentationGrade.add(presentationGrade1);
        
        PresentationGrade presentationGrade2 = new PresentationGrade();
        presentationGrade2.setTopicId(285);
        presentationGrade2.setGrade(5);
        presentationGrade.add(presentationGrade2);
        
        grade.setPresentationGrade(presentationGrade);
        return grade;

    }


    @PutMapping("/{groupId}/grade/report")
    public Response updateGroupReportGrade(@PathVariable("groupId") int groupId, HttpServletResponse response) {

    	response.setStatus(204);
        return null;

    }

    @PutMapping("/{groupId}/grade/presentation/{studentId}")
    public Response updateGroupPresentationGrade(@PathVariable("groupId") int groupId, @PathVariable("studentId") int studentId, HttpServletResponse response) {

    	response.setStatus(204);
        return null;

    }

}