package com.xmu.crms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xmu.crms.entity.Topic;
import com.xmu.crms.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	private List<Topic> topics = new ArrayList<Topic>();
	
	public void TopicService(){
		topics.add(new Topic(1,"A","Domain Model","the first test",11,7,3));
		topics.add(new Topic(2,"A","Class Model","the first test",12,5,1));
		topics.add(new Topic(3,"B","UML Diagram","the first test",13,6,0));
		topics.add(new Topic(4,"B","Pattern","the first test",14,7,7));		
	}
	
	@Override	
	public Topic getTopicById(Integer topicId) {
		return topics.get(topicId);
	}

}
