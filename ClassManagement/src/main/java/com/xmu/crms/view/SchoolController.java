package com.xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.School;

@RestController
@RequestMapping("/school")
public class SchoolController {

	    @GetMapping("/province")
	    public Object selectAllProvinces() {

	    	return new String[]{"北京", "上海", "广东", "深圳"};

	    }

	    @GetMapping("/city")
	    public Object selectCities() {
	    	
	        return new String[]{"南宁", "柳州", "北海", "桂林", "阳朔"};

	    }

	    public String selectAllCitiesByProvince() {

	        return "";

	    }

	    @GetMapping
	    public Object selectSchools() {
	        return new School[]{

	                new School(12, "厦门大学", "福建", "厦门"),

	                new School(23, "中山大学", "广东", "广州")
	        };

	    }

	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Object createSchool() {

	        return null;

	    }
	
}
