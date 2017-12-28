package xmu.crms.demo.controller.vo;

import java.math.BigInteger;
import java.util.List;
/**
 * 
 * @author lingyun
 *
 */
public class SeminarGroupDetail {
	
    private BigInteger id;
    
    private String name;
    
    private UserIdName leader;
    
    private List<UserIdName> members;
    
    private List<TopicVO> topics;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserIdName getLeader() {
		return leader;
	}

	public void setLeader(UserIdName leader) {
		this.leader = leader;
	}

	public List<UserIdName> getMembers() {
		return members;
	}

	public void setMembers(List<UserIdName> members) {
		this.members = members;
	}

	public List<TopicVO> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicVO> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "SeminarGroupDetail [id=" + id + ", name=" + name + ", leader=" + leader + ", members=" + members
				+ ", topics=" + topics + "]";
	}
    

}
