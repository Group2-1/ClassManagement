package xmu.crms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/student")
public class StudentController {
	
    @RequestMapping("/bind")
    public String studentBind(){

        return "student/StudentBindPage";
    }

    @RequestMapping("/chooseCourse")
    public String chooseCourse() {

        return "student/StudentChooseCoursePage";
    }

    @RequestMapping("/courseHome")
    public String stuhome() {

        return "/student/StudentCourseHome";
    }

    @RequestMapping("/courseInformation")
    public String courseInformation(){

        return "/student/StudentCourseInformation";
    }

    @RequestMapping("/discussionClassPagefixed")
    public String discussionClassPagefixed(){

        return "student/StudentDiscussionClassPagefixed";
    }

    @RequestMapping("/discussionClassPagerandom")
    public String discussionClassPagerandom(){

        return "student/StudentDiscussionClassPagerandom";
    }

    @RequestMapping("/home")
    public String home() {

        return "student/StudentHomePage";
    }

    @RequestMapping("/infoModify")
    public String infoModify() {

        return "student/StudentInfoModifyPage";
    }

    @RequestMapping("/modifyGroup")
    public String modifyGroup() {

        return "student/StudentModifyGroupPage";
    }

    @RequestMapping("/viewGrade")
    public String viewGrade() {

        return "student/StudentViewGradePage";
    }

    @RequestMapping("/viewGroup")
    public String viewGroup() {

        return "student/StudentViewGroupPage";
    }

    @RequestMapping("/viewTopicfixed")
    public String viewTopicfixed() {

        return "student/StudentViewTopicPagefixed";
    }

    @RequestMapping("/viewTopicrandom")
    public String viewTopicrandom() {

        return "student/StudentViewTopicPagerandom";
    }
}
