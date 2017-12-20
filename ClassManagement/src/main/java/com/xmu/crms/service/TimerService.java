package com.xmu.crms.service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * 
 * @author qinlingyun liuaiqi
 * @version 2.00
 */
@Component
public interface TimerService {

	public void insertEvent(Date time, Bean beanName, HashMap<Integer, String> paramMap);	
		
	//需要设置定时器的方法：
		/**
		 * 讨论课结束后计算展示得分.
		 * <p>条件: 讨论课已结束<br>
		 * @author qinlingyun
		 */
		//void countPresentationGrade();
		
		
		/**
		 * 讨论课结束后计算本次讨论课得分.
		 * <p>条件: 讨论课已结束，展示得分已算出<br>
		 * @author qinlingyun
		 */
		//void countGroupGradeBySerminarId();		
		
		/**
		 * 课前将固定小组复制一份作为讨论课小组名单.
		 * <p>每天7点到21点 每半小时触发一次<br>
		 * <p>条件: 讨论课上课前<br>
		 * @author qinlingyun
		 */
		//void fixedGroupToSeminarGroup();

		/**
		 * 课堂结束后设置缺勤的名单.
		 * <p>点名结束后是迟到，此时学生仍可以签到，课程结束后则是缺勤<br>
		 * <p>条件: 课堂结束后<br>
		 * @author qinlingyun
		 */
		//void updateAbsentListByClassId();

	
		/**
		 * 讨论课开始前随机分组  (此方法已有，自动分组).
		 * <p>条件: 讨论课开始前<br>
		 * @author qinlingyun
		 */
		//void automaticallyGrouping(BigInteger seminarId,BigInteger classId);
		
}
