package ControllerTest;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.xmu.crms.entity.Topic;
import com.xmu.crms.view.TopicController;

/**
 * test tpic
 * @author lingyun
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TopicController topicController;
	
/*
		this.mockMvc.perform(get("/topic/{topicId}")).andDo(print()).andExpect(status().isOk())
		.andExpect(view().name("addForm"));*/
	@Test
	public void testGetTopicById() throws Exception {

		given(topicController.getTopicById((int) anyLong())).willReturn(new Topic(null, null, null, null, null, null, null));

		this.mockMvc.perform(get("/topic/2")).andExpect(status().isOk()).andExpect(view().name("choose_course"))
				.andExpect(model().attributeExists("topic")).andDo(print());

	}

}

