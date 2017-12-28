package xmu.crms.demo.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xmu.crms.demo.dao.SchoolDao;
import xmu.crms.demo.entity.School;
import xmu.crms.demo.service.SchoolService;

/**
 * 
 * @author lingyun
 *
 */
@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolDao schoolDAO;
		
	
	
	@Override
	public List<School> listSchoolByCity(String city) {
		
		return schoolDAO.listSchoolByCity(city);
	}

	@Override
	public BigInteger insertSchool(School school) {
		
		return schoolDAO.insertSchool(school);
	}

	@Override
	public List<String> listProvince() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listCity(String province) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School getSchoolBySchoolId(BigInteger schoolId) {
		
		return schoolDAO.getSchoolBySchoolId(schoolId);
	}

}
