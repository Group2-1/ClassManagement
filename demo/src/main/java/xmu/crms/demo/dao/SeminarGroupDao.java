package xmu.crms.demo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.crms.demo.entity.SeminarGroup;
import xmu.crms.demo.entity.SeminarGroupMember;
import xmu.crms.demo.entity.SeminarGroupTopic;
import xmu.crms.demo.entity.Topic;
import xmu.crms.demo.exception.GroupNotFoundException;
import xmu.crms.demo.exception.InvalidOperationException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.exception.UserNotFoundException;
import xmu.crms.demo.mapper.SeminarGroupMapper;
import xmu.crms.demo.mapper.SeminarGroupMemberMapper;
import xmu.crms.demo.mapper.SeminarGroupTopicMapper;

/**
 * @author badcode Huhui
 */
@Component
public class SeminarGroupDao {
    @Autowired
    private SeminarGroupMapper seminarGroupMapper;
    @Autowired
    private SeminarGroupMemberMapper seminarGroupMemberMapper;
    @Autowired
    private SeminarGroupTopicMapper seminarGroupTopicMapper;

    public void deleteSeminarGroupMemberBySeminarGroupId(BigInteger seminarGroupId) {
        seminarGroupMemberMapper.deleteSeminarGroupMemberBySeminarGroupId(seminarGroupId);
    }

    public BigInteger insertSeminarGroupMemberById(BigInteger userId, BigInteger groupId) {
        BigInteger id = null;
        int res = seminarGroupMemberMapper.insertSeminarGroupMemberById(id, userId, groupId);
        if (res > 0) {
            return id;
        } else {
            return new BigInteger("-1");
        }
    }

    public List<SeminarGroupMember> listSeminarGroupMemberByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        List<SeminarGroupMember> list = seminarGroupMemberMapper.listSeminarGroupMemberByGroupId(groupId);
        if (list == null) {
            throw new GroupNotFoundException("can not find the group!");
        } else {
            return list;
        }
    }


    public List<SeminarGroup> listSeminarGroupIdByStudentId(BigInteger userId) throws IllegalArgumentException {
        List<SeminarGroupMember> list = seminarGroupMemberMapper.listSeminarGroupIdByStudentId(userId);

        List<SeminarGroup> groupList = new ArrayList<SeminarGroup>();
        for (SeminarGroupMember s : list) {
            SeminarGroup group = s.getSeminarGroup();
            groupList.add(group);
        }
        return groupList;
    }

    public BigInteger getSeminarGroupLeaderByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        BigInteger leaderId = seminarGroupMapper.getSeminarGroupLeaderByGroupId(groupId);
        return leaderId;
    }

    public List<SeminarGroup> listSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException, SeminarNotFoundException {
        List<SeminarGroup> list = seminarGroupMapper.listSeminarGroupBySeminarId(seminarId);
        if (list == null) {
            throw new SeminarNotFoundException("can not find the seminar!");
        } else {
            return list;
        }
    }

    public void deleteSeminarGroupBySeminarId(BigInteger seminarId) throws IllegalArgumentException {
        seminarGroupMapper.deleteSeminarGroupBySeminarId(seminarId);
    }

    public BigInteger insertSeminarGroupBySeminarId(BigInteger seminarId, BigInteger classId, SeminarGroup seminarGroup) throws IllegalArgumentException {
        int res = seminarGroupMapper.insertSeminarGroupBySeminarId(seminarId, classId, seminarGroup);
        if (res > 0) {
            return seminarGroup.getId();
        } else {
            return new BigInteger("-1");
        }
    }

    public BigInteger insertSeminarGroupMemberByGroupId(BigInteger groupId, SeminarGroupMember seminarGroupMember) {

        int res = seminarGroupMemberMapper.insertSeminarGroupMemberByGroupId(groupId, seminarGroupMember);
        if (res > 0) {
            return seminarGroupMember.getId();
        } else {
            return new BigInteger("-1");
        }
    }

    public void deleteSeminarGroupByGroupId(BigInteger seminarGroupId) throws IllegalArgumentException {
        seminarGroupMapper.deleteSeminarGroupByGroupId(seminarGroupId);
    }

    public SeminarGroup getSeminarGroupByGroupId(BigInteger groupId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroup seminarGroup = seminarGroupMapper.selectSeminarGroupByGroupId(groupId);
        if (seminarGroup == null) {
            throw new GroupNotFoundException("can not find the group!");
        } else {
            return seminarGroup;
        }
    }


    public SeminarGroup getSeminarGroupById(BigInteger seminarId, BigInteger userId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroup seminarGroup = seminarGroupMapper.getSeminarGroupById(seminarId, userId);
        return seminarGroup;
    }

    public List<SeminarGroup> listGroupByTopicId(BigInteger topicId) throws IllegalArgumentException {
        List<SeminarGroup> list = seminarGroupMapper.selectSeminarGroupByTopicId(topicId);
        return list;
    }

    public BigInteger insertTopicByGroupId(BigInteger groupId, BigInteger topicId) throws IllegalArgumentException, GroupNotFoundException {
        SeminarGroupTopic seminarGroupTopic = new SeminarGroupTopic();
        Topic topic = new Topic();
        topic.setId(topicId);
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setId(groupId);
        seminarGroupTopic.setTopic(topic);
        seminarGroupTopic.setSeminarGroup(seminarGroup);
        int res = seminarGroupTopicMapper.insertTopicByGroupId(seminarGroupTopic);
        if (res > 0) {
            return seminarGroupTopic.getId();
        } else {
            return new BigInteger("-1");
        }
    }

    public void updateSeminarGroupById(BigInteger groupId, BigInteger userId) throws IllegalArgumentException, UserNotFoundException, GroupNotFoundException, InvalidOperationException {
        seminarGroupMapper.updateSeminarGroupById(groupId, userId);
    }

    public void resignLeaderById(BigInteger groupId, BigInteger userId) throws IllegalArgumentException, UserNotFoundException, GroupNotFoundException, InvalidOperationException {
        seminarGroupMapper.resignLeaderById( groupId,  userId);
    }

    public List<SeminarGroup> listSeminarGroupNotHaveTopic(BigInteger seminarId) {
        List<SeminarGroup> list=seminarGroupMapper.selectSeminarGroupNotHaveTopic(seminarId);
        return list;
    }

    public void deleteSeminarGroupMemberById(BigInteger seminarGroupId, BigInteger userId) {
        seminarGroupMemberMapper.deleteSeminarGroupMemberById(seminarGroupId,userId);
    }


}
