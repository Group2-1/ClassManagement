package xmu.crms.demo.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xmu.crms.demo.entity.School;
import xmu.crms.demo.mapper.SchoolMapper;
/**
 * 
 * @author lingyun
 *
 */
@Component
public class SchoolDao {
	
	@Autowired
	private SchoolMapper schoolMapper;

	
	public List<School> listSchoolByCity(String city) {
		
		return schoolMapper.listSchoolByCity(city);
	}

	
	public BigInteger insertSchool(School school) {
		Integer rows = schoolMapper.insertSchool(school);
		if(rows>0) {
			return school.getId();
			
		} else {
			return BigInteger.valueOf(-1);
		}
			
	}

	public School getSchoolBySchoolId(BigInteger schoolId) {
		// TODO Auto-generated method stub
		return schoolMapper.getSchoolBySchoolId(schoolId);
	}
	
	
	

}
