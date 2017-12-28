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
import com.xmu.crms.view.vo.SchoolVO;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	
    	@GetMapping
    	public List<SchoolVO> selectSchools() {
    		List<SchoolVO> schools = new ArrayList<>();
    		/*School school1 = new School(12, "厦门大学", "福建", "厦门");
    		School school2 = new School(23, "中山大学", "广东", "广州");
    		schools.add(school1);
    		schools.add(school2);*/
    		return schools;

    	}
    	
        @PostMapping
        public SchoolVO addSchool(@RequestBody School newSchool, HttpServletResponse response) {
            SchoolVO school = new SchoolVO();
            /*school.setId(11);
            response.setStatus(201);*/
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
	    	
	    }

	    @GetMapping("/city")
	    public List<String> getCities() {
	    	
	    	List<String> cities = new ArrayList<>();
	    	cities.add("南宁");
	    	cities.add("柳州");
	    	cities.add("北海");
	    	cities.add("桂林");	    	
	    	return cities;

	    }
	
}
