package com.xmu.crms.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.entity.Topic;
import com.xmu.crms.view.vo.GroupVO;
import com.xmu.crms.view.vo.TopicVO;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

	@GetMapping("/{topicId}")
	public TopicVO selectTopic(@PathVariable("topicId") int topicId) {

        TopicVO topic = new TopicVO();
        topic.setId(257L);
        topic.setSerial("A");
        topic.setName("领域模型与模块");
        topic.setDescription("Domain model与模块划分");
        topic.setGroupLeft(2);
        topic.setGroupLimit(5);
        topic.setGroupMemberLimit(6);
        return topic;
		/*return new Topic(257, "A", "领域模型与模块", "Domain model与模块划分", 2, 5, 6);
*/
	}

	@PutMapping("/{topicId}")
	public Topic updateTopic(@PathVariable("topicId") int topicId, @RequestBody Topic topic, HttpServletResponse response) {

		response.setStatus(204);
	    return null;

	}

	@DeleteMapping("/{topicId}")
	public Response deleteTopic(@PathVariable("topicId") int topicId, HttpServletResponse response) {

	   response.setStatus(204);
	   return null;

	}

	@GetMapping("/{topicId}/group")
	public List<GroupVO> selectGroupsForTopic(@PathVariable("topicId") int topicId) {

        List<GroupVO> groups = new ArrayList<>();
        /*Group group1 = new Group();
        group1.setId(23);
        group1.setName("1A1");
        groups.add(group1);
        Group group2 = new Group();
        group2.setId(26);
        group2.setName("2A2");
        groups.add(group2);*/
        return groups;
	    
	}

}
