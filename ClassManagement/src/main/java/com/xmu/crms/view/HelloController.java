package com.xmu.crms.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/login")
    public String AccountLogin(Model model) {
        return "common/AccountLoginPage"; 	
    }	
    
    @RequestMapping("/login2")
    public String WeChatLogin(Model model) {
        return "common/WechatLoginPage"; 	
    }	
    /**teacher page
     *****************************************************************/
    
    @RequestMapping("/teacher/bind")
    public String bind() {
    	
        return "common/RegisterPage";
    }    
    
    @RequestMapping("/teacher/classInfo")
    public String classInfo() {
    	
        return "teacher/TeacherClassInfo";
    }   
    
    @RequestMapping("/teacher/courseHome")
    public String frame(Model model) {
        /*model.addAttribute("data", new String[]{"周三1-2节", "周三000-2节", "周三1-20节"});*/
        return "teacher/TeacherCourseHomePage";
    }
    
    @RequestMapping("/teacher/courseInfoModify")
    public String courseInforModify() {
    	
        return "teacher/TeacherCourseInfoModify";
    }
    
    @RequestMapping("/teacher/courseInformation")
    public String teacherCourseInformation() {
    	
        return "teacher/TeacherCourseInformation";
    }
 
    @RequestMapping("/teacher/createClass")
    public String createClass() {
    	
        return "teacher/TeacherCreateClass";
    }
    
    @RequestMapping("/teacher/createCourse")
    public String createCourse() {
    	
        return "teacher/TeacherCreateCoursePage";
    }
    
    @RequestMapping("/teacher/createTopic")
    public String createTopic() {
    	
        return "teacher/TeacherCreateTopic";
    }
    
    @RequestMapping("teacher/home")
    public String teacherHome(){
    	
    	return "teacher/TeacherHomePage";
    }
    
    @RequestMapping("/teacher/infoModify")
    public String teacherInfoModify() {
    	
        return "teacher/TeacherInfoModifyPage";
    }  
    
    @RequestMapping("/teacher/modifyClass")
    public String modifyClass() {
    	
        return "teacher/TeacherModifyClass";
    } 
    
    @RequestMapping("/teacher/scoreHome")
    public String scoreHome() {
    	
        return "teacher/TeacherScoreHome";
    }
    
    @RequestMapping("/teacher/scoreReport")
    public String scoreReport() {
    	
        return "teacher/TeacherScoreReportPage";
    }

    @RequestMapping("/teacher/seminarInfo")
    public String seminarInfo() {

        return "teacher/TeacherSeminarInfo";
    }
    
    @RequestMapping("/teacher/updateSeminar")
    public String updateSeminar() {
    	
        return "teacher/TeacherUpdateSeminar";
    }

    @RequestMapping("/teacher/updateTopic")
    public String updateTopic() {
    	
        return "teacher/TeacherUpdateTopic";
    }
    
    @RequestMapping("/teacher/viewTopic")
    public String viewTopic() {
    	
        return "teacher/TeacherViewTopic";
    } 
    
    /** student page
     * ****************************************************************/

    @RequestMapping("/student/bind")
    public String studentBind(){
    	
    	return "student/RegisterPage";
    }

    @RequestMapping("/student/chooseCourse")
    public String chooseCourse() {
    	
        return "student/StudentChooseCoursePage";
    }
    
    @RequestMapping("/student/courseHome")
    public String stuhome(Model model) {
        
        return "/student/StudentCourseHome";
    }

    @RequestMapping("/student/courseInformation")
    public String courseInformation(){
    	
    	return "/student/StudentCourseInformation";
    }
    
    @RequestMapping("student/discussionClassPagefixed")
    public String discussionClassPagefixed(){
    	
    	return "student/StudentDiscussionClassPagefixed";
    }
    
    @RequestMapping("student/discussionClassPagerandom")
    public String discussionClassPagerandom(){
    	
    	return "student/StudentDiscussionClassPagerandom";
    }
    
    @RequestMapping("/student/home")
    public String home() {
    	
        return "student/StudentHomePage";
    } 
    
    @RequestMapping("/student/infoModify")
    public String infoModify() {
    	
        return "student/StudentInfoModifyPage";
    }
    
    @RequestMapping("/student/modifyGroup")
    public String modifyGroup() {
    	
        return "student/StudentModifyGroupPage";
    }
    
    @RequestMapping("/student/viewGrade")
    public String viewGrade() {
    	
        return "student/StudentViewGradePage";
    }
    
    @RequestMapping("/student/viewGroup")
    public String viewGroup() {
    	
        return "student/StudentViewGroupPage";
    }
    
    @RequestMapping("/student/viewTopicfixed")
    public String viewTopicfixed() {
    	
        return "student/StudentViewTopicPagefixed";
    }
    
    @RequestMapping("/student/viewTopicrandom")
    public String viewTopicrandom() {
    	
        return "student/StudentViewTopicPagerandom";
    }

}
