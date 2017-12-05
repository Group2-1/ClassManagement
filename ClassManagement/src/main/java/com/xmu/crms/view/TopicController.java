package com.xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Topic;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	@GetMapping("/{topicId}")
	public Object selectTopic(@PathVariable("topicId") int topicId) {

	return new Topic(257, "概要设计", "领域模型与模块划分", 5, 2);

	}

	@PutMapping("/{topicId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Object updateTopic(@PathVariable("topicId") int topicId) {

	    return null;

	}

	@DeleteMapping("/{topicId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Object deleteTopic(@PathVariable("topicId") int topicId) {

	   return null;

	}

	@GetMapping("/{topicId}/group")
	public Object selectGroupsForTopic(@PathVariable("topicId") int topicId) {

		class Tmp{
	
			public Integer id;
	
		    public String name;
	
		    public Tmp(Integer id, String name) {
	
		    	this.id = id;
	
		    	this.name = name;
	
		    }
	    
		}

		return new Tmp[]{

				new Tmp(11,"1A1"), new Tmp(12,"1A2")

	        };

	    }
	    
	}

