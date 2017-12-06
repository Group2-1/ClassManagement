package com.xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.School;
import com.xmu.crms.entity.User;
import com.xmu.crms.view.vo.MyData;
/**
 * 
 * @author lingyun
 *
 */
@RestController
public class AccountController {

	public School school = new School(1, "厦门大学", "福建省", "厦门市");
	
	public User user = new User(1, "teacher", "邱明","12345678978", "342637442@qq.com", User.Gender.MALE, school, "captain","/xxx/");
	/*
	List<Course> courses = new ArrayList<>();
	courses.add(1, "OOAD", 3, 60, "2017-09-01", "2018-01-01");
	courses.add(2, "J2EE", 1, 60, "2017-09-01", "2018-01-01");
	*/
    public MyData data = new MyData(user,school,null,null,null);

    @GetMapping("/me")
    public Object selectMe() {
        return data.user;

    }

    @PutMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateMe() {
        return null;

    }
/*
    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public Object signUp(
    		@RequestParam(value="phone", defaultValue="189111114514") String phone,
    		@RequestParam(value="password", defaultValue="qwer2345") String password, Model model) {
    	if((phone=="189111114514")&&(password=="qwer2345"))
    		return new Object(){
    					};

    }*/
    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.CREATED)
    public Object signUp(@PathVariable("phone") String phone, @PathVariable("password") String password) {
    	return new Object(){
    		public int id = 1205;
    		public String type = "student";
    		public String name = "阿拉蕾" ;
    		public String jwt = " xxxxxxxxxxxx";
    	};
    }

    @GetMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    public Object signIn(String type) {
       data.school = new School(1, "厦门大学", "福建省", "厦门市");

        data.user = new User(1, "teacher", "123456", "邱明",

                "12345678978", "342637442@qq.com", null, User.Gender.MALE, data.school);

        return null;

    }
    
    @GetMapping("/signin?code=ghjiugh&state=wrerfwe3er&success_url=student_index.html")
    @ResponseStatus(HttpStatus.OK)
    public Object getSignInWechat(){  	
    	return new Object(){
    		public int id = 1205;
    		public String type = "student";
    		public String name = "阿拉蕾" ;
    		public String jwt = " xxxxxxxxxxxx";
    	};
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    

}