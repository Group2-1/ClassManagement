package xmu.crms.demo.controller.vo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author lingyun
 *
 */
public class SeminarVO {

    private Long id;
    
    private String name;
    
    private String description;
    
    private String groupingMethod;
    
    private Date startTime;
    
    private Date endTime;
    
    private List<SeminarTopicVO> topics;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupingMethod() {
		return groupingMethod;
	}

	public void setGroupingMethod(String groupingMethod) {
		this.groupingMethod = groupingMethod;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<SeminarTopicVO> getTopics() {
		return topics;
	}

	public void setTopics(List<SeminarTopicVO> topics) {
		this.topics = topics;
	}

	public SeminarVO() {
		super();
	}

	@Override
	public String toString() {
		return "SeminarVO [id=" + id + ", name=" + name + ", description=" + description + ", groupingMethod="
				+ groupingMethod + ", startTime=" + startTime + ", endTime=" + endTime + ", topics=" + topics + "]";
	}

}
