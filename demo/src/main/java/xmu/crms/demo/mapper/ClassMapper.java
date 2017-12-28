package xmu.crms.demo.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import xmu.crms.demo.entity.ClassInfo;
import xmu.crms.demo.entity.Course;
import xmu.crms.demo.entity.CourseSelection;
import xmu.crms.demo.entity.Location;
import xmu.crms.demo.entity.Seminar;
import xmu.crms.demo.entity.User;
/**
 *
 * @author hxr
 * @date 2017/12/24
 */
@Component
@Mapper
public interface ClassMapper {

    Boolean deleteClassSelectionByClassId(BigInteger classId);

    User findTeacherIdByteacherName(String teacherName);

    Course findCourseIdByteacherIdAndCourseName(@Param("teacherId") BigInteger teacherId, @Param("courseName") String courseName);

    List<ClassInfo> findClassByCourseId(BigInteger courseId);

    ClassInfo findClassByClassId(BigInteger classId);

    Boolean updateClassByClassId(ClassInfo newClass);

    Boolean deleteClassByClassId(BigInteger classId);

    Integer insertCourseSelectionById(CourseSelection courseSelection);

    User findStudentdByStudentId(BigInteger studentId);

    User findTeacherByTeacherId(BigInteger teacherId);

    Course findCourseByCourseId(BigInteger courseId);

    BigInteger findCourseIdByUserIdAndClassId(@Param("userId") BigInteger userId, @Param("classId") BigInteger classId);

    Boolean deleteCourseSelectionById(@Param("userId") BigInteger userId, @Param("classId") BigInteger classId);

    Location getCallStatusById(@Param("classId") BigInteger classId, @Param("seminarId") BigInteger seminarId);

    Seminar findSeminarById(BigInteger semiarId);

    Integer insertClassById(ClassInfo classInfo);

    void deleteClassByCourseId(BigInteger courseId);


    void deleteScoreRuleById(BigInteger classId);

    ClassInfo getScoreRule(BigInteger classId);

    Integer insertScoreRule(ClassInfo classInfo);

    Integer callInRollById(Location location);

    List<CourseSelection> findClassByUserId(BigInteger userId);

    void endCallRollById(Location location);

    void deleteCoueseSelectionByClassId(BigInteger classId);

}
