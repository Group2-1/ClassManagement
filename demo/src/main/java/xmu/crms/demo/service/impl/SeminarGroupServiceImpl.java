package xmu.crms.demo.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.demo.dao.SeminarGroupDao;
import xmu.crms.demo.entity.Attendance;
import xmu.crms.demo.entity.SeminarGroup;
import xmu.crms.demo.entity.SeminarGroupMember;
import xmu.crms.demo.entity.Topic;
import xmu.crms.demo.entity.User;
import xmu.crms.demo.exception.ClassesNotFoundException;
import xmu.crms.demo.exception.GroupNotFoundException;
import xmu.crms.demo.exception.InvalidOperationException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.exception.UserNotFoundException;
import xmu.crms.demo.service.SeminarGroupService;
import xmu.crms.demo.service.TopicService;
import xmu.crms.demo.service.UserService;

/**
 * @author Huhui
 */
@Service
public class SeminarGroupServiceImpl implements SeminarGroupService {
    @Autowired
    private SeminarGroupDao seminarGroupDao;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;
    @Override
    public void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId) {
        seminarGroupDao.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }

    @Override
    public BigInteger insertSeminarGroupMemberById(BigInteger userId, BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException, UserNotFoundException, InvalidOperationException {
        return seminarGroupDao.insertSeminarGroupMemberById(userId, groupId);
    }

    @Override
    public List<User> listSeminarGroupMemberByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        List<SeminarGroupMember> list = seminarGroupDao.listSeminarGroupMemberByGroupId(groupId);
        List<User> userList = new ArrayList<User>();
        for (SeminarGroupMember s : list) {
            User user = s.getStudent();
            userList.add(user);

        }
        return userList;
    }

    @Override
    public List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId) throws IllegalArgumentException {
        List<SeminarGroup> list = seminarGroupDao.listSeminarGroupIdByStudentId(userId);
        return list;
    }

    @Override
    public BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        BigInteger leaderId = seminarGroupDao.getSeminarGroupLeaderByGroupId(groupId);
        return leaderId;
    }

    @Override
    public List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        List<SeminarGroup> list = seminarGroupDao.listSeminarGroupBySeminarId(seminarId);
        return list;
    }

    @Override
    public void deleteSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        List<SeminarGroup> list = listSeminarGroupBySeminarId(seminarId);
        for (SeminarGroup s : list) {
            deleteSeminarGroupMemberBySeminarGroupId(s.getId());
        }
        seminarGroupDao.deleteSeminarGroupBySeminarId(seminarId);
    }

    @Override
    public BigInteger insertSeminarGroupBySeminarId(BigInteger seminarId, BigInteger classId, SeminarGroup seminarGroup) throws IllegalArgumentException {
        seminarGroupDao.insertSeminarGroupBySeminarId(seminarId, classId, seminarGroup);
        return seminarGroup.getId();
    }

    @Override
    public BigInteger insertSeminarGroupMemberByGroupId(BigInteger groupId, SeminarGroupMember seminarGroupMember) {
        seminarGroupDao.insertSeminarGroupMemberByGroupId(groupId, seminarGroupMember);
        return seminarGroupMember.getId();
    }

    @Override
    public void deleteSeminarGroupByGroupId(BigInteger seminarGroupId) throws IllegalArgumentException {
        deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
        seminarGroupDao.deleteSeminarGroupByGroupId(seminarGroupId);
    }

    @Override
    public SeminarGroup getSeminarGroupByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        return seminarGroup;
    }

    @Override
    public BigInteger getSeminarGroupLeaderById(BigInteger userId, BigInteger seminarId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroup seminarGroup = this.getSeminarGroupById(seminarId, userId);
        if (seminarGroup == null) {
            throw new GroupNotFoundException("can not find th group!");
        } else {
            BigInteger leaderId = getSeminarGroupLeaderByGroupId(seminarGroup.getId());
            return leaderId;
        }

    }
private BigInteger addGroup(User student,BigInteger seminarId,BigInteger classId){
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setLeader(student);
        insertSeminarGroupBySeminarId(seminarId,classId,seminarGroup);
        BigInteger seminarGroupId=seminarGroup.getId();
        return seminarGroupId;
    }
    @Override
    public void automaticallyGrouping(BigInteger seminarId, BigInteger classId) throws IllegalArgumentException, ClassesNotFoundException,
            SeminarNotFoundException, GroupNotFoundException, UserNotFoundException, InvalidOperationException {
       List<Attendance> list= userService.listAttendanceById(classId, seminarId);
       		   //签到的总人数
       		  int num=list.size();
       		//每组人数
              int groupmemberlimit=num/9;
            //不够整除，余下的人
              int left=num-groupmemberlimit*9;
            //数组指针
              int k=0;
              for(int i = 0;i<9;i++){
               if(left!=0){
                   BigInteger seminarGroupId=null;
                   for(int j=0;j<=groupmemberlimit;j++)
                   {
                       User student=list.get(k+j).getStudent();
                       if(j==0) {
                         seminarGroupId=addGroup(student,seminarId,classId);
                       }
                       if(seminarGroupId!=null) {
                           insertSeminarGroupMemberById(student.getId(), seminarGroupId);
                       }
                   }
                   k+=groupmemberlimit+1;
               }
                else{
                   BigInteger seminarGroupId=null;
                   for(int j=0;j<groupmemberlimit;j++)
                   {
                       User student=list.get(k+j).getStudent();
                       if(j==0) {
                           seminarGroupId=addGroup(student,seminarId,classId);
                       }
                       if(seminarGroupId!=null) {
                           insertSeminarGroupMemberById(student.getId(), seminarGroupId);
                       }
                   }
                   k+=groupmemberlimit;

               }
        }


    }

    @Override
    public List<SeminarGroup> listSeminarGroupNotHaveTopic(BigInteger seminarId) {
       List<SeminarGroup> list=seminarGroupDao.listSeminarGroupNotHaveTopic(seminarId);
        return list;
    }

    @Override
    public void automaticallyAllotTopic(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException, GroupNotFoundException {
       List<SeminarGroup> list=this.listSeminarGroupNotHaveTopic(seminarId);
       List<Topic> topics=topicService.listTopicBySeminarId(seminarId);
           for(int j=0;j<list.size();j++){
               for(int i=0;i<topics.size();i++){

                   this.insertTopicByGroupId(list.get(j).getId(),topics.get(i).getId());
                   if(i==topics.size()-1){i=0;}
           }
       }
    }

    @Override
    public SeminarGroup getSeminarGroupById(BigInteger seminarId, BigInteger userId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupById(seminarId, userId);
        return seminarGroup;
    }

    @Override
    public List<SeminarGroup> listGroupByTopicId(BigInteger topicId) throws IllegalArgumentException {
        List<SeminarGroup> list = seminarGroupDao.listGroupByTopicId(topicId);
        return list;
    }

    @Override
    public BigInteger insertTopicByGroupId(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException, GroupNotFoundException {
        BigInteger seminarGroupTopic = seminarGroupDao.insertTopicByGroupId(groupId, topicId);
        return seminarGroupTopic;
    }

    @Override
    public void assignLeaderById(BigInteger groupId, BigInteger userId) throws IllegalArgumentException, UserNotFoundException, GroupNotFoundException, InvalidOperationException {
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        if (seminarGroup == null) {
            throw new GroupNotFoundException("can not find th group!");
        }
        if (seminarGroup.getLeader() != null) {
            throw new InvalidOperationException("invalid operation");
        }
        seminarGroupDao.updateSeminarGroupById(groupId, userId);
    }

    @Override
    public void resignLeaderById(BigInteger groupId, BigInteger userId) throws IllegalArgumentException, GroupNotFoundException, UserNotFoundException, InvalidOperationException {
        SeminarGroup seminarGroup = seminarGroupDao.getSeminarGroupByGroupId(groupId);
        if (seminarGroup == null) {
            throw new GroupNotFoundException("can not find th group!");
        }
        if (seminarGroup.getLeader() == null) {
            throw new InvalidOperationException("invalid operation");
        }
User user=userService.getUserByUserId(userId);
if(user==null){throw new UserNotFoundException("can not find th user!");}
        seminarGroupDao.updateSeminarGroupById(groupId, null);
    }

    @Override
    public void deleteSeminarGroupMemberById(BigInteger seminarGroupId, BigInteger userId) {
        seminarGroupDao.deleteSeminarGroupMemberById(seminarGroupId,userId);
    }

}
