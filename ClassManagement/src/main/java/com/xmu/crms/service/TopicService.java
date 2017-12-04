package com.xmu.crms.service;

/**
 * Topic service api
 * @author qinlingyun
 *
 */
public interface TopicService {

	/*private List<Topic> topicForm = new ArrayList<Topic>();
	
	//默认构造函数中添加部分数据,以供测试
	public TopicService() {
		courses.add(new Course("0","J2EE","邱明","海韵104"));
		courses.add(new Course("1","OOAD","邱明","海韵205"));
		courses.add(new Course("2", "软件工程", "王美红", "海韵208"));
	}*/
	
	TopicService getTopicById(Integer topicId);
	
	

}
