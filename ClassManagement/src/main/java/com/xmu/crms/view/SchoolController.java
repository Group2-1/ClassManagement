package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.School;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	
    	@GetMapping
    	public List<School> selectSchools() {
    		List<School> schools = new ArrayList<>();
    		School school1 = new School(12, "厦门大学", "福建", "厦门");
    		School school2 = new School(23, "中山大学", "广东", "广州");
    		schools.add(school1);
    		schools.add(school2);
    		return schools;

    	}
    	
        @PostMapping
        public School addSchool(@RequestBody School newSchool, HttpServletResponse response) {
            School school = new School();
            school.setId(11);
            response.setStatus(201);
            return school;
        }

	    @GetMapping("/province")
	    public List<String> getAllProvinces() {
	    	
	    	List<String> provinces = new ArrayList<>();
	    	provinces.add("北京");
	    	provinces.add("上海");
	    	provinces.add("广东");
	    	provinces.add("深圳");
	    	return provinces;
	    	/*return new String[]{"北京", "上海", "广东", "深圳"};*/
	    }

	    @GetMapping("/city")
	    public List<String> getCities() {
	    	
	    	List<String> cities = new ArrayList<>();
	    	cities.add("南宁");
	    	cities.add("柳州");
	    	cities.add("北海");
	    	cities.add("桂林");	    	
	    	return cities;
	        /*return new String[]{"南宁", "柳州", "北海", "桂林", "阳朔"};*/

	    }
	
}
