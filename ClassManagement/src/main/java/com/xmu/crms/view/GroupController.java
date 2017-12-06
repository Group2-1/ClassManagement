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

import com.xmu.crms.entity.Group;
import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/group")
public class GroupController {

    @GetMapping("/{groupId}")
    public Object selectGroup(@PathVariable("groupId") int groupId) {

        User leader = new User(888, "张三");

        User member1 = new User(999, "李四");

        User member2 = new User(9990, "王五");

        List<User> members = new ArrayList<>();

        members.add(member1);

        members.add(member2);

        Topic topic = new Topic(1, "A", "用例图", 5, 3);

        Group group = new Group(2, leader, members, topic, "report");

        return group;

    }

    
    @PutMapping("/{groupId}/resign")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object leaderResign(@PathVariable("groupId") int groupId) {

        return null;

    }
    
    
    @PutMapping("/{groupId}/assign")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object memberAssign(@PathVariable("groupId") int groupId) {

        return null;

    }


    @PutMapping("/{groupId}/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object addMember(@PathVariable("groupId") int groupId) {

        return null;

    }


    @PutMapping("/{groupId}/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object removeMember(@PathVariable("groupId") int groupId) {

        return null;

    }



    @PostMapping("/{groupId}/topic")
    @ResponseStatus(HttpStatus.CREATED)
    public Object selectTopicForGroup(@PathVariable("groupId") int groupId) {

        return new Object() {

            public int id = 247;

        };

    }



    @DeleteMapping("/{groupId}/topic/{topicId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object dropTopicForGroup(@PathVariable("groupId") int groupId, @PathVariable("topicId") int topicId) {

        return null;

    }



    @GetMapping("/{groupId}/grade")
    @ResponseStatus(HttpStatus.OK)
    public Object selectGroupGrade(@PathVariable("groupId") int groupId) {

        class PresentationGrade {

        	public Integer topicId;

            public Integer grade;

            public PresentationGrade(Integer topicId, Integer grade) {

                this.topicId = topicId;

                this.grade = grade;

            }

        }

        return new Object(){

            public PresentationGrade[] presentationGrade = new PresentationGrade[] {

                    new PresentationGrade(257,4), new PresentationGrade(258,5)

            };

            public Integer reportGrade = 3;

            public Integer grade = 4;

         };

    }


    @PutMapping("/{groupId}/grade/report")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateGroupReportGrade(@PathVariable("groupId") int groupId) {

        return null;

    }


    @PutMapping("/{groupId}/grade/presentation/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateGroupPresentationGrade(@PathVariable("groupId") int groupId) {

        return null;

    }

}