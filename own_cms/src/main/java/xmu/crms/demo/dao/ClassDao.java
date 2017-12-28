package xmu.crms.demo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.crms.demo.entity.ClassInfo;
import xmu.crms.demo.entity.Course;
import xmu.crms.demo.entity.CourseSelection;
import xmu.crms.demo.entity.Location;
import xmu.crms.demo.entity.Seminar;
import xmu.crms.demo.entity.User;
import xmu.crms.demo.exception.ClassesNotFoundException;
import xmu.crms.demo.exception.CourseNotFoundException;
import xmu.crms.demo.exception.InvalidOperationException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.exception.UserNotFoundException;
import xmu.crms.demo.mapper.ClassMapper;
/**
 *
 * @author hxr
 * @date 2017/12/24
 */
@Component
public class ClassDao {

    @Autowired
    private ClassMapper classMapper;


    public List<ClassInfo> listClassByName(String courseName, String teacherName) throws UserNotFoundException, CourseNotFoundException,ClassesNotFoundException {
        List<ClassInfo> classes;
        User teacher = classMapper.findTeacherIdByteacherName(teacherName);
        if(teacher == null){
            throw new UserNotFoundException("can not find the teacher!");
        }else{
            BigInteger teacherId = teacher.getId();
            Course course = classMapper.findCourseIdByteacherIdAndCourseName(teacherId,courseName);
            if(course == null){
                throw new CourseNotFoundException("can not find the course!");
            }else{
                BigInteger courseId = course.getId();
                classes = classMapper.findClassByCourseId(courseId);
                if(classes == null){
                    throw new ClassesNotFoundException("can not find the class!");
                }else{
                    return classes;
                }
            }
        }

    }


    public Boolean deleteClassSelectionByClassId(BigInteger classId) {
        return classMapper.deleteClassSelectionByClassId(classId);
    }


    public List<ClassInfo> findClassByCourseId(BigInteger courseId) throws CourseNotFoundException {
        List<ClassInfo> classes;
        classes = classMapper.findClassByCourseId(courseId);
        if(classes == null) {
            throw new CourseNotFoundException("can not find the course!");
        }
        return classes;
    }


    public ClassInfo findClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classes;
        classes = classMapper.findClassByClassId(classId);
        if(classes == null) {
            throw new ClassesNotFoundException("can not find the class!");
        }
        return classes;
    }


    public Boolean updateClassByClassId(BigInteger classId, ClassInfo newClass) throws ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }
        newClass.setId(classId);
        return classMapper.updateClassByClassId(newClass);

    }


    public Boolean deleteClassByClassId(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }else{
            return classMapper.deleteClassByClassId(classId);
        }
    }


    public BigInteger insertCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {
        User student = classMapper.findStudentdByStudentId(userId);
        if(student == null){
            throw new UserNotFoundException("can not find the student!");
        }else {
            ClassInfo classInfo = classMapper.findClassByClassId(classId);
            if(classInfo == null){
                throw new ClassesNotFoundException("can not find the class!");
            }else{
                CourseSelection courseSelection = new CourseSelection();
                ClassInfo classInfo1 = new ClassInfo();
                classInfo1.setId(classId);
                courseSelection.setClassInfo(classInfo1);
                User student1 = new User();
                student1.setId(userId);
                courseSelection.setStudent(student1);
                Integer b = classMapper.insertCourseSelectionById(courseSelection);
                if (b > 0)
                {
                    return courseSelection.getId();
                }else {
                    return BigInteger.valueOf(-1);
                }
            }
        }
    }


    public Boolean deleteCourseSelectionById(BigInteger userId, BigInteger classId) throws UserNotFoundException, ClassesNotFoundException {
        User student = classMapper.findStudentdByStudentId(userId);
        if(student == null){
            throw new UserNotFoundException("can not find the student!");
        }else {
            ClassInfo classInfo = classMapper.findClassByClassId(classId);
            if(classInfo == null){
                throw new ClassesNotFoundException("can not find the class!");
            }else{
                return classMapper.deleteCourseSelectionById(userId,classId);
            }
        }

    }


    public BigInteger findCourseIdByUserIdAndClassId(BigInteger userId, BigInteger classId) {
        return classMapper.findCourseIdByUserIdAndClassId(userId,classId);
    }


    public Location getCallStatusById(BigInteger classId, BigInteger seminarId) throws SeminarNotFoundException {
        Seminar seminar = classMapper.findSeminarById(seminarId);
        if(seminar == null){
            throw new SeminarNotFoundException("can not find the seminar!");
        }else{
            return classMapper.getCallStatusById(classId,seminarId);
        }
    }



    public BigInteger insertClassById(BigInteger courseId, ClassInfo classInfo) throws CourseNotFoundException {
        Course course = classMapper.findCourseByCourseId(courseId);
        if(course == null){
            throw new CourseNotFoundException("can not find the course!");
        }else{
            Integer b = classMapper.insertClassById(classInfo);
            if (b > 0)
            {
                return classInfo.getId();
            }else {
                return BigInteger.valueOf(-1);
            }
        }


    }


    public void deleteClassByCourseId(BigInteger courseId) throws CourseNotFoundException {
        Course course = classMapper.findCourseByCourseId(courseId);
        if(course == null){
            throw new CourseNotFoundException("can not find the course!");
        }else {
            classMapper.deleteClassByCourseId(courseId);
        }
    }



    public void deleteScoreRuleById(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }else{
            classMapper.deleteScoreRuleById(classId);
        }
    }


    public ClassInfo getScoreRule(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }else {
            classInfo = classMapper.getScoreRule(classId);
            return classInfo;
        }
    }


    public BigInteger insertScoreRule(BigInteger classId, ClassInfo proportions) throws InvalidOperationException, ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }else{
            if(proportions.getReportPercentage()+proportions.getPresentationPercentage()!=100||proportions.getFivePointPercentage()+proportions.getFourPointPercentage()+proportions.getThreePointPercentage()!=100){
                throw new InvalidOperationException("invalid opetation!");
            }else{
                proportions.setId(classId);
                Integer b = classMapper.insertScoreRule(proportions);
                if (b > 0)
                {
                    return proportions.getId();
                }else {
                    return BigInteger.valueOf(-1);
                }
            }
        }
    }



    public BigInteger callInRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {
       ClassInfo classInfo = classMapper.findClassByClassId(location.getClassInfo().getId());
       if(classInfo == null){
           throw new ClassesNotFoundException("can not find the class!");
       }else {
           Seminar seminar = classMapper.findSeminarById(location.getSeminar().getId());
           if(seminar == null){
               throw new SeminarNotFoundException("can not find the seminar!");
           }else{
               Integer b =  classMapper.callInRollById(location);
               if (b > 0)
               {
                   return location.getId();
               }else {
                   return BigInteger.valueOf(-1);
               }
           }
       }
    }


    public List<ClassInfo> listClassByUserId(BigInteger userId) throws IllegalArgumentException, ClassesNotFoundException {
        int a = userId.intValue();
        if(a<=0){
            throw new IllegalArgumentException();
        }else {
            List<CourseSelection> list= classMapper.findClassByUserId(userId);
            if(list == null){
                throw new ClassesNotFoundException("can not find the class!");
            }else {
                List<ClassInfo> classes = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    classes.add(classMapper.findClassByClassId(list.get(i).getClassInfo().getId()));
                }
                return classes;
            }
        }

    }


    public void endCallRollById(Location location) throws SeminarNotFoundException, ClassesNotFoundException {
        Seminar seminar = classMapper.findSeminarById(location.getSeminar().getId());
        if(seminar == null){
            throw new SeminarNotFoundException("can not find the seminar!");
        }else{
            ClassInfo classInfo = classMapper.findClassByClassId(location.getClassInfo().getId());
            if(classInfo == null){
                throw new ClassesNotFoundException("can not find the class!");
            }else{
                classMapper.endCallRollById(location);
            }
        }
    }



    public void deleteCoueseSelectionByClassId(BigInteger classId) throws ClassesNotFoundException {
        ClassInfo classInfo = classMapper.findClassByClassId(classId);
        if(classInfo == null){
            throw new ClassesNotFoundException("can not find the class!");
        }else{
            classMapper.deleteCoueseSelectionByClassId(classId);
        }

    }
}
