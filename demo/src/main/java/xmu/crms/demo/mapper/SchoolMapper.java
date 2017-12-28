package xmu.crms.demo.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import xmu.crms.demo.entity.School;

/**
 * 
 * @author lingyun
 *
 */
@Mapper
public interface SchoolMapper {
	
	
    List<School> listSchoolByCity(String city);

    Integer insertSchool(School school);

	School getSchoolBySchoolId(BigInteger schoolId);

      
   /* @Select("select city from school where province = #{province}")
	List<String> listCity(String province);*/

   /* @Select("select distinct province from school order by province desc")
	List<String> listProvince();*/

   /*@Select("select 'name' from school where id = #{schoolId}")
	School getSchoolBySchoolId(BigInteger schoolId);*/


}
