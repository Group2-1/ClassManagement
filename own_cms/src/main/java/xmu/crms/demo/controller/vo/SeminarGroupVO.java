package xmu.crms.demo.controller.vo;
/**
 * 
 * @author lingyun
 *
 */
public class SeminarGroupVO {

	    private Long id;
	    
	    private String name;
	    
	    private Long topicId;
	    
	    private String topicName;

	    public SeminarGroupVO() {
			super();
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

	    public Long getTopicId() {
	        return topicId;
	    }

	    public void setTopicId(Long topicId) {
	        this.topicId = topicId;
	    }

	    public String getTopicName() {
	        return topicName;
	    }

	    public void setTopicName(String topicName) {
	        this.topicName = topicName;
	    }

		@Override
		public String toString() {
			return "SeminarGroupVO [id=" + id + ", name=" + name + ", topicId=" + topicId + ", topicName=" + topicName
					+ "]";
		}
	    
}
