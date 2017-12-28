package xmu.crms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/login")
    public String accountLogin(){
        return "common/AccountLoginPage";
    }

    @RequestMapping("/login2")
    public String wechatLogin(){
        return "common/WechatLoginPage";
    }

    @RequestMapping("/registerpage")
    public String regsiterpage(){
        return "common/RegisterPage";
    }

    /*
    *teacher
     */

    @RequestMapping("/teacher/bind")
    public String bind() {

        return "common/RegisterPage";
    }

    @RequestMapping("/teacher/classInfo")
    public String classInfo() {

        return "teacher/TeacherClassInfo";
    }

    @RequestMapping("/teacher/courseHome")
    public String frame() {
       
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

    @RequestMapping("teacher/createSchool")
    public String createSchool() {

        return "teacher/TeacherCreateSchool";
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

    /*
    * student
    */
}
