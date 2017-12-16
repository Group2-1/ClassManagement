package com.xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.service.TopicService;

/**
 * topic controller
 * @author qinlingyun
 *
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	@Qualifier("TopicService")
	private TopicService topicService;
	
	@RequestMapping(value="/{topicId}", method = RequestMethod.GET)
	public String getTopicById(@PathVariable("topicId") Integer topicId, Model model){
		model.addAttribute("topic", topicService.getTopicById(topicId));
		return "topic_home";
	}
}
