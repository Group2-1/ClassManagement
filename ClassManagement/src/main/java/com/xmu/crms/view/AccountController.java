package com.xmu.crms.view;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.School;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.Response;
/**
 * 
 * @author lingyun
 *
 */
@RestController
public class AccountController {

    @GetMapping("/me")
    public User getMyInfo() {
    	
        User user = new User();
        School school = new School();
        school.setId(32);
        school.setName("厦门大学");
        user.setId(3486);
        user.setAvatar("/avatar/3486.png");
        user.setEmail("xxxxx@xx.com");
        user.setGender(1);
        user.setName("XXX");
        user.setNumber("234546");
        user.setSchool(school);
        user.setTitle(1);
        user.setPhone("12345678978");
        user.setType(1);
        return user;
    }

    @PutMapping("/me")
    public Response modifyInfo(@RequestBody User user, HttpServletResponse response) {
        
    	response.setStatus(204);
        return null;
    }
/*
    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public Object signIn() {
    	
    		return new Object(){
    			
    			public int id = 1;
    			public String type = "student";
    			public String name = "qiuming";
    			public String jwt = "xxx";
    					};
    }


    @GetMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public Object signIn(String type) {
       data.school = new School(1, "厦门大学", "福建省", "厦门市");

        data.user = new User(1, "teacher", "123456", "邱明",

                "12345678978", "342637442@qq.com", null, User.Gender.MALE, data.school);

        return null;

    }*/

}