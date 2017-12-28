package xmu.crms.demo.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.demo.dao.SeminarDao;
import xmu.crms.demo.entity.Course;
import xmu.crms.demo.entity.Seminar;
import xmu.crms.demo.exception.CourseNotFoundException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.service.SeminarService;
/**
 * 
 * @author lingyun
 *
 */
@Service("SeminarService")
public class SeminarServiceImpl implements SeminarService {

	
	@Autowired
	private SeminarDao seminarDAO;
	
	@Override
	public List<Seminar> listSeminarByCourseId(BigInteger courseId)
			throws IllegalArgumentException, CourseNotFoundException {
       
		if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException("courseId");
		} else {
			return seminarDAO.listSeminarByCourseId(courseId);
		}
	}

	@Override
	public Boolean deleteSeminarBySeminarId(BigInteger seminarId)
			throws IllegalArgumentException, SeminarNotFoundException {

		if (seminarId.intValue() <= 0) {
            throw new IllegalArgumentException("seminarId");
		}
		return seminarDAO.deleteSeminarBySeminarId(seminarId);
	}
	
	@Override
	public Boolean deleteSeminarByCourseId(BigInteger courseId)
			throws IllegalArgumentException, CourseNotFoundException {

		if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException("courseId");
		}
        List<Seminar> seminars = seminarDAO.listSeminarByCourseId(courseId);
        Boolean isDeleted=null;
        for (Seminar seminar : seminars
                ) {
            try {
				isDeleted =  seminarDAO.deleteSeminarBySeminarId(seminar.getId());
			} catch (SeminarNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return isDeleted;
	}

	@Override
	public Seminar getSeminarBySeminarId(BigInteger seminarId)
			throws IllegalArgumentException, SeminarNotFoundException {

		return seminarDAO.getSeminarBySeminarId(seminarId);
	}

	@Override
	public Boolean updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar)
			throws IllegalArgumentException, SeminarNotFoundException {
		
		if (seminarId.intValue() <= 0) {
            throw new IllegalArgumentException("seminarId");
		}
		seminar.setId(seminarId);
		return seminarDAO.updateSeminarBySeminarId(seminarId, seminar);
			
	}

	@Override
	public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar)
			throws IllegalArgumentException, CourseNotFoundException {

		if (courseId.intValue() <= 0) {
            throw new IllegalArgumentException("seminarId"); 
        }
		seminar.setId(seminarDAO.insertSeminarByCourseId(courseId, seminar));
		Course course = new Course();
		course.setId(courseId);
		seminar.setCourse(course);
		return seminar.getId();
		
	}

}
