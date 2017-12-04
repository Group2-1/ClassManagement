package com.xmu.crms.service;

import java.util.ArrayList;
import java.util.List;

import com.xmu.crms.entity.Topic;

/**
 * Topic service api
 * @author qinlingyun
 *
 */
public interface TopicService {

	List<Topic> topicForm = new ArrayList<Topic>();
	
	TopicService getTopicById(Integer topicId);
	
	

}
