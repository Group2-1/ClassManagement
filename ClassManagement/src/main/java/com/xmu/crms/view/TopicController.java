package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Topic;

/**
 * topic controller
 * @author qinlingyun
 *
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	private List<Topic> topics = new ArrayList<Topic>();
	
	public TopicController(){
		topics.add(new Topic(1,"A","Domain Model","the first test",11,7,3));
		topics.add(new Topic(2,"A","Class Model","the first test",12,5,1));
		topics.add(new Topic(3,"B","UML Diagram","the first test",13,6,0));
		topics.add(new Topic(4,"B","Pattern","the first test",14,7,7));		
	}
		
	public Topic getTopicById(Integer topicId) {
		return topics.get(topicId);
	}
	
	@GetMapping("/{topicId}")
	public String getTopicById(@PathVariable("topicId") Integer topicId, Model model){
		model.addAttribute("topic", this.getTopicById(topicId));
		return "choose_course";
	}
/*
	@PutMapping("/{topicId}")
	public Topic modifyTopicById(@RequestParam("topicId") Integer topicId, Model model){
		
		
	}
	
	@DeleteMapping("/{topicId}")
	public void deleteTopicById(@PathVariable("topicId") Integer topicId, Model model){
		
		
	}
	
	@GetMapping("/{topicId}")
	public String getGroupByTopicId(@PathVariable("topicId") Integer topicId, Model model){
		
		return "topic_home";
	}
*/
}
