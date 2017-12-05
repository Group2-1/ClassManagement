package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Course;
import com.xmu.crms.entity.Grade;
import com.xmu.crms.entity.Group;
import com.xmu.crms.entity.School;
import com.xmu.crms.entity.Seminar;
import com.xmu.crms.entity.Topic;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.ClassVO;
import com.xmu.crms.view.vo.CourseClassVO;

@RestController
public class HelloController {

    @RequestMapping("/teacher/course/homePage")
    public String frame(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/homePage";
    }

    @RequestMapping("/teacher/course/grade")
    public String grade(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/grade";
    }

    @RequestMapping("/teacher/course/classInfo")
    public String classInfo(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/classInfo";
    }

    @RequestMapping("/teacher/course/createClass")
    public String createClass(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/createClass";
    }


    @RequestMapping("/teacher/course/createTopic")
    public String createTopic(Model model) {
        return "/teacher/course/createTopic";
    }


    @RequestMapping("/teacher/course/createSeminar")
    public String createSeminar(Model model) {
        return "/teacher/course/createSeminar";
    }

    @RequestMapping("/teacher/course/seminarInfo")
    public String seminarInfo(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/seminarInfo";
    }


    @RequestMapping("/teacher/course/topicInfo")
    public String topicInfo(Model model) {
        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});
        return "/teacher/course/topicInfo";
    }



    @RequestMapping("/student/course/home")
    public String stuhome(Model model) {
        model.addAttribute("data", new String[]{"讨论课1", "讨论课2", "讨论课3", "讨论课4"});
        return "/student/course/homePage";
    }


    @RequestMapping("/student/course/seminarInfo/fixed")
    public String stuSeminarInfo(Model model) {
        Seminar seminar = new Seminar(1,"讨论课1","本节课讨论第一章内容","固定分组","2017-11-10","2017-11-20");

        Topic topic = new Topic(1, "A", "Domain Model", 5, 3);

        Topic topic1 = new Topic(1, "B", "Domain Model", 5, 3);

        List<Topic> topics = new ArrayList<>();

        topics.add(topic);

        topics.add(topic1);

        model.addAttribute("data",seminar);

        model.addAttribute("topic",topics);

        return "/student/course/seminarInfo";

    }



    @RequestMapping("/student/course/seminarInfo/random")
    public String stuSeminarInfoR(Model model) {

        School school = new School(1,"厦门大学","福建省","厦门市");

        User leader = new User(1,"学生","30220152200779","阿拉蕾","12345678910","342637442@qq.com","1101001", User.Gender.MALE,school);

        User leader1 = new User(1,"学生","30220152200770","泰勒","15263478952","342637425@qq.com","1111011", User.Gender.MALE,school);

        List<User> users = new ArrayList<>();

        users.add(leader);

        users.add(leader1);

        Seminar seminar = new Seminar(2,"讨论课2","需求分析之用例图","随机分组","2017-12-01","2017-12-31");

        Topic topic = new Topic(1, "A", "Domain Model", 5, 3);

        Topic topic1 = new Topic(1, "B", "Domain Model", 5, 3);

        Topic topic2 = new Topic(1, "C", "Domain Model", 5, 3);

        Group group = new Group(3,leader,users,topic,"report");

        List<Topic> topics = new ArrayList<>();

        topics.add(topic);

        topics.add(topic1);

        topics.add(topic2);

        model.addAttribute("group",group);

        model.addAttribute("data",seminar);

        model.addAttribute("topic",topics);

        return "/student/course/seminarInfo";

    }



    @RequestMapping("/student/course/grade")
    public String stuGrade(Model model) {
        List<Grade> lists = new ArrayList<>();

        Grade one = new Grade(1, "undefined", "no", 5, 5, 5);

        Grade two = new Grade(2, "second", "lala", 4, 4, 4);

        Grade three = new Grade(1, "three", "lala", 3, 4, 3.8);

        lists.add(one);

        lists.add(two);

        lists.add(three);

        model.addAttribute("data", lists);

        return "/student/course/grade";

    }



    @RequestMapping("/student/course/group")
    public String stuGroup(Model model) {

        School school = new School(1,"厦门大学","福建省","厦门市");

        User leader = new User(1,"学生","24320152202000","sss","188xxxx8888","xxx@xx","111", User.Gender.MALE,school);

        User leader1 = new User(1,"学生","24320152202000","xxx","188xxxx6666","xxx@xx","111", User.Gender.MALE,school);

        List<User> users = new ArrayList<>();

        users.add(leader);

        users.add(leader1);

        Topic topic = new Topic(1, "A", "Domain Model", 5, 3);

        Group group = new Group(3,leader,users,topic,"report");

        model.addAttribute("group",group);

        return "/student/course/groupInfo";

    }



   @RequestMapping("/student")
    public String stu(Model model) {
        return "/student/basicInfo";
    }

    @RequestMapping("/student/course")
    public String stuCourse(Model model) {

        CourseClassVO course = new CourseClassVO(1,"OOAD",2);

        CourseClassVO  course1 = new CourseClassVO(2,"J2EE",2);

        ClassVO class1 = new ClassVO(1,"周三1-2节","邱明","海韵208",course);

        ClassVO class2 = new ClassVO(2,"周三3-4节","邱明","海韵212",course1);

        ClassVO class3 = new ClassVO(3,"周一5-6节","邱明","海韵202",course);

        List<ClassVO> lists = new ArrayList<>();

        lists.add(class1);

        lists.add(class2);

        lists.add(class3);

        model.addAttribute("data", lists);

        return "/student/courseInfo";

    }



    @RequestMapping("/student/choose")
    public String stuChoose(Model model) {
       return "/student/chooseCourse";

    }



    @RequestMapping("/teacher")
    public String tea(Model model) {
        return "/teacher/basicInfo";

    }


    @RequestMapping("/teacher/course")
    public String teaCourse(Model model) {
        List<Course> lists = new ArrayList<>();
        Course course = new Course(1,"J2EE",3,60,"2017-11-10","2017-11-20");
        Course course1 = new Course(2,"OOAD",3,130,"2017-10-01","2017-12-31");
        Course course2 = new Course(3,"python",1,50,"2017-09-22","2017-10-30");
        lists.add(course);
        lists.add(course1);
        lists.add(course2);
        model.addAttribute("data", lists);
        return "/teacher/courseInfo";
    }



    @RequestMapping("/teacher/createCourse")
    public String teaCreate(Model model) {
        return "/teacher/createCourse";
    }

}
