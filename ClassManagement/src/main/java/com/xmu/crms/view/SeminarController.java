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
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;

/**

 * @author lingyun

 */
@RestController
@RequestMapping("/seminar")
public class SeminarController {

    @GetMapping("/{seminarId}")
    public Object selectSeminar(@PathVariable("seminarId") int seminarId) {

        return new Seminar(29, "讨论课1", "需求分析", "fixed", "2017-10-01", "2017-10-07");

    }

    @PutMapping("/{seminarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateSeminar(@PathVariable("seminarId") int seminarId) {

        return null;

    }

    @DeleteMapping("/{seminarId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteSeminar(@PathVariable("seminarId") int seminarId) {

        return null;

    }

    @DeleteMapping("/{seminarId}/my")
    public Object myInfoForSeminar(@PathVariable("seminarId") int seminarId) {
        return new Object() {

            public Integer id = 32;

            public String name = "需求分析";

            public String groupingMethod = "random";

            public String courseName = "面向对象分析与设计";

            public String startTime = "2017-10-07";

            public String endTime = "2017-10-27";

            public Integer classCalling = 10;

            public boolean isLeader = true;

            public boolean areTopicSelected = true;

        };

    }

    public Object seminarDetail(@PathVariable("seminarId") int seminarId) {
        return new Object() {

            public Integer id = 32;

            public String name = "需求分析";

            public String startTime = "2017-10-07";

            public String endTime = "2017-10-27";

            public String site = "海韵206";

            public String teacherName = "邱明";

            public String teacherEmail = "mingqiu@xmu.edu.cn";

        };

    }

    @GetMapping("/{seminarId}/topic")
    public Object selectTopics(@PathVariable("seminarId") int seminarId) {

        return new Topic[]{

                new Topic(257, "概要设计", "领域模型与模块划分", 5, 2)

        };

    }

    @PostMapping("/{seminarId}/topic")
    @ResponseStatus(HttpStatus.CREATED)
    public Object createTopic(@PathVariable("seminarId") int seminarId) {

        return null;

    }

    @GetMapping("/{seminarId}/group")
    public Object selectGroups(@PathVariable("seminarId") int seminarId) {
    	
        class Tmp {

            public Integer id;

            public String name;

            public Topic[] topics;

            public Tmp(Integer id, String name, Topic[] topics) {

                this.id = id;

                this.name = name;

                this.topics = topics;

            }

        }

        return new Tmp[]{

                new Tmp(28, "1A1", new Topic[]{new Topic(25, "模块划分")}),

                new Tmp(29, "1A2", new Topic[]{new Topic(25, "模块划分")})

        };

    }


    @GetMapping("/{seminarId}/group/my")
    public Object selectMyGroup(@PathVariable("seminarId") int seminarId) {

        User leader = new User(123, "大张伟");

        User member1 = new User(456, "易烊千玺");

        User member2 = new User(789, "杨幂");

        List<User> members = new ArrayList<>();

        members.add(member1);

        members.add(member2);

        Topic topic = new Topic(1, "A", "Domain Model", 5, 3);

        Group group = new Group(3, leader, members, topic, "report");

        return group;

    }

}