package xmu.crms.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.demo.entity.School;
import xmu.crms.demo.service.SchoolService;
/**
 * 
 * @author lingyun
 *
 */

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	
	private SchoolService schoolService;
    	
        @PostMapping
        public School addSchool(@RequestBody School newSchool) {
            
            BigInteger id = schoolService.insertSchool(newSchool);
            newSchool.setId(id);
            //response.setStatus(204);
            return newSchool;
        }

      /*  @GetMapping("school/province")
	    public List<String> getAllProvinces() {

        	return schoolService.listProvince();
	    	
	    }*/

	   /* @GetMapping("/school/city")
	    public List<String> getCities(@RequestParam(value="province") String province) {
	    	
	    	/*List<String> cities = schoolService.listCity(province);
	    	//return cities;
	    	List<String> cities = new ArrayList<>();
	    	cities.add("南宁");
	    	cities.add("柳州");
	    	cities.add("白色");
	    	cities.add("桂林");
	    	
	    	System.out.println(province.length());
	    	System.out.println(province.getBytes());
	    	if(province=="广西"){
	    		System.out.println("yes");
	    		System.out.println(province);
	    		return null;}
	    	else
	    		return cities;
	    }*/
        
        @GetMapping("/city")
        public List<School> listSchoolByCity(String city){
        	
        	return schoolService.listSchoolByCity(city);
        	
        };
	
}

