package com.xmu.crms.view;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/teacher/course/homePage")
    public String frame(Model model) {

        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

        return "/teacher/course/homePage";

    }



    @RequestMapping("/teacher/course/grade")
    public String grade(Model model) {

        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

        return "/teacher/course/grade";

    }

    @RequestMapping("/teacher/course/classInfo")

    public String classInfo(Model model) {

        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

        return "/teacher/course/classInfo";

    }



    @RequestMapping("/teacher/course/createClass")

    public String createClass(Model model) {

        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

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

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

        return "/teacher/course/seminarInfo";

    }



    @RequestMapping("/teacher/course/topicInfo")

    public String topicInfo(Model model) {

        model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});

        // public String[] seminarNames = new String[] {"周三1-2节", "周三000-2节","周三1-20节"}

        return "/teacher/course/topicInfo";

    }



    @RequestMapping("/student/course/home")

    public String stuhome(Model model) {

        model.addAttribute("data", new String[]{"讨论课1", "讨论课2", "讨论课3", "讨论课4"});

        return "/student/course/homePage";

    }



    @RequestMapping("/student/course/seminarInfo/fixed")

    public String stuSeminarInfo(Model model) {

        SeminarVO seminar = new SeminarVO((long)1,"讨论课1","本节课讨论第一章内容","固定分组","2017-11-10","2017-11-20");

        TopicVO topic = new TopicVO((long) 1, "A", "Domain Model", 5, 3);

        TopicVO topic1 = new TopicVO((long) 1, "B", "Domain Model", 5, 3);

        List<TopicVO> topics = new ArrayList<>();

        topics.add(topic);

        topics.add(topic1);

        model.addAttribute("data",seminar);

        model.addAttribute("topic",topics);

        return "/student/course/seminarInfo";

    }



    @RequestMapping("/student/course/seminarInfo/random")

    public String stuSeminarInfoR(Model model) {

        SchoolDO school = new SchoolDO((long)1,"厦门大学","福建省","厦门市");

        UserDO leader = new UserDO((long)1,"学生","24320152202000","sss","188xxxx8888","xxx@xx","111", UserDO.Gender.MALE,school);

        UserDO leader1 = new UserDO((long)1,"学生","24320152202000","xxx","188xxxx6666","xxx@xx","111", UserDO.Gender.MALE,school);

        List<UserDO> users = new ArrayList<>();

        users.add(leader);

        users.add(leader1);

        SeminarVO seminar = new SeminarVO((long)2,"讨论课2","本节课讨论第二章内容","随机分组","2017-11-12","2017-11-20");

        TopicVO topic = new TopicVO((long) 1, "A", "Domain Model", 5, 3);

        TopicVO topic1 = new TopicVO((long) 1, "B", "Domain Model", 5, 3);

        TopicVO topic2 = new TopicVO((long) 1, "C", "Domain Model", 5, 3);

        GroupVO group = new GroupVO((long)3,leader,users,topic,"report");

        List<TopicVO> topics = new ArrayList<>();

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

        List<GradeVO> lists = new ArrayList<>();

        GradeVO one = new GradeVO(1, "未命名", "no", 5, 5, 5);

        GradeVO two = new GradeVO(2, "haha", "lala", 4, 4, 4);

        GradeVO three = new GradeVO(1, "haha", "lala", 3, 4, 3.8);

        lists.add(one);

        lists.add(two);

        lists.add(three);

        model.addAttribute("data", lists);

        return "/student/course/grade";

    }



    @RequestMapping("/student/course/group")

    public String stuGroup(Model model) {

        SchoolDO school = new SchoolDO((long)1,"厦门大学","福建省","厦门市");

        UserDO leader = new UserDO((long)1,"学生","24320152202000","sss","188xxxx8888","xxx@xx","111", UserDO.Gender.MALE,school);

        UserDO leader1 = new UserDO((long)1,"学生","24320152202000","xxx","188xxxx6666","xxx@xx","111", UserDO.Gender.MALE,school);

        List<UserDO> users = new ArrayList<>();

        users.add(leader);

        users.add(leader1);

        TopicVO topic = new TopicVO((long) 1, "A", "Domain Model", 5, 3);

        GroupVO group = new GroupVO((long)3,leader,users,topic,"report");

        model.addAttribute("group",group);

        return "/student/course/groupInfo";

    }



    @RequestMapping("/student")

    public String stu(Model model) {

        return "/student/basicInfo";

    }

    @RequestMapping("/student/course")

    public String stuCourse(Model model) {

        ClassShowCourseVO course = new ClassShowCourseVO((long)1,"OOAD",2);

        ClassShowCourseVO  course1 = new ClassShowCourseVO((long)2,"J2EE",2);

        ClassShowVO class1 = new ClassShowVO((long)1,"周三1-2节","邱明","海韵208",course);

        ClassShowVO class2 = new ClassShowVO((long)2,"周三3-4节","邱明","海韵212",course1);

        ClassShowVO class3 = new ClassShowVO((long)3,"周一5-6节","邱明","海韵202",course);

        List<ClassShowVO> lists = new ArrayList<>();

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

        List<CourseVO> lists = new ArrayList<>();

        CourseVO course = new CourseVO((long)1,"J2EE",3,60,"2017-11-10","2017-11-20");

        CourseVO course1 = new CourseVO((long)2,"OOAD",3,130,"2017-10-01","2017-12-31");

        CourseVO course2 = new CourseVO((long)3,"python",1,50,"2017-09-22","2017-10-30");

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
