package xmu.crms.demo.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.demo.dao.ClassDao;
import xmu.crms.demo.entity.ClassInfo;
import xmu.crms.demo.entity.Location;
import xmu.crms.demo.exception.ClassesNotFoundException;
import xmu.crms.demo.exception.CourseNotFoundException;
import xmu.crms.demo.exception.InvalidOperationException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.exception.UserNotFoundException;
import xmu.crms.demo.service.ClassService;
import xmu.crms.demo.service.CourseService;
import xmu.crms.demo.service.FixGroupService;

/**
 *
 * @author hxr
 * @date 2017/12/24
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;


    @Autowired
    private CourseService courseService;
    @Autowired
    private FixGroupService fixGroupService;

    @Override
    public void deleteClassSelectionByClassId(BigInteger classId) {
        classDao.deleteClassSelectionByClassId(classId);
    }

    @Override
    public List<ClassInfo> listClassByName(String courseName, String teacherName) throws UserNotFoundException, CourseNotFoundException,ClassesNotFoundException {
        List<ClassInfo> classes = new ArrayList<>();
        if(courseName == null){
            classes = courseService.listClassByTeacherName(teacherName);
        }else if(teacherName == null){
            classes = courseService.listClassByCourseName(courseName);
        }else{
            classes= classDao.listClassByName(courseName,teacherName);
        }

        return classes;
    }

    @Override
    public List<ClassInfo> listClassByCourseId(BigInteger courseId) throws CourseNotFoundException {
        List<ClassInfo> classes = new ArrayList<>();
        classes = classDao.findClassByCourseId(courseId);
        return classes;
    }

    @Override
    public ClassInfo getClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classInfo = classDao.findClassByClassId(classId);
        return classInfo;
    }

    @Override
    public void updateClassByClassId(BigInteger classId, ClassInfo newClass) throws ClassesNotFoundException {
        classDao.updateClassByClassId(classId,newClass);
    }

    @Override
    public void deleteClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        classDao.deleteCoueseSelectionByClassId(classId);
        fixGroupService.deleteFixGroupByClassId(classId);
        classDao.deleteClassByClassId(classId);
    }

    @Override
    public BigInteger insertCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {
        BigInteger b = classDao.insertCourseSelectionById(userId,classId);
        return b;
    }

    @Override
    public void deleteCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {
        classDao.deleteCourseSelectionById(userId,classId);
    }

    @Override
    public Location getCallStatusById(BigInteger classId, BigInteger seminarId) throws SeminarNotFoundException {
        Location location = classDao.getCallStatusById(classId,seminarId);
        return location;
    }


    @Override
    public BigInteger insertClassById(BigInteger courseId, ClassInfo classInfo) throws CourseNotFoundException {
        BigInteger b = classDao.insertClassById(courseId,classInfo);
        return b;
    }

    @Override
    public void deleteClassByCourseId(BigInteger courseId) throws CourseNotFoundException,ClassesNotFoundException,IllegalArgumentException{
        List<ClassInfo> classes = this.listClassByCourseId(courseId);
        for (int i = 0; i < classes.size(); i++) {
            this.deleteClassSelectionByClassId(classes.get(i).getId());
            fixGroupService.deleteFixGroupByClassId(classes.get(i).getId());
        }
        classDao.deleteClassByCourseId(courseId);
        return ;
    }

    @Override
    public void deleteScoreRuleById(BigInteger classId) throws ClassesNotFoundException {
        classDao.deleteScoreRuleById(classId);
        return ;
    }

    @Override
    public ClassInfo getScoreRule(BigInteger classId) throws ClassesNotFoundException {
        return classDao.getScoreRule(classId);
    }

    @Override
    public BigInteger insertScoreRule(BigInteger classId, ClassInfo proportions) throws InvalidOperationException, ClassesNotFoundException {
        return classDao.insertScoreRule(classId,proportions);
    }

    @Override
    public void updateScoreRule(BigInteger classId, ClassInfo proportions) throws InvalidOperationException, ClassesNotFoundException {
        classDao.insertScoreRule(classId,proportions);
    }

    @Override
    public BigInteger callInRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {
        return classDao.callInRollById(location);
    }

    @Override
    public List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, ClassesNotFoundException {
        return classDao.listClassByUserId(userId);
    }

    @Override
    public void endCallRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {
        classDao.endCallRollById(location);
        return ;
    }
}
