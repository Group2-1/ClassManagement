package com.xmu.crms.view;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class controller
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController {

		    @GetMapping("")
		    public String a(){
	
		        return "";
	
		    }
	
		    @GetMapping("/{classId}")
	
		    public String selectClass(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @PutMapping("/{classId}")
	
		    public String updateClass(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @DeleteMapping("/{classId}")
	
		    public String deleteClass(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @PostMapping("/{classId}/student")
	
		    public String enroll(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @DeleteMapping("/{classId}/student")
	
		    public String dropClass(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @GetMapping("/{classId}/attendance")
	
		    public String selectAttendance(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @GetMapping("/{classId}/classgroup")
	
		    public String selectClassGroup(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
	
	
		    @PutMapping("/{classId}/classgroup")
	
		    public String updateClassGroup(@PathVariable("classId") int classId) {
	
	
	
		        return "";
	
		    }
	
}

