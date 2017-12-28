package xmu.crms.demo.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.crms.demo.entity.Seminar;
import xmu.crms.demo.exception.CourseNotFoundException;
import xmu.crms.demo.exception.SeminarNotFoundException;
import xmu.crms.demo.mapper.SeminarMapper;
/**
 * 
 * @author lingyun
 *
 */
@Component
public class SeminarDao {
	
	@Autowired
	private SeminarMapper seminarMapper;


	public List<Seminar> listSeminarByCourseId(BigInteger courseId) 
		throws IllegalArgumentException, CourseNotFoundException {
			
		return seminarMapper.listSeminarByCourseId(courseId);
	}

	
	public Boolean deleteSeminarByCourseId(BigInteger courseId) 
			throws IllegalArgumentException, CourseNotFoundException {
		
		Integer rows = seminarMapper.deleteSeminarByCourseId(courseId);	
		if(rows > 0) {
			return true;
		} else {
			throw new CourseNotFoundException("can not find the course!");
		}
	}

	
	public Seminar getSeminarBySeminarId(BigInteger seminarId) 
		throws IllegalArgumentException, SeminarNotFoundException {
		
		return seminarMapper.getSeminarBySeminarId(seminarId);
	}

	
	public Boolean updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar) 
			throws IllegalArgumentException, SeminarNotFoundException {
		
		Integer rows = seminarMapper.updateSeminarBySeminarId(seminarId, seminar);	
		if(rows > 0) {
			return true;
		} else {
			throw new SeminarNotFoundException("can not find the seminar!");
		}
	}


	public Boolean deleteSeminarBySeminarId(BigInteger seminarId) 
			throws IllegalArgumentException, SeminarNotFoundException {
		
		Integer rows = seminarMapper.deleteSeminarBySeminarId(seminarId);	
		if(rows > 0) {
			return true;
		} else {
			throw new SeminarNotFoundException("can not find the seminar!");
		}
	}

	public BigInteger insertSeminarByCourseId(BigInteger courseId, Seminar seminar) 
			throws IllegalArgumentException, CourseNotFoundException{
		
		Integer rows = seminarMapper.insertSeminarByCourseId(courseId, seminar);
		if(rows > 0) {
			return seminar.getId();
		} else {
			throw  new CourseNotFoundException("can not find the course!");
		}
	}


}
