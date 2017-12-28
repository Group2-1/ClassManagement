package xmu.crms.demo.controller.vo;

import java.util.List;

public class GroupVO {
	private Long id;
	private String name;
	private MemberVO leader;
	private List<MemberVO> members;
	private List<SeminarTopicVO> topics;
	private String report;

	public GroupVO(MemberVO leader, List<MemberVO> members) {
		this.leader = leader;
		this.members = members;
	}
	
	public GroupVO(Long id, String name, MemberVO leader, List<MemberVO> members, 
			List<SeminarTopicVO> topics, String report)
	{
		super();
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.members = members;
		this.topics = topics;
		this.report = report;
	}

	public GroupVO(Long id, MemberVO leader, List<MemberVO> members, List<SeminarTopicVO> topics, String report) {
		super();
		this.id = id;
		this.leader = leader;
		this.members = members;
		this.topics = topics;
		this.report = report;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public MemberVO getLeader() {
		return leader;
	}

	public void setLeader(MemberVO leader) {
		this.leader = leader;
	}

	public List<MemberVO> getMembers() {
		return members;
	}

	public void setMembers(List<MemberVO> members) {
		this.members = members;
	}

	public List<SeminarTopicVO> getTopics() {
		return topics;
	}

	public void setTopics(List<SeminarTopicVO> topics) {
		this.topics = topics;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "GroupVO [id=" + id + ", name=" + name + ", leader=" + leader + ", members=" + members + ", topics="
				+ topics + ", report=" + report + "]";
	}
}
