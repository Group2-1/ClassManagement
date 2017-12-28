package xmu.crms.demo.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xmu.crms.demo.controller.vo.AttendanceStatusVO;
import xmu.crms.demo.controller.vo.SeminarGroupDetail;
import xmu.crms.demo.controller.vo.SeminarGroupVO;
import xmu.crms.demo.controller.vo.SeminarProportions;
import xmu.crms.demo.controller.vo.SeminarTopicVO;
import xmu.crms.demo.controller.vo.SeminarVO;
import xmu.crms.demo.controller.vo.SiteVO;
import xmu.crms.demo.controller.vo.StudentSeminar;
import xmu.crms.demo.controller.vo.TopicVO;
import xmu.crms.demo.controller.vo.UserIdName;
import xmu.crms.demo.entity.Attendance;
import xmu.crms.demo.entity.ClassInfo;
import xmu.crms.demo.entity.Course;
import xmu.crms.demo.entity.Location;
import xmu.crms.demo.entity.Seminar;
import xmu.crms.demo.entity.SeminarGroup;
import xmu.crms.demo.entity.SeminarGroupTopic;
import xmu.crms.demo.entity.Topic;
import xmu.crms.demo.entity.User;
import xmu.crms.demo.exception.ClassesNotFoundException;
import xmu.crms.demo.exception.CourseNotFoundException;
import xmu.crms.demo.exception.GroupNotFoundException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.exception.UserNotFoundException;
import xmu.crms.demo.service.ClassService;
import xmu.crms.demo.service.CourseService;
import xmu.crms.demo.service.SeminarGroupService;
import xmu.crms.demo.service.SeminarService;
import xmu.crms.demo.service.TopicService;
import xmu.crms.demo.service.UserService;
/**
 * 
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/seminar")
public class SeminarController {
	   
		@Autowired
	    private SeminarService seminarService;
		
		@Autowired
	    private TopicService topicService;
		
		@Autowired
		private CourseService courseService;

		@Autowired
		private ClassService classService;

		@Autowired
		private SeminarGroupService seminarGroupService;
		
		@Autowired
		private UserService userService;

		//按ID获取讨论课
	    @GetMapping("/{seminarId}")
	    @ResponseStatus(HttpStatus.OK)
	    public SeminarVO getSeminarInfo(@PathVariable("seminarId") String seminarId) 
	    		throws SeminarNotFoundException {
	    	 	
	        SeminarVO seminarVO=new SeminarVO();
	        Seminar seminar = seminarService.getSeminarBySeminarId(new BigInteger(seminarId));
	        seminarVO.setId(seminar.getId().longValue());
	        seminarVO.setName(seminar.getName());
	        seminarVO.setDescription(seminar.getDescription());
	        seminarVO.setGroupingMethod(seminar.getFixed()?"fixed":"random");

	        List<SeminarTopicVO> topicVOs = new ArrayList<>();
	        List<Topic> topics = topicService.listTopicBySeminarId(new BigInteger(seminarId));
	        for (Topic topic:topics
	                ) {
	            SeminarTopicVO topicVO=new SeminarTopicVO();
	            topicVO.setId(topic.getId().longValue());
	            topicVO.setName(topic.getName());
	            topicVOs.add(topicVO);
	        }
	        seminarVO.setTopics(topicVOs);
	        return seminarVO;
	    }
	        /*
	    	System.out.println(seminarId);
	    	SeminarVO seminarVO=new SeminarVO();
	    	seminarVO.setId(new Long(seminarId));
	    	seminarVO.setName("概要设计");
	    	seminarVO.setDescription("xxxxx");
	    	seminarVO.setGroupingMethod("random");
	        seminarVO.setStartTime(new Date(2017-3-15));
	        seminarVO.setEndTime(new Date(2017-3-15));

	        List<SeminarTopicVO> topics = new ArrayList<>();
	        SeminarTopicVO topic1 = new SeminarTopicVO();
	        topic1.setId(12L);
	        topic1.setName("topic 1");
	        SeminarTopicVO topic2 = new SeminarTopicVO();
	        topic2.setId(21L);
	        topic2.setName("topic 2");
	        topics.add(topic1);
	        topics.add(topic2);
	        
	        seminarVO.setTopics(topics);*/

	    //按ID修改讨论课
	    @PutMapping("/{seminarId}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void updateSeminar(@PathVariable("seminarId") String seminarId, @RequestBody SeminarProportions seminarProportion)
	            throws SeminarNotFoundException {
	        Seminar seminar=new Seminar();
	        seminar.setId(new BigInteger(seminarId));
	        seminar.setName(seminarProportion.getName());
	        seminar.setDescription(seminarProportion.getDescription());
	        seminar.setFixed(seminarProportion.getGroupingMethod()=="fixed"?true:false);
	        seminar.setStartTime(seminarProportion.getStartTime());
	        seminar.setEndTime(seminarProportion.getEndTime());
	        seminarService.updateSeminarBySeminarId(new BigInteger(seminarId), seminar);
	    }
	    
	    //按ID删除讨论课
	    @DeleteMapping("/{seminarId}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteSeminar(@PathVariable("seminarId") String seminarId) 
	    		throws SeminarNotFoundException {
	    	
	        seminarService.deleteSeminarBySeminarId(new BigInteger(seminarId));
	    }
	    
	    //按ID获取和学生有关的讨论课信息
	    @GetMapping("/{seminarId}/my")
	    @ResponseStatus(HttpStatus.OK)
	    public StudentSeminar getRelatedSeminar(@PathVariable("seminarId") Long seminarId)
	            throws SeminarNotFoundException, CourseNotFoundException, ClassNotFoundException, GroupNotFoundException {

	        StudentSeminar studentSeminar = new StudentSeminar();
	        Seminar seminar = seminarService.getSeminarBySeminarId(BigInteger.valueOf(seminarId));
	        studentSeminar.setId(seminar.getId().longValue());
	        studentSeminar.setName(seminar.getName());
	        
	        if (seminar.getFixed() == true) {
	            studentSeminar.setGroupingMethod("fixed");
	        } else {
	            studentSeminar.setGroupingMethod("random");
	        }

	        Course course = courseService.getCourseByCourseId(seminar.getCourse().getId());
	        studentSeminar.setCourseName(course.getName());
	        studentSeminar.setStartTime(seminar.getStartTime());
	        studentSeminar.setEndTime(seminar.getEndTime());
	        BigInteger userId = BigInteger.valueOf(1);
	        BigInteger classId = BigInteger.valueOf(-1);
	        List<ClassInfo> classInfos = null;
			try {
				classInfos = classService.listClassByUserId(userId);
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (ClassesNotFoundException e) {

				e.printStackTrace();
			}
	        for (ClassInfo classInfo : classInfos
	                ) {
	            if (classInfo.getCourse().getId().equals(course.getId())) {
	                classId = classInfo.getId();
	                studentSeminar.setClassCalling(classId.intValue());
	                break;
	            }
	        }

	        BigInteger leaderId = seminarGroupService.getSeminarGroupLeaderById(userId, BigInteger.valueOf(seminarId));
	        if (userId.equals(leaderId)) {
	            studentSeminar.setIsLeader(true);
	        } else {
	            studentSeminar.setIsLeader(false);
	        }
	        List<Topic> topics = topicService.listTopicBySeminarId(BigInteger.valueOf(seminarId));
	        SeminarGroup seminarGroup = seminarGroupService.getSeminarGroupById(BigInteger.valueOf(seminarId), userId);
	        BigInteger grouopId = seminarGroup.getId();
	        Boolean areTopicsSelected=false;
	        for (Topic topic : topics
	                ) {
	            SeminarGroupTopic seminarGroupTopic = topicService.getSeminarGroupTopicById(topic.getId(),grouopId);
	            if(seminarGroupTopic!=null){
	                areTopicsSelected=true;
	                break;
	            }
	        }
	        studentSeminar.setAreTopicSeleted(areTopicsSelected);

	        return studentSeminar;
	    }

	       
	    //按ID获取讨论课的话题
	    @GetMapping("/{seminarId}/topic")
	    @ResponseStatus(HttpStatus.OK)
	    public List<TopicVO> getTopics(@PathVariable("seminarId") String seminarId) 
	    		throws IllegalArgumentException {
	        List<TopicVO> topicVOS=new ArrayList<>();
	        List<Topic> topics=topicService.listTopicBySeminarId(new BigInteger(seminarId));
	        for (Topic topic:topics
	             ) {
	            TopicVO topicVO=new TopicVO();
	            topicVO.setId(topic.getId());
	            topicVO.setSerial(topic.getSerial());
	            topicVO.setName(topic.getName());
	            topicVO.setDescription(topic.getDescription());
	            topicVO.setGroupLimit(topic.getGroupNumberLimit());
	            topicVO.setGroupMemberLimit(topic.getGroupStudentLimit());

	            topicVOS.add(topicVO);
	        }
	        return topicVOS;
	    }
	    
	    //在指定讨论课下创建话题	    
	    @PostMapping("/{seminarId}/topic")
	    @ResponseStatus(HttpStatus.CREATED)
	    public Topic addTopic(@PathVariable("seminarId") String seminarId, @RequestBody TopicVO topicVO) {
	        Topic topic=new Topic();
	        topic.setSerial(topicVO.getSerial());
	        topic.setName(topicVO.getSerial());
	        topic.setDescription(topicVO.getDescription());
	        topic.setGroupNumberLimit(topicVO.getGroupLimit());
	        topic.setGroupStudentLimit(topicVO.getGroupLimit());
	        BigInteger id = topicService.insertTopicBySeminarId(new BigInteger(seminarId), topic);
	        Topic newTopic = new Topic();
	        newTopic.setId(id);
	        return newTopic;
	    }
	    
	    //按讨论课ID查找小组
	    @GetMapping("/{seminarId}/group")
	    @ResponseStatus(HttpStatus.OK)
	    public List<SeminarGroupVO> getSeminarGroups(@PathVariable("seminarId") String seminarId) 
	    		throws SeminarNotFoundException {

	        List<SeminarGroupVO> seminarGroupVOS = new ArrayList<>();
	        List<SeminarGroup> seminarGroups = seminarGroupService.listSeminarGroupBySeminarId(new BigInteger(seminarId));
	        List<Topic> topics = topicService.listTopicBySeminarId(new BigInteger(seminarId));
	        List<ClassInfo> classInfos = null;
			try {
				classInfos = classService.listClassByCourseId(seminarGroups.get(0).getSeminar().getId());
			} catch (CourseNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        for (ClassInfo classInfo : classInfos
	        		) {
		        for (Topic topic : topics
		                    ) {
		             for (SeminarGroup seminarGroup : seminarGroups
		                        ) {
		                SeminarGroupTopic isChosen = topicService.getSeminarGroupTopicById(topic.getId(), seminarGroup.getId());
		              //未选题 
		                if (isChosen != null) {
		                        SeminarGroupVO seminarGroupVO = new SeminarGroupVO();
		                        seminarGroupVO.setId(isChosen.getId().longValue());
		                        //设置“1A1”
		                        seminarGroupVO.setName(classInfos.indexOf(classInfo) + topics.indexOf(topic) + seminarGroups.indexOf(seminarGroup) + "");
		                        SeminarTopicVO seminarTopicVO = new SeminarTopicVO();
		                        seminarTopicVO.setId(topic.getId().longValue());
		                        seminarTopicVO.setName(topic.getName());
		                        seminarGroupVO.setTopicId(seminarTopicVO.getId());
		                        seminarGroupVO.setTopicName(seminarTopicVO.getName());
		                        seminarGroupVOS.add(seminarGroupVO);
		                    }
		             	}
	        	}
	        }
	        return seminarGroupVOS;
	    }
	    
	    //按讨论课ID获取小组所在讨论课小组信息
	    @GetMapping("/{seminarId}/group/my")
	    @ResponseStatus(HttpStatus.OK)
	    public SeminarGroupDetail getMyGroup(@PathVariable("seminarId") String seminarId) {
	        SeminarGroupDetail seminarGroupDetail=new SeminarGroupDetail();
	        /*************************/
	        BigInteger userId = new BigInteger("8");

	        SeminarGroup seminarGroup = null;
			try {
				seminarGroup = seminarGroupService.getSeminarGroupById(new BigInteger(seminarId), userId);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GroupNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        seminarGroupDetail.setId(seminarGroup.getId());
	        seminarGroupDetail.setName(seminarGroup.getId().toString());
	        BigInteger leaderId = null;
			try {
				leaderId = seminarGroupService.getSeminarGroupLeaderByGroupId(seminarGroup.getId());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GroupNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        User leader = null;
			try {
				leader = userService.getUserByUserId(leaderId);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        UserIdName leaderVO=new UserIdName(leader);
	        seminarGroupDetail.setLeader(leaderVO);

	        List<UserIdName> members=new ArrayList<>();
	        List<User> seminarGroupMembers = null;
	        try {
				seminarGroupMembers = seminarGroupService.listSeminarGroupMemberByGroupId(seminarGroup.getId());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GroupNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        for (User user:seminarGroupMembers
	             ) {
	            UserIdName userIdNameVO=new UserIdName(user);
	            if(!user.getId().equals(leader.getId())){
	                members.add(userIdNameVO);
	            }
	        }
	        seminarGroupDetail.setMembers(members);
	        return seminarGroupDetail;
	    }
 	     /*   group.setId(28L);
 	        group.setName("28");
 	        User leader = new User();
 	        leader.setId(8888L);
 	        leader.setName("张三");
 	        group.setLeader(leader);
 	        List<User> members = new ArrayList<>();
 	        User member1 = new User();
 	        member1.setId(5324L);
 	        member1.setName("李四");
 	        User member2 = new User();
 	        member2.setId(5678L);
 	        member2.setName("王五");
 	        members.add(member1);
 	        members.add(member2);
 	        group.setMembers(members);
 	        List<Topic> topics = new ArrayList<>();
 	        Topic topic = new Topic();
 	        topic.setId(257L);
 	        topic.setName("领域模型与模块");
 	        topics.add(topic);
 	        group.setTopics(topics);*/

	    
	    //按ID获取讨论课班级签到状态、分组状态
	    @GetMapping("/{seminarId}/class/{classId}/attendance")
	    @ResponseStatus(HttpStatus.OK)
	    public AttendanceStatusVO getAttendanceStatus(@PathVariable("seminarId") String seminarId,
	                                                @PathVariable("classId") String classId) {
	    	AttendanceStatusVO attendanceStatus = new AttendanceStatusVO();

	        List<Attendance> attendances = null;
			try {
				attendances = userService.listAttendanceById(new BigInteger(classId),new BigInteger(seminarId));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassesNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        attendanceStatus.setNumPresent(attendances.size());

	        List<User> students = null;
			try {
				students = userService.listUserByClassId(new BigInteger(classId),"","");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassesNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        attendanceStatus.setNumStudent(students.size());

	        Location location = null;
			try {
				location = classService.getCallStatusById(new BigInteger(classId),new BigInteger(seminarId));
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(location.getStatus()==0){
	            attendanceStatus.setStatus("Called");
	            attendanceStatus.setGroup("Grouped");
	        }
	        else{
	            attendanceStatus.setStatus("Calling");
	            attendanceStatus.setGroup("Group");
	        }

	        return attendanceStatus;
	    }
	    //按ID获取讨论课班级已签到名单
	    @GetMapping("seminar/{seminarId}/class/{classId}/attendance/present")
	    @ResponseStatus(HttpStatus.OK)
	    public List<UserIdName> getPresent(@PathVariable("seminarId") String seminarId,
	                                 @PathVariable("classId") String classId) {
	        List<UserIdName> userIdNameVOS=new ArrayList<>();
	        List<User> presents = null;
			try {
				presents = userService.listPresentStudent(new BigInteger(seminarId),new BigInteger(classId));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassesNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        for (User present:presents
	             ) {
	            userIdNameVOS.add(new UserIdName(present));
	        }

	        return userIdNameVOS;
	    }
	       /* List<User> present = new ArrayList<>();
 	        User student1 = new User();
 	        student1.setId(2357L);
 	        student1.setName("张三");
 	        present.add(student1);
 	        User student2 = new User();
 	        student2.setId(8232L);
 	        student2.setName("李四");
 	        present.add(student2);*/
	    
	    
	    //获取迟到名单
	    @GetMapping("/{seminarId}/class/{classId}/attendance/late")
	    @ResponseStatus(HttpStatus.OK)
	    public List<UserIdName> getLate(@PathVariable("seminarId") String seminarId,
	                              @PathVariable("classId") String classId) {
	    	
	        List<UserIdName> lateStudents=new ArrayList<>();
	        List<User> lates = null;
			try {
				lates = userService.listLateStudent(new BigInteger(seminarId),new BigInteger(classId));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassesNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        for (User late:lates
	             ) {
	            lateStudents.add(new UserIdName(late));
	        }
	        return lateStudents;
	    }
	       /* List<User> late = new ArrayList<>();
 	        User student1 = new User();
 	        student1.setId(3412L);
 	        student1.setName("王五");
 	        late.add(student1);
 	        User student2 = new User();
 	        student2.setId(5234L);
 	        student2.setName("王七九");
 	        late.add(student2);*/
	    

	    //签到	    
	    @PutMapping("/{seminarId}/class/{classId}/attendance/{studentId}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public AttendanceStatusVO callInRoll(@PathVariable("seminarId") String seminarId,
	    					 @PathVariable("seminarId") String classId,
	                         @PathVariable("studentId") String studentId,
	                         @RequestBody SiteVO site, HttpServletResponse response) {
	    	AttendanceStatusVO status = new AttendanceStatusVO();
	        Location location = null;
			try {
				location = classService.getCallStatusById(new BigInteger(classId),new BigInteger(seminarId));
			} catch (SeminarNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				userService.insertAttendanceById(new BigInteger(classId),new BigInteger(seminarId),new BigInteger(studentId)
				        ,site.getLongitude(),site.getLatitude());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassesNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(location.getStatus()==1){
	            status.setStatus("ontime");
	        } else {
	            status.setStatus("late");
	        }

	        return status;
	    }	 
	        /*response.setStatus(200);
	        StatusVO status = new StatusVO();
	       status.setStatus("late");
	        return status;*/
	
	    
}
