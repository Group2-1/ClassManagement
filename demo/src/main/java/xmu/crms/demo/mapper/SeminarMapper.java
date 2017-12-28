package xmu.crms.demo.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import xmu.crms.demo.entity.Seminar;
/**
 * 
 * @author lingyun
 *
 */
@Mapper
public interface SeminarMapper {
	
	
	List<Seminar> listSeminarByCourseId(BigInteger courseId);

	
	Integer deleteSeminarByCourseId(BigInteger courseId);

	Seminar getSeminarBySeminarId(BigInteger seminarId);


	Integer updateSeminarBySeminarId(BigInteger seminarId, Seminar seminar);

	

	Integer deleteSeminarBySeminarId(BigInteger seminarId);


	Integer insertSeminarByCourseId(BigInteger courseId, Seminar seminar);

}
