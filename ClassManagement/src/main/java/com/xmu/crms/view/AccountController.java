package com.xmu.crms.view;

import javax.xml.crypto.Data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.School;
import com.xmu.crms.entity.User;
/**
 * 
 * @author lingyun
 *
 */
@RestController
public class AccountController {
	
    public Data data = new Data();

    @GetMapping("/me")
    public Object selectMe() {
        return data.user;

    }

    @PutMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateMe() {
        return null;

    }



    @GetMapping("/signIn")
    public Object signIn(String type) {
       data.school = new School(1, "厦门大学", "福建省", "厦门市");

        data.user = new User(1, "teacher", "123456", "邱明",

                "12345678978", "342637442@qq.com", null, User.Gender.MALE, data.school);

        return null;

    }

}