package com.db.sys.service;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
public interface SysLogService {
	 /**
	  * 基于id删除日志记录
	  * @param ids
	  * @return
	  */
	 int deleteObjects(Integer...ids);
	 
	 /**
	  * 基于查询条件分页查询当前日志行为数据
	  * @param username 页面输入的用户名
	  * @param pageCurrent 当前页码值
	  * @return
	  */
	 PageObject<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);
}
