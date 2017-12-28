package xmu.crms.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.demo.controller.vo.UserVO;

@RestController
public class UserController {

  /*  @GetMapping("/me")
    public UserVO getMe(){
        SchoolVO school = new SchoolVO();
        school.setId(BigInteger.valueOf(3));
        school.setProvince("福建省");
        school.setCity("厦门市");
        school.setName("厦门大学");
        UserVO user = new UserVO();
        user.setId(BigInteger.valueOf(3468));
        user.setType("student");
        user.setName("张三");
        user.setNumber("23320152202333");
        user.setPhone("18911114514");
        user.setEmail("23320152202333@stu.xmu.edu.cn");
        user.setGender("male");
        user.setSchoolVO(school);
        user.setTitle("本科");
        user.setAvatar("/avater/3486.png");
        return user;
    }*/

    @PutMapping("/me")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void putMe(@RequestBody UserVO user,HttpServletResponse response){
        return;
    }


}
